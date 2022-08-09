ALTER TABLE public.tb_session ALTER COLUMN start_time TYPE time USING start_time::time;
ALTER TABLE public.tb_session ALTER COLUMN end_time TYPE time USING end_time::time;
