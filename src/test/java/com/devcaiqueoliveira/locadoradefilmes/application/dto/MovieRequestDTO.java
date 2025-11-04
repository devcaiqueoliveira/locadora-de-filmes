package com.devcaiqueoliveira.locadoradefilmes.application.dto;

import com.devcaiqueoliveira.locadoradefilmes.domain.movie.Genre;

import java.time.LocalDate;

public record MovieRequestDTO(
        String title,
        Genre genre,
        String description,
        LocalDate releaseDate,
        int duration,
        int stock
) {
}
