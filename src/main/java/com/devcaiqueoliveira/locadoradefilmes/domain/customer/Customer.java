package com.devcaiqueoliveira.locadoradefilmes.domain.customer;

import com.devcaiqueoliveira.locadoradefilmes.domain.common.Cpf;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Email;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Name;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "name")
    private Name name;

    @Column(name = "email")
    private Email email;

    @Column(name = "cpf")
    private Cpf cpf;

    protected Customer() {
        
    }

    public Customer(Name name, Email email, Cpf cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public String getName() {
        return name.getName();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getCpf() {
        return cpf.getCpf();
    }
}
