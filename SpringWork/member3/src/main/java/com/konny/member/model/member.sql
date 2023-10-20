create table member(
    id int not null ,
    email varchar(50) not null primary key,
    name varchar(20) not null,
    password varchar(10) not null,
    registerDate date not null
);