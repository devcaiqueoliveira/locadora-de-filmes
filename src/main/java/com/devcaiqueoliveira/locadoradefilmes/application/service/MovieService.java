package com.devcaiqueoliveira.locadoradefilmes.application.service;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.MovieRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.ResourceNotFoundException;
import com.devcaiqueoliveira.locadoradefilmes.domain.movie.*;
import com.devcaiqueoliveira.locadoradefilmes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public void registerMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional(readOnly = true)
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public void updateMovie(Long id, MovieRequestDTO dto) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Filme não encontrado.");
        }

        Movie updatedMovie = new Movie(
                new Title(dto.title()),
                dto.genre(),
                new Description(dto.description()),
                dto.releaseDate(),
                new Duration(dto.duration()),
                new Stock(dto.stock())
        );

        updatedMovie.setId(id);

        movieRepository.save(updatedMovie);
    }

    @Transactional
    public void unregisterMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
