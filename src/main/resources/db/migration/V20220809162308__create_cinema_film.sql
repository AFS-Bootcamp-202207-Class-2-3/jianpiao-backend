CREATE TABLE if not exists public.cinema_film (
	id varchar NOT NULL,
	cinema_id varchar not null,
	film_id varchar not null,
	status varchar not null,
	CONSTRAINT tb_cinema_film_pk PRIMARY KEY (id)
);