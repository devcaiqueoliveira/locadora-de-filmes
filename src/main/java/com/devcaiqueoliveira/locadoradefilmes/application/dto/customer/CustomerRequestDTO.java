package com.devcaiqueoliveira.locadoradefilmes.application.dto.customer;

public record CustomerRequestDTO(
        String name,
        String email,
        String cpf
) {
}
