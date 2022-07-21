create sequence bookmark_sequence start with 1 increment by 50;

create table bookmarks (
    id bigint default nextval('bookmark_sequence') not null,
    created_at timestamp,
    title varchar(255) not null,
    url varchar(255) not null,
    primary key (id)
);

