package com.devcaiqueoliveira.locadoradefilmes.application.service;

import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.MovieNotFoundException;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.ResourceNotFoundException;
import com.devcaiqueoliveira.locadoradefilmes.domain.movie.Movie;
import com.devcaiqueoliveira.locadoradefilmes.domain.rental.Rental;
import com.devcaiqueoliveira.locadoradefilmes.repository.CustomerRepository;
import com.devcaiqueoliveira.locadoradefilmes.repository.MovieRepository;
import com.devcaiqueoliveira.locadoradefilmes.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class RentalService {

    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(MovieRepository movieRepository,
                         CustomerRepository customerRepository,
                         RentalRepository rentalRepository) {
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
    }

    @Transactional
    public void rentMovie(Long customerId, Long movieId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Filme não encontrado."));

        movie.decreaseMovieStock();

        Rental newRental = new Rental(customer, movie, LocalDate.now());
        rentalRepository.save(newRental);
    }

    @Transactional
    public void returnMovie(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado."));

        if (rental.getReturnDate() != null) {
            throw new RuntimeException("O filme já foi devolvido.");
        }

        rental.setReturnDate(LocalDate.now());
        rental.getMovie().increaseMovieStock();
    }
}
