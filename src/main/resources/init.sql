create table drinks
(
    id          serial           not null
        constraint drinks_pk
            primary key,
    "drinkName" varchar          not null,
    brand       varchar          not null,
    price       integer          not null,
    quantity    integer          not null,
    typ         varchar          not null,
    "managerId" integer
);

alter table drinks
    owner to postgres;

create unique index drinks_id_uindex
    on drinks (id);

create table users
(
    id         serial  not null
        constraint users_pk
            primary key,
    login      varchar not null,
    password   varchar not null,
    "isAdmin"  boolean,
    name       varchar,
    last_name  varchar not null,
    "toDelete" boolean
);

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);

