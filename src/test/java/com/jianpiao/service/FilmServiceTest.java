package com.jianpiao.service;

import cn.hutool.core.date.DateUtil;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.service.FilmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class FilmServiceTest {

    @InjectMocks
    private FilmService filmService;

    @Mock
    private FilmRepository filmRepository;



    @Test
    void should_return_films_list_when_call_get_all_api_given_service_is_up() {

        List<Film> films = new ArrayList<>();
        Film film1 = new Film("1", "爱在黎明破晓前", "简介", DateUtil.parse("1995-01-27", "yyyy-MM-dd"), 105, "Richard Linklater", "Ethan Hawke, Julie Delpy", "https://133.com", 4.5);
        films.add(film1);
        films.add(new Film("2", "爱在日落黄昏时", "简介2", DateUtil.parse("2004-07-02", "yyyy-MM-dd"), 80, "Richard Linklater", "Ethan Hawke, Julie Delpy", "https://133.com", 4.5));
        //when & then
        given(filmRepository.findAll()).willReturn(films);

        List<Film> allFilms = filmService.getAllFilms();
        assertThat(allFilms, hasSize(2));
        assertThat(allFilms.get(0), equalTo(film1));
    }

    @Test
    void should_return_a_specified_films_when_call_get_film_by_id_api_given_service_is_up() {


        Film film1 = new Film("1", "爱在黎明破晓前", "简介", DateUtil.parse("1995-01-27", "yyyy-MM-dd"), 105, "Richard Linklater", "Ethan Hawke, Julie Delpy", "https://133.com", 4.5);
         //when & then
        given(filmRepository.findById(film1.getId())).willReturn(Optional.of(film1));

        Film filmById = filmService.findFilmById(film1.getId());
        assertThat(filmById, equalTo(film1));
    }

    @Test
    void should_return_new_film_when_call_add_film_api_given_new_film_info() {
        //given
        Film film1 = new Film("1", "爱在黎明破晓前", "简介", DateUtil.parse("1995-01-27", "yyyy-MM-dd"), 105, "Richard Linklater", "Ethan Hawke, Julie Delpy", "https://133.com", 4.5);

        //when
        given(filmRepository.save(film1)).willReturn(film1);
        Film film = filmService.addFilm(film1);
        //then
        assertEquals(film.getFilmName(),film1.getFilmName());

    }
}
