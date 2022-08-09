package com.jianpiao.api.service;

import com.jianpiao.api.exception.CinemaException;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> getAllCinemas(){
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(String cinemaId){
        return cinemaRepository.findById(cinemaId).orElseThrow(()->new CinemaException(CinemaException.CINEMA_NOT_FOUND));
    }


}
