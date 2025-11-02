package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Cpf {

    @Column(name = "cpf")
    private String cpf;

    protected Cpf() {
    }


}
