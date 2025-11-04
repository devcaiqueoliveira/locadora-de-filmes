package com.devcaiqueoliveira.locadoradefilmes.api.controller;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.MovieRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.service.MovieService;
import com.devcaiqueoliveira.locadoradefilmes.domain.movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public void createMovie(@RequestBody MovieRequestDTO dto) {
        Movie movie = new Movie(
                new Title(dto.title()),
                dto.genre(),
                new Description(dto.description()),
                dto.releaseDate(),
                new Duration(dto.duration()),
                new Stock(dto.stock())
        );

        movieService.registerMovie(movie);
    }

    @GetMapping
    public Movie findMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }
}
