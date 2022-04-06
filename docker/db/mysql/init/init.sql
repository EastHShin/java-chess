create table board
(
    id int not null,
    turn int not null,
    primary key (id)
);

create table piece
(
    id int not null auto_increment,
    board_id int not null,
    position varchar(2) not null,
    type varchar(1) not null,
    color int not null,
    primary key (id),
    foreign key (board_id) references board (id)
);