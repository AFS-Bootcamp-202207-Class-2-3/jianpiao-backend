create table if not exists public.tb_action
(
    id   varchar(255) primary key not null,
    code varchar(255),
    name varchar(255)
);

create table if not exists public.tb_module
(
    id   varchar(255) primary key not null,
    code varchar(255),
    name varchar(255)
);

create table if not exists public.tb_permission
(
    id        varchar(255) primary key not null,
    code      varchar(255),
    action_id varchar(255),
    module_id varchar(255)
);

create table if not exists public.tb_role
(
    id        varchar(255) primary key not null,
    role_name varchar(255),
    permission_ids varchar(255)
);

create table if not exists public.tb_user
(
    id       varchar(255) primary key not null,
    email    varchar(255),
    gender   varchar(255),
    name     varchar(255),
    nickname varchar(255),
    password varchar(255),
    photo    varchar(255),
    tel      varchar(255),
    username varchar(255),
    role_ids varchar(255)
);