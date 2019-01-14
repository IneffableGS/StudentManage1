drop database if exists stuman;
create database stuman char set utf8mb4 ;

create table stuman.admin(
  id int auto_increment primary key ,
  username varchar(30) not null unique ,
  password varchar(255) not null
);

create table stuman.course(
  cno int auto_increment primary key ,
  cname varchar(30) not null ,
  cdate varchar(255) not null ,
  cteacher varchar(255) not null
);

create table stuman.student(
  sno int not null primary key ,
  sname varchar(255)
);

create table stuman.sc(
  cno int primary key ,
  sno int default 0,
  score int default 0
);

insert  into stuman.admin(username, password) value ('root','toor')
