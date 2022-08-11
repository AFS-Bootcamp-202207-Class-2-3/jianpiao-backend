package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.exception.ParamNotSatisfiedException;
import com.jianpiao.api.mapper.FilmMapper;
import com.jianpiao.api.model.dto.PageUtils;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.CinemaFilm;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.UserCinema;
import com.jianpiao.api.repository.CinemaRepository;
import com.jianpiao.api.repository.FilmCinemaRepository;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.UserCinemaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmCinemaRepository filmCinemaRepository;

    private final FilmRepository filmRespository;

    private final CinemaRepository cinemaRepository;

    private final UserCinemaRepository userCinemaRepository;

    public FilmService(FilmCinemaRepository filmCinemaRepository, FilmRepository filmRespository, CinemaRepository cinemaRepository, UserCinemaRepository userCinemaRepository) {
        this.filmCinemaRepository = filmCinemaRepository;
        this.filmRespository = filmRespository;
        this.cinemaRepository = cinemaRepository;
        this.userCinemaRepository = userCinemaRepository;
    }

    public List<Film> getAllFilms() {
        List<Film> films = filmRespository.findAll();
        return films;
    }

    public Film findFilmById(String id) {
        Film film = filmRespository.findById(id).orElseThrow(FilmNotFoundException::new);
        return film;
    }

    public Film addFilm(Film film) {
        Film saveFilm = filmRespository.save(film);
        return saveFilm;
    }

    public List<Film> getFilmsByCinemaIdAndStatus(String cinemaId, String status) {
        List<String> filmIds = filmCinemaRepository.findAllByCinemaIdAndStatus(cinemaId, status).stream()
                .map(CinemaFilm::getFilmId)
                .collect(Collectors.toList());
        return filmRespository.findAllById(filmIds);
    }

    public List<Film> getShowingFilmsByCinemaId(String cinemaId) {
        return getFilmsByCinemaIdAndStatus(cinemaId, "showing");
    }

    public List<Cinema> getManageCinemasByUserId(String userId) {
        List<String> cinemaIds = userCinemaRepository.findAllByUserId(userId).stream()
                .map(UserCinema::getCinemaId)
                .collect(Collectors.toList());
        return cinemaRepository.findAllById(cinemaIds);
    }

    public PageUtils getPageByParams(Map<String, Object> param) {
        PageUtils pageUtils;
        try{
            String status = param.get("status").toString();
            int start = Integer.parseInt(param.get("start").toString());
            int size = Integer.parseInt(param.get("size").toString());
            Pageable pageable = PageRequest.of(start-1, size);

            List<String> manageCinemaIds = getManageCinemasByUserId(StpUtil.getLoginId().toString()).stream()
                    .map(Cinema::getId)
                    .collect(Collectors.toList());

            List<HashMap> data = filmCinemaRepository.findAllByStatusAndCinemaIdIn(status, manageCinemaIds, pageable).stream()
                    .map(filmCinema -> {
                        Film film = filmRespository.findById(filmCinema.getFilmId()).orElseThrow(FilmNotFoundException::new);
                        HashMap map = JSONUtil.parseObj(film).toBean(HashMap.class);
                        map.put("releasedTime", DateUtil.format(film.getReleasedTime(), "yyyy-MM-dd HH:mm:ss"));
                        map.put("cinemaId", filmCinema.getCinemaId());
                        map.put("status", filmCinema.getStatus());
                        map.put("film_cinema_id", filmCinema.getId());
                        return map;
                    })
                    .collect(Collectors.toList());

            pageUtils = new PageUtils(data,
                    filmCinemaRepository.findAllByStatusAndCinemaIdIn(status, manageCinemaIds).size(),
                    start,size);
        }catch (Exception e){
            throw new ParamNotSatisfiedException();
        }
        return pageUtils;
    }

    public Film getEntityById(String id) {
        return filmRespository.findById(id).orElseThrow(FilmNotFoundException::new);
    }

    public Film createFilmCinema(HashMap params) {
        Film savedFilm = filmRespository.save(JSONUtil.parseObj(params).toBean(Film.class));
        List<String> cinemaIds = JSONUtil.parseArray(params.get("cinemaIds")).stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        cinemaIds.forEach(cinemaId->{
            String id = UUID.randomUUID().toString();
            CinemaFilm cinemaFilm = new CinemaFilm(id, cinemaId, savedFilm.getId(), MapUtil.getStr(params, "status"));
            filmCinemaRepository.save(cinemaFilm);
        });
        return savedFilm;
    }
    
    // todo

    public Film update(Film film) {
        return filmRespository.save(film);
    }

    public void removeByIds(List<String> ids) {
        filmCinemaRepository.deleteAllById(ids);
    }
}
