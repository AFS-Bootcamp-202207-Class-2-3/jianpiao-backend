update tb_session
set end_time = '21:00'
where id = '11';
update tb_hall
set name = '三号厅'
where id = '3';
update tb_film
set poster_url = 'https://s1.328888.xyz/2022/08/11/63sBr.webp'
where id = '15';

INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('12', '4', '1', '1', '2022-08-12', '12:00', '14:10', 20.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('13', '5', '1', '1', '2022-08-12', '14:30', '16:00', 26.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('14', '6', '1', '1', '2022-08-12', '16:10', '18:00', 28.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('15', '7', '1', '1', '2022-08-12', '18:00', '20:10', 40.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('16', '8', '1', '1', '2022-08-12', '20:20', '22:20', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');

INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('17', '5', '2', '1', '2022-08-12', '12:00', '13:30', 20.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('18', '9', '2', '1', '2022-08-12', '13:40', '15:50', 26.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('19', '7', '2', '1', '2022-08-12', '15:50', '17:20', 28.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('20', '8', '2', '1', '2022-08-12', '17:30', '19:20', 40.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('21', '10', '2', '1', '2022-08-12', '19:20', '21:50', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');

INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('22', '10', '3', '1', '2022-08-12', '12:00', '14:30', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('23', '4', '3', '1', '2022-08-12', '14:40', '16:50', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('24', '9', '3', '1', '2022-08-12', '17:00', '19:20', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('25', '6', '3', '1', '2022-08-12', '19:20', '21:10', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');



INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('26', '15', '1', '1', '2022-08-13', '12:00', '14:20', 20.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('27', '16', '1', '1', '2022-08-13', '14:30', '16:40', 26.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('28', '5', '1', '1', '2022-08-13', '16:40', '18:10', 28.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('29', '9', '1', '1', '2022-08-13', '18:10', '20:20', 40.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('30', '8', '1', '1', '2022-08-13', '20:20', '22:20', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');

INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('31', '8', '2', '1', '2022-08-13', '12:00', '14:00', 20.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('32', '10', '2', '1', '2022-08-13', '14:10', '16:20', 26.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('33', '4', '2', '1', '2022-08-13', '16:20', '18:30', 28.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('34', '16', '2', '1', '2022-08-13', '18:30', '20:40', 40.30,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('35', '15', '2', '1', '2022-08-13', '20:40', '22:50', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');

INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('36', '10', '3', '1', '2022-08-13', '12:00', '14:20', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('37', '5', '3', '1', '2022-08-13', '14:20', '15:50', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('38', '9', '3', '1', '2022-08-13', '18:00', '20:20', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');
INSERT INTO public.tb_session (id, film_id, hall_id, cinema_id, date, start_time, end_time, price, site)
VALUES ('39', '6', '3', '1', '2022-08-13', '20:20', '22:10', 30.50,
        '11111111111111111111111111111111111111111111111111111111111111111111111111111');