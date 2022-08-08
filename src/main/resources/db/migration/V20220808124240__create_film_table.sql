create table if not exists public.tb_film
(
    id   varchar(255) ,
    film_name varchar(255),
    introduction varchar(255),
    released_time timestamp	,
    duration int ,
    director varchar(255),
    leading_actor varchar(255),
    poster_url varchar(255),
    score numeric(3,1)
);