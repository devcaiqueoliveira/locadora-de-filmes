package com.devcaiqueoliveira.locadoradefilmes.application.dto.customer;

public record CustomerResponseDTO(
        Long id,
        String name,
        String email,
        String cpf
) {
}
