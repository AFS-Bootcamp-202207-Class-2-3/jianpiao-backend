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
    name      varchar(255),
    action_id varchar(255),
    module_id varchar(255)
);

create table if not exists public.tb_role
(
    id        varchar(255) primary key not null,
    role_name varchar(255)
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
    username varchar(255)
);

create table if not exists public.user_role
(
    user_id varchar(255) not null,
    role_id varchar(255) not null,
    primary key (user_id, role_id)
);

create table if not exists public.role_permission
(
    role_id       varchar(255) not null,
    permission_id varchar(255) not null,
    primary key (role_id, permission_id)
);