package com.devcaiqueoliveira.locadoradefilmes.application.dto.rental;

public record RentalRequestDTO (
        Long customerId,
        Long movieId
) {

}
