create table if not exists user(
    id int not null auto_increment,
    username varchar(45) not null ,
    password varchar(45) not null ,
    algorithm varchar(45) not null ,
    primary key (id)
);

create table if not exists authority(
    id int not null auto_increment,
    name varchar(45) not null ,
    user_id int not null ,
    primary key (id),
    foreign key (user_id) references user(id)
);

create table if not exists product(
    id int not null auto_increment,
    name varchar(45) not null ,
    price varchar(45) not null ,
    currency varchar(45) not null ,
    primary key (id)
);

