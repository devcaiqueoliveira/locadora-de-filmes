package com.devcaiqueoliveira.locadoradefilmes.api.controller;

import com.devcaiqueoliveira.locadoradefilmes.application.dto.rental.RentalRequestDTO;
import com.devcaiqueoliveira.locadoradefilmes.application.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void rentMovie(@RequestBody RentalRequestDTO rentalRequestDTO) {
        rentalService.rentMovie(
                rentalRequestDTO.customerId(),
                rentalRequestDTO.movieId()
        );
    }

    @PostMapping("/{id}/return")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
    }
}
