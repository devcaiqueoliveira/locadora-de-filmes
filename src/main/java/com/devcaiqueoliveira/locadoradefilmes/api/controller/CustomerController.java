package com.devcaiqueoliveira.locadoradefilmes.api.controller;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.customer.CustomerRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.service.CustomerService;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Cpf;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Email;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Name;
import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerRequestDTO dto) {
        Customer customer = new Customer(
                new Name(dto.name()),
                new Email(dto.email()),
                new Cpf(dto.cpf())
        );

        customerService.registerCustomer(customer);
    }

    @GetMapping("/{id]")
    public CustomerRequestDTO findCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        return toResponseDTO(customer);
    }

    private CustomerRequestDTO toResponseDTO(Customer customer) {
        return new CustomerRequestDTO(
                customer.getName(),
                customer.getEmail(),
                customer.getCpf()
        );
    }


}
