create database bship;
create database login;

use login;

create table users(
userID int not null unique,
username varchar(25),
password varchar(25)
); 

use bship;

create table leaderboard(
username varchar(25),
wins int,
losses int);



