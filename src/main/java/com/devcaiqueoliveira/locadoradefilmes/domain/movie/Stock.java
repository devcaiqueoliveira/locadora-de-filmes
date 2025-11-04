package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieStockException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@EqualsAndHashCode
@Getter
public class Stock {

    @Column(name = "stock")
    private int stock;

    protected Stock() {
    }

    public Stock(int stock) {
        validate(stock);
        this.stock = stock;
    }

    private void validate(int stock) {
        if (stock < 0) {
            throw new InvalidMovieDataException("O estoque inicial não pode ser negativo");
        }
    }

    public Stock increase() {
        int newAmount = this.stock + 1;
        return new Stock(newAmount);
    }

    public Stock decrease() {
        if (this.stock == 0) {
            throw new InvalidMovieStockException("Atualmente não existem cópias diponíveis deste filme.");
        }
        int newAmount = this.stock - 1;
        return new Stock(newAmount);
    }

    public Stock add(int quantity) {
        if (quantity <= 0) {
            throw new InvalidMovieDataException("A quantidade a se adicionar deve ser maior que zero.");
        }
        int newAmount = this.stock + quantity;
        return new Stock(newAmount);
    }

    public Stock remove(int quantity) {
        if (quantity <= 0) {
            throw new InvalidMovieDataException("A quantidade a se remover deve ser positiva.");
        }
        int newAmount = this.stock - quantity;
        if (newAmount < 0) {
            throw new InvalidMovieDataException(
                    "Não foi possível remover "
                            + quantity + " cópias. Apenas"
                            + this.stock + " estão disponíveis."
            );
        }
        return new Stock(newAmount);
    }
}
