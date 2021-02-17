drop database if exists magazin;
create database magazin;
use magazin;

create table user (
	id int not null primary key auto_increment,
    email varchar(55) not null,
    first_name varchar(55) not null,
    last_name varchar(55) not null,
    role varchar(55) not null,
    password varchar(55) not null
);

create table product (
	id int not null primary key auto_increment,
    name varchar(55) not null,
    description varchar(255),
    price decimal(5,2) not null
);

create table bucket (
	id int not null primary key auto_increment,
	user_id int not null,
    product_id int not null,
    purchase_date timestamp DEFAULT NOW()
);

alter table bucket add foreign key (user_id) references user(id);
alter table bucket add foreign key (product_id) references product(id);
