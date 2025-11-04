package com.devcaiqueoliveira.locadoradefilmes.repository;

import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
