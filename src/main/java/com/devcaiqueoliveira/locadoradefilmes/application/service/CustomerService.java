package com.devcaiqueoliveira.locadoradefilmes.application.service;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.customer.CustomerRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Cpf;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Email;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Name;
import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.ResourceNotFoundException;
import com.devcaiqueoliveira.locadoradefilmes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void updateCustomer(Long id, CustomerRequestDTO dto) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }

        Customer updatedCustomer = new Customer(
                new Name(dto.name()),
                new Email(dto.email()),
                new Cpf(dto.cpf())
        );

        updatedCustomer.setId(id);

        customerRepository.save(updatedCustomer);
    }

    @Transactional
    public void unregisterCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
