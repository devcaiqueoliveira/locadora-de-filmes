package com.devcaiqueoliveira.locadoradefilmes.domain.rental;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rentals")
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
