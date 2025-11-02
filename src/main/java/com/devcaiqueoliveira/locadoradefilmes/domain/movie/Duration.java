package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class Duration {
    private static final int MIN_DURATION = 15;
    private static final int MAX_DURATION = 210;

    @Column(name = "duration")
    @Getter
    private int duration;

    protected Duration() {
    }

    public Duration(int duration) {
        validate(duration);
        this.duration = duration;
    }

    private void validate(int duration) {
        if (duration < MIN_DURATION || duration > MAX_DURATION) {
            throw new InvalidMovieDataException(
                    "A duração do filme precisa estar entre "
                            + MIN_DURATION + " a "
                            + MAX_DURATION + " minutos");
        }
    }
}