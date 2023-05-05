alter table categories drop constraint if exists FKsaok720gsu4u2wrgbk10b5n8d
alter table categories drop constraint if exists FKi9smu6td2uq355od2mubpfb71
alter table feedbacks drop constraint if exists FK312drfl5lquu37mu4trk8jkwx
alter table notifications drop constraint if exists FK9kxl0whvhifo6gw4tjq36v53k
alter table notifications drop constraint if exists FK13vcnq3ukas06ho1yrbc5lrb5
alter table users drop constraint if exists FK2qqjpih9isqcs22710v8lef9w
alter table users drop constraint if exists FKp56c1712k691lhsyewcssf40f

drop table if exists categories
drop table if exists feedbacks
drop table if exists institutions
drop table if exists letter_sign_pairs
drop table if exists notifications
drop table if exists roles
drop table if exists sections
drop table if exists users

create table institutions
(
    id        bigint identity
        constraint PK__institut__3213E83FAFE7AE5C
            primary key,
    classroom varchar(255),
    school    varchar(255)
);
create table letter_sign_pairs
(
    id       bigint identity
        constraint PK__letter_s__3213E83FDFA55B3F
            primary key,
    image_id int,
    letter   varchar(255)
);
create table roles
(
    id        bigint identity
        constraint PK__roles__3213E83F6FAF4BC0
            primary key,
    authority varchar(255)
);
create table sections
(
    id       bigint identity
        constraint PK__sections__3213E83FEE7AEF07
            primary key,
    icon_id  int,
    image_id int,
    name     varchar(255)
);
create table categories
(
    id          bigint identity
        constraint PK__categori__3213E83F8BFF0AA4
            primary key,
    image_id    int,
    is_expanded bit,
    is_favorite bit,
    name        varchar(255),
    parent_id   bigint
        constraint FKsaok720gsu4u2wrgbk10b5n8d
            references categories,
    section_id  bigint
        constraint FKi9smu6td2uq355od2mubpfb71
            references sections
);
create table users
(
    id             bigint identity
        constraint PK__users__3213E83FE675B0EF
            primary key,
    address        varchar(255),
    birthday       date,
    email          varchar(255),
    mobile         varchar(255),
    name           varchar(255),
    password       varchar(255),
    institution_id bigint
        constraint FK2qqjpih9isqcs22710v8lef9w
            references institutions,
    role_id        bigint
        constraint FKp56c1712k691lhsyewcssf40f
            references roles
);
create table feedbacks
(
    id          bigint identity
        constraint PK__feedback__3213E83F1ECC505A
            primary key,
    description varchar(255),
    sent_at     datetime2(6),
    type        varchar(255),
    user_id     bigint
        constraint FK312drfl5lquu37mu4trk8jkwx
            references users
);
create table notifications
(
    id          bigint identity
        constraint PK__notifica__3213E83FD40F7D52
            primary key,
    is_read     bit,
    message     varchar(255),
    sent_at     datetime2(6),
    receiver_id bigint
        constraint FK9kxl0whvhifo6gw4tjq36v53k
            references users,
    sender_id   bigint
        constraint FK13vcnq3ukas06ho1yrbc5lrb5
            references users
);