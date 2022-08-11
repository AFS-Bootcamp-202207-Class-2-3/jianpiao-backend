create table if not exists public.user_cinema
(
    id   varchar(255) primary key not null,
    user_id varchar(255),
    cinema_id varchar(255)
);