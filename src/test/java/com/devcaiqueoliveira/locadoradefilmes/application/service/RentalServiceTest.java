package com.devcaiqueoliveira.locadoradefilmes.application.service;

import com.devcaiqueoliveira.locadoradefilmes.domain.common.Cpf;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Email;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Name;
import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.ResourceNotFoundException;
import com.devcaiqueoliveira.locadoradefilmes.domain.movie.*;
import com.devcaiqueoliveira.locadoradefilmes.repository.CustomerRepository;
import com.devcaiqueoliveira.locadoradefilmes.repository.MovieRepository;
import com.devcaiqueoliveira.locadoradefilmes.repository.RentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class RentalServiceTest {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalRepository rentalRepository;


    @Test
    void shouldRentMovieAndDecreaseStock() {

        Customer customer = new Customer(
                new Name("Tester"),
                new Email("tester@email.com"),
                new Cpf("12345678910")
        );

        Movie movie = new Movie(
                new Title("Filme Teste"),
                Genre.ACAO,
                new Description("Descricao do filme aqui"),
                LocalDate.now(),
                new Duration(60),
                new Stock(20)
        );

        customerRepository.save(customer);
        movieRepository.save(movie);

        rentalService.rentMovie(customer.getId(), movie.getId());

        Movie updatedMovie = movieRepository.findById(movie.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));

        updatedMovie.getStockAmount();

        assertEquals(19, updatedMovie.getStockAmount());
        assertEquals(1, rentalRepository.count());
    }
}
