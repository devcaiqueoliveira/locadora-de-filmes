package com.devcaiqueoliveira.locadoradefilmes.repository;

import com.devcaiqueoliveira.locadoradefilmes.domain.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
