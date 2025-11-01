package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Description {
    private static final int MIN_DESCRIPTION_LENGTH = 10;
    private static final int MAX_DESCRIPTION_LENGTH = 300;

    @Column(name = "description")
    @Getter
    private String description;

    protected Description() {
    }

    public Description(String description) {
        validate(description);
        this.description = description;
    }

    private void validate(String description) {
        if (description == null || description.isBlank()) {
            throw new InvalidMovieDataException("A descrição do filme precisa ser obrigatoriamente preenchida.");
        }
        if (description.length() < MIN_DESCRIPTION_LENGTH || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new InvalidMovieDataException(
                    "A descrição do filme precisa ter entre"
                            + MIN_DESCRIPTION_LENGTH + " e "
                            + MAX_DESCRIPTION_LENGTH + " caracteres."
            );
        }
    }
}
