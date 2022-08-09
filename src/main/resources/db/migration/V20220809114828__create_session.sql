CREATE TABLE if not exists public.tb_session (
	id varchar NOT NULL,
	film_id varchar NOT NULL,
	hall_id varchar NOT NULL,
	cinema_id varchar NOT NULL,
	"date" date NOT NULL,
	start_time varchar NOT NULL,
	end_time varchar NOT NULL,
	price double precision NOT NULL,
	site varchar NOT NULL,
	CONSTRAINT tb_session_pk PRIMARY KEY (id)
);