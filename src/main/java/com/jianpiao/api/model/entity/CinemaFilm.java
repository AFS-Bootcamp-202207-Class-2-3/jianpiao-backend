package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema_film", schema = "public")
public class CinemaFilm {

    @Id
    private String id;

    private String cinemaId;

    private String filmId;

    private String status;
}
