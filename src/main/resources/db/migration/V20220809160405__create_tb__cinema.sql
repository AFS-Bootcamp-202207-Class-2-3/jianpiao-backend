CREATE TABLE if not exists public.tb_cinema (
	id varchar NOT NULL,
	cinema_name varchar not null,
	address varchar not null,
	contact_number varchar not null,
	CONSTRAINT tb_cinema_pk PRIMARY KEY (id)
);