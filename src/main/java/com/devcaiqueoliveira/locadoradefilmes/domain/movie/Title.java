package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.util.ValidationUtils;
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
        ValidationUtils.notNullOrBlank(title, () ->
                new InvalidMovieDataException("O título do filme não pode ser nulo ou estar vazio.")
        );
    }
}
