package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cinema_film", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaFilm {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Film film;

    private String status;

}