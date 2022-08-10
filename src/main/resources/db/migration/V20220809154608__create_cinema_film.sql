create table if not exists public.cinema_film
(
    id   varchar(255) primary key not null,
    cinema_id varchar(255),
    film_id varchar(255),
    status varchar(255)
);