package com.devcaiqueoliveira.locadoradefilmes.application.service;

import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
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
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public void unregisterCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
