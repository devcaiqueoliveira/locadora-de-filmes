package com.devcaiqueoliveira.locadoradefilmes.api.controller;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.movie.MovieRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.dto.movie.MovieResponseDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.service.MovieService;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import com.devcaiqueoliveira.locadoradefilmes.domain.movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieRequestDTO dto) {
        movieService.registerMovie(dto);
    }

    @GetMapping("/{id}")
    public MovieResponseDTO findMovieById(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        return toResponseDTO(movie);
    }

    @GetMapping
    public Collection<MovieResponseDTO> listAllMovies() {
        return movieService.listAllMovies().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMovie(@PathVariable Long id, @RequestBody MovieRequestDTO dto) {
        movieService.updateMovie(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unregisterMovie(@PathVariable Long id) {
        movieService.unregisterMovie(id);
    }

    private MovieResponseDTO toResponseDTO(Movie movie) {
        return new MovieResponseDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getDescription(),
                movie.getReleaseDate(),
                movie.getDuration(),
                movie.getStockAmount()
        );
    }
}
