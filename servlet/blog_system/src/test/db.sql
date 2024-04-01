-- 这个文件主要是用来写建库建表语句
-- 在建表的时候把sql保留下来，以备后续部署在其他机器的时候就方便了

create database if not exists blog_system charset utf8mb4;;
use blog_system;

-- 删除旧表，重新创建新表，删除旧表是为了防止之前的残留数据对后续的程序有负面影响。
drop table if exists user;
drop table if exists blog;

-- 真正的建表
create table user (
    userId int primary key auto_increment,
    username varchar(20) unique,        -- 要求用户名和别人不重复
    password varchar(20)
);

create table blog (
    blogId int primary key auto_increment,
    title varchar(128),
    content varchar(4096),
    updateTime datetime,
    userId int,
    foreign key (userId) references user(userId)
);

-- 构造测试数据
insert into user values(1, '小陈啊', '1234');
insert into user values(2, '小李啊', '1234');

insert into blog values(1, '这是我的第一篇博客', '从今天开始我要认真敲代码', now(), 1);
insert into blog values(2, '这是我的第二篇博客', '从昨天开始我要认真敲代码', now(), 1);
insert into blog values(3, '这是我的第三篇博客', '从前天开始我要认真敲代码', now(), 1);

insert into blog values(4, '我是秦始皇', '速速打钱', now(), 2);

