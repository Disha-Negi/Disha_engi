create database userappdb;
use userappdb;
create table users
(
 id int auto_increment primary key,
 uname varchar(100) not null,
 email varchar(50) not null unique,
 passwd varchar(20) not null
);

create table student_details
(
 roll_no int auto_increment primary key,
 s_name varchar(100) not null,
 branch varchar(50) not null ,
 semester varchar(20) not null,
 book_id varchar(20) not null,
 issue_date date not null,
 return_date date not null
);

create table book_details
(
 book_id int auto_increment primary key,
 B_name varchar(100) not null,
 Author varchar(50) not null ,
 Publisher varchar(50) not null,
 edition varchar(50) not null
 );

