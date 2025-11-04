package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import com.devcaiqueoliveira.locadoradefilmes.domain.common.util.ValidationUtils;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidUserDataException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class Name {

    @Column(name = "name")
    private String name;

    protected Name() {
    }

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        ValidationUtils.notNullOrBlank(name, () ->
                new InvalidUserDataException("O nome do úsuario não pode estar vazio ou ser nulo."));
    }
}
