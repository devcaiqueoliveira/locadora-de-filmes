package com.devcaiqueoliveira.locadoradefilmes.application.dto.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.movie.Genre;

import java.time.LocalDate;

public record MovieResponseDTO(
        Long id,
        String title,
        Genre genre,
        String description,
        LocalDate releaseDate,
        int duration,
        int stock
) {
}
