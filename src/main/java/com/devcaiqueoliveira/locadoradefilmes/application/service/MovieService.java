package com.devcaiqueoliveira.locadoradefilmes.application.service;

import com.devcaiqueoliveira.locadoradefilmes.domain.movie.Movie;
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
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional
    public void unregisterMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
