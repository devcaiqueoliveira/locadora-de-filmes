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
public class Cpf {
    private static final int CPF_EXACT_LENGTH = 11;

    @Column(name = "cpf")
    private String cpf;

    protected Cpf() {
    }

    public Cpf(String cpf) {
        String formattedCpf = format(cpf);
        validate(formattedCpf);
        this.cpf = formattedCpf;
    }

    private String format(String cpf) {
        return cpf == null ? "" : cpf.replaceAll("\\D", "");
    }

    private void validate(String cpf) {
        ValidationUtils.checkExactLength(cpf, CPF_EXACT_LENGTH, () ->
                new InvalidUserDataException("CPF inválido. O CPF deve conter 11 dígitos numéricos."));
    }
}
