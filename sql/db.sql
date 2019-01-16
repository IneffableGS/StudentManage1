drop database if exists stuman;
create database stuman
  char set utf8mb4;

create table stuman.admin (
  id       int auto_increment primary key,
  username varchar(30)  not null unique,
  password varchar(255) not null
);

create table stuman.course (
  cno      int auto_increment primary key,
  cname    varchar(30)  not null,
  cdate    varchar(255) not null,
  cteacher varchar(255) not null
);

drop table if exists stuman.student;
create table stuman.student (
  sno   int auto_increment not null primary key,
  sname varchar(255)
);

create table stuman.sc (
  cno   int primary key,
  sno   int default 0,
  score int default 0
);

alter table stuman.sc
  add constraint
  sc_fk_cno
foreign key (cno)
references stuman.course (cno);

alter table stuman.sc
  add constraint
  sc_fk_sno
foreign key (sno)
references stuman.student (sno);

# 向表内新增课程信息
insert into stuman.admin (username, password)
value ('root', 'toor');

insert into stuman.course (cname, cdate, cteacher)
values ('C语言', '第一学期', '老张'),
       ('C++', '第二学期', '老李'),
       ('java', '第一学期', '老刘'),
       ('php', '第一学期', '老赵'),
       ('python', '第二学期', '老王');

insert into stuman.student (sname)
values ('小明'),
       ('小华'),
       ('小林');

# 清空数据库内容
set foreign_key_checks = 0;
truncate stuman.student;
truncate stuman.course;
truncate stuman.sc;
set foreign_key_checks = 1;

# 查询测试使用
select *
from stuman.admin;

select *
from stuman.course;

select *
from stuman.student;


select c.cno,c.cname,c.cdate,c.cteacher,s.sno,s.sname,sc.score
from stuman.course c,
     stuman.student s,
     stuman.sc sc
where c.cno = sc.cno
  and s.sno = sc.sno;



