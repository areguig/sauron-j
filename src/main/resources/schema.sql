-- component table
create table if not exists component (
    id serial primary key,
    name varchar(255) not null,
    description text,
    link text,
    status integer,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    deleted_at timestamp,
    enabled boolean default true
);
-- component table indexes


-- incident table.
create table if not exists incident (
    id serial primary key,
    id_component integer not null,
    status integer not null,
    message text,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
)