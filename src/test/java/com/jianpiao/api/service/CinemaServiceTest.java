package com.jianpiao.api.service;

import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.repository.CinemaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CinemaServiceTest {

    @InjectMocks
    CinemaService cinemaService;

    @Mock
    CinemaRepository cinemaRepository;

    @Test
    void should_return_cinemas_when_get_all_cinemas_given_none() {
        //given
        List<Cinema> cinemas = Arrays.asList(new Cinema("1", "cinema one", "zhuhai", "123"),
                new Cinema("2", "cinema two", "zhuhai", "123456"));
        when(cinemaRepository.findAll()).thenReturn(cinemas);

        //when
        List<Cinema> allCinemas = cinemaService.getAllCinemas();

        //then
        assertEquals(2, cinemas.size());
        assertEquals("cinema two", cinemas.get(1).getCinemaName());
    }

    @Test
    void should_return_cinema_when_get_cinema_by_id_given_cinema_id() {
        //given
        String cinemaId = "1";
        Cinema cinema = new Cinema(cinemaId, "cinema one", "zhuhai", "123");
        when(cinemaRepository.findById(cinemaId)).thenReturn(Optional.of(cinema));

        //when
        Cinema cinemaById = cinemaService.getCinemaById(cinemaId);

        //then
        assertEquals("1", cinemaById.getId());
        assertEquals("zhuhai", cinemaById.getAddress());
    }

}