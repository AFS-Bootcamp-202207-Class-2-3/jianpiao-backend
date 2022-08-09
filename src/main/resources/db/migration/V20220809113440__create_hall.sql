CREATE TABLE if not exists public.tb_hall (
	id varchar(255) NOT NULL,
	cinema_id varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	x_size varchar(10) NOT NULL,
	site varchar(255) NOT NULL,
	CONSTRAINT hall_pk PRIMARY KEY (id)
);