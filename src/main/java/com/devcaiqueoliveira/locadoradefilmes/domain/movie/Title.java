package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Title {

    @Column(name = "title")
    @Getter
    private String title;

    protected Title() {
    }

    public Title(String title) {
        validate(title);
        this.title = title;
    }

    private void validate(String title) {
        if (title == null || title.isBlank()) {
            throw new InvalidMovieDataException("O campo de título do filme, não pode ser nulo ou vazio");
        }
    }
}
