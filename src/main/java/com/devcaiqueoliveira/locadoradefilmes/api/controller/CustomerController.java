package com.devcaiqueoliveira.locadoradefilmes.api.controller;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.customer.CustomerRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.dto.customer.CustomerResponseDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.service.CustomerService;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Cpf;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Email;
import com.devcaiqueoliveira.locadoradefilmes.domain.common.Name;
import com.devcaiqueoliveira.locadoradefilmes.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

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
    public CustomerResponseDTO findCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        return toResponseDTO(customer);
    }

    @GetMapping
    public Collection<CustomerResponseDTO> listAllCustomers() {
        return customerService.listAllCustomers().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDTO dto) {
        customerService.updateCustomer(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unregisterCustomer(@PathVariable Long id) {
        customerService.unregisterCustomer(id);
    }

    private CustomerResponseDTO toResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getCpf()
        );
    }


}
