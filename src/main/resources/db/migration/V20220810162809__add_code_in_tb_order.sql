alter table public.tb_order add code varchar(255) NULL;
update tb_order set create_time = '2022-08-10', code = now();