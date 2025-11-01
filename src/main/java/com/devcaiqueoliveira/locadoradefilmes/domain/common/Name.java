package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {

    @Column(name = "name")
    private String name;

    protected Name() {

    }
}
