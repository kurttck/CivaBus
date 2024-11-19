

create table brand (
    id_brand BINARY(16) not null primary key,
    name varchar(255) not null
);

create table bus(
    id_bus BINARY(16) not null primary key,
    bus_number int not null,
    plate varchar(50) not null,
    creation_date date not null,
    features TEXT,
    id_brand Binary(16) not null,
    status tinyint not null,
    foreign key (id_brand) references brand(id_brand)
)