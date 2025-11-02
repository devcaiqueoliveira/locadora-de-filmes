package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.util.ValidationUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
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
        ValidationUtils.notNullOrBlank(description, () ->
                new InvalidMovieDataException("A descrição do filme não pode estar vazia ou ser nula.")
        );

        ValidationUtils.checkStringLength(description, MIN_DESCRIPTION_LENGTH, MAX_DESCRIPTION_LENGTH, () ->
                new InvalidMovieDataException("A descrição do filme precisa ter entre"
                        + MIN_DESCRIPTION_LENGTH + " e "
                        + MAX_DESCRIPTION_LENGTH + " caracteres.")
        );
    }
}