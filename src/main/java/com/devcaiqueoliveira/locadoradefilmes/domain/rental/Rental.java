package com.devcaiqueoliveira.locadoradefilmes.domain.rental;

import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import com.devcaiqueoliveira.locadoradefilmes.domain.movie.Movie;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @Getter
    private Movie movie;

    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "return_date")
    @Getter
    @Setter
    private LocalDate returnDate;

    public Rental(Customer customer, Movie movie, LocalDate rentalDate) {
        this.customer = customer;
        this.movie = movie;
        this.rentalDate = rentalDate;
        this.dueDate = rentalDate.plusDays(7);
    }
}
