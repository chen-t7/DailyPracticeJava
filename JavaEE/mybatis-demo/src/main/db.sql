create
database mybatis_test set utf8mb4;
drop table if exists userinfo;
create table userinfo
(
    id          int(11) not null auto_increment,
    username    varchar(127) not null,
    password    varchar(127) not null,
    age         tinyint(4) not null,
    gender      tinyint(4) default '0' comment '1-男 2-女 0-默认',
    phone       varchar(15) default null,
    delete_flag tinyint(4) default 0 comment '0-正常，1-删除',
    create_time datetime    default now(),
    update_time datetime    default now(),
    primary key (id)
) engine = innodb default charset=utf8mb4;

-- 假数据
insert into mybatis_test.userinfo (username, password, age, gender, phone)
values ('admin', 'admin', 18, 1, '15200000000');
insert into mybatis_test.userinfo (username, password, age, gender, phone)
values ('zhangsan', 'zhangsan', 18, 1, '15200000001');
insert into mybatis_test.userinfo (username, password, age, gender, phone)
values ('lisi', 'lisi', 18, 1, '15200000002');
insert into mybatis_test.userinfo (username, password, age, gender, phone)
values ('wangwu', 'wangwu', 18, 1, '15200000003');

drop table if exists articleinfo;
create table articleinfo
(
    id          int primary key auto_increment,
    title       varchar(100) not null,
    content     text         not null,
    uid         int          not null,
    delete_flag tinyint(4) default 0 comment '0-正常，1-删除',
    create_time datetime default now(),
    update_time datetime default now()
)default charset utf8mb4;

-- 插入测试数据
insert into articleinfo(title, content, uid)
values ('Java', 'Java正文', 1);

-- 多表查詢
select ta.*, tb.username, tb.age from articleinfo ta left join userinfo tb on ta.uid = tb.id where ta.id = 1;
select * from userinfo order by id desc;
-- 模糊查询两种写法
select * from userinfo where username like "%java%";
select * from userinfo where username like concat('%', userinfo.#{username}, '%');