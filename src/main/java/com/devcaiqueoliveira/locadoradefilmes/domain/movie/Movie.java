package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Embedded
    private Title title;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    @Getter
    private Genre genre;

    @Embedded
    private Description description;

    @Column(name = "release_date")
    @Getter
    private LocalDate releaseDate;

    @Embedded
    private Duration duration;

    @Embedded
    private Stock stock;

    protected Movie() {

    }

    public Movie(Title title, Description description, Duration duration, Stock stock) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.stock = stock;
    }

    public String getTitle() {
        return this.title.getTitle();
    }

    public String getDescription() {
        return this.description.getDescription();
    }

    public int getDuration() {
        return this.duration.getDuration();
    }

    public int getStock() {
        return this.stock.getStock();
    }

    public void increaseMovieStock() {
        this.stock = this.stock.increase();
    }

    public void decreaseMovieStock() {
        this.stock = this.stock.decrease();
    }

    public void addMovieStock(int quantity) {
        this.stock = this.stock.add(quantity);
    }

    public void removeMovieStock(int quantity) {
        this.stock = this.stock.remove(quantity);
    }

}
