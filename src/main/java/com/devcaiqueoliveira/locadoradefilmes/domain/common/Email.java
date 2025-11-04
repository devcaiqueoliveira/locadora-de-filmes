package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import com.devcaiqueoliveira.locadoradefilmes.domain.common.util.ValidationUtils;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidUserDataException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class Email {

    @Column(name = "email")
    private String email;

    protected Email() {

    }

    public Email(String email) {
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
        ValidationUtils.notNullOrBlank(email, () ->
                new InvalidUserDataException("O email do úsuario não pode estar vazio ou ser nulo"));
        ValidationUtils.checkEmailFormat(email, () ->
                new InvalidUserDataException("Email inválido. Tente algo como: example@example.com"));
    }
}
