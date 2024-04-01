create database books charset utf8mb4;
drop table if exists book_info;
create table if not exists book_info(
    id int primary key auto_increment,
    book_name varchar(128) not null,
    author varchar(32) not null,
    book_count int default 0,
    publishing_home varchar(128) not null,
    price decimal(6,2) not null,
    status tinyint(4) not null default 1 comment '0-已删除 1-可借阅 2-不可借阅',
    cover_picture varchar(256),
    description varchar(256),
    create_time datetime default now(),
    update_time datetime default now() on update now()
) engine = innodb default charset utf8mb4;

drop table if exists user_info;
create table if not exists user_info(
    id int primary key auto_increment,
    user_name varchar(128) unique not null,
    password varchar(32) not null,
    rights tinyint(4) default 1 comment '0-admin管理员 1普通用户',
    gender tinyint(4) default 0 comment '0-默认 1-女 2-男',
    vip_level int default 0,
    status tinyint(4) default 0 comment '0-正常 1-注销 2-封禁',
    balance decimal default 0.0,
    borrow_num int default 0,
    create_time datetime default now(),
    update_time datetime default now() on update now()
) engine = innodb default charset utf8mb4;

select * from user_info;
-- 添加测试数据
insert into user_info(user_name, password, rights) values('admin', 'admin', 0);
insert into user_info(user_name, password) values('普通用户', '1234');

insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小时代', '郭敬明', 10, '中国人民出版社', 22.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('红楼梦', '曹雪芹', 30, '中国人民出版社', 56.80);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('三国演义', '罗贯中', 48, '北京图书出版社', 33.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('西游记', '吴承恩', 80, '陕西人民出版社', 77.88);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('水浒传', '施耐庵', 22, '三国人民出版社', 30.00);

insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说1', '作者1', 10, '中国人民出版社1', 1.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说2', '作者2', 20, '中国人民出版社2', 2.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说3', '作者3', 30, '中国人民出版社3', 3.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说4', '作者4', 40, '中国人民出版社4', 4.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说5', '作者5', 50, '中国人民出版社5', 5.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说6', '作者6', 60, '中国人民出版社6', 6.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说7', '作者7', 70, '中国人民出版社7', 7.00);
insert into book_info(book_name, author, book_count, publishing_home, price)
values ('小说8', '作者8', 80, '中国人民出版社8', 8.00);