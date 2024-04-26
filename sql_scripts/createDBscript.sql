create database loginDB;
create database leaderboard;

use logindb;
create table logins(
userID int NOT NULL PRIMARY KEY,
username varchar(25),
password varchar(25)
);



