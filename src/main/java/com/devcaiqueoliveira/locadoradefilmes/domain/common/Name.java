package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidNameException;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.util.ValidationUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {

    @Column(name = "name")
    private String name;

    protected Name() {
    }

    public Name(String name) {
        this.name = name;
    }

    private void validate(String name) {
        ValidationUtils.notNullOrBlank(name, () ->
                new InvalidNameException("O nome do úsuario não pode estar vazio ou ser nulo."));
    }
}
