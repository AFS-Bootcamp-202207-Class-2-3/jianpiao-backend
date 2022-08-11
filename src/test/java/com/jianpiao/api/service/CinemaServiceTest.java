package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.model.dto.CinemaAdminRequest;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.UserCinema;
import com.jianpiao.api.repository.CinemaRepository;
import com.jianpiao.api.repository.UserCinemaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
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

    @Mock
    UserCinemaRepository userCinemaRepository;

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

    // @Test
    // void should_return_admin_cinema_when_get_cinema_by_login_user_id_given_none() {
    //     //given
    //     String userId = "1";
    //     String cinemaId = "111";
    //     UserCinema userCinema = new UserCinema("1", userId, cinemaId);
    //     List<UserCinema> userCinemaList = new ArrayList<>();
    //     userCinemaList.add(userCinema);
    //     when(userCinemaRepository.findAllByUserId(userId)).thenReturn(userCinemaList);
    //
    //     Cinema cinemaMock = new Cinema(cinemaId, "cinema one", "zhuhai", "123");
    //     UserCinema userCinemaFind = userCinemaRepository.findAllByUserId(userId).stream().findFirst().get();
    //     String cinemaQueryId = userCinemaFind.getCinemaId();
    //     when(cinemaRepository.findById(cinemaQueryId)).thenReturn(Optional.of(cinemaMock));
    //
    //     MockedStatic<StpUtil> mockedStatic = Mockito.mockStatic(StpUtil.class);
    //     mockedStatic.when(StpUtil::getLoginId).thenReturn("1");
    //     //when
    //     Cinema cinema = cinemaService.getAdminCinema();
    //
    //     //then
    //     assertEquals("111", cinema.getId());
    //     assertEquals("zhuhai", cinema.getAddress());
    // }

    // @Test
    // void should_return_admin_update_cinema_when_update_cinema__given_new_cinema() {
    //     //given
    //     String cinemaId = "111";
    //     Cinema cinemaOld = new Cinema(cinemaId, "cinema one", "zhuhai", "123");
    //     when(cinemaRepository.findById(cinemaId)).thenReturn(Optional.of(cinemaOld));
    //
    //     Cinema cinemaUpdate = new Cinema(cinemaId, "cinema two", "zhuhai", "123");
    //     when(cinemaRepository.save(cinemaUpdate)).thenReturn(cinemaUpdate);
    //
    //     // MockedStatic<StpUtil> mockedStatic = Mockito.mockStatic(StpUtil.class);
    //     // mockedStatic.when(StpUtil::getLoginId).thenReturn("1");
    //     //when
    //     CinemaAdminRequest cinemaAdminRequest = new CinemaAdminRequest();
    //     cinemaAdminRequest.setAddress(cinemaUpdate.getAddress());
    //     cinemaAdminRequest.setContactNumber(cinemaUpdate.getContactNumber());
    //     Cinema cinema = cinemaService.updateAdminCinema(cinemaId, cinemaAdminRequest);
    //
    //     //then
    //     assertEquals("111", cinema.getId());
    //     assertEquals("cinema two", cinema.getAddress());
    // }


}