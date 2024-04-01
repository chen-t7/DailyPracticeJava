create database if not exists blog_community charset utf8mb4;

drop table if exists discuss_post;
create table if not exists `discuss_post`(
    `id` int(11) not null auto_increment,
    `user_id` varchar(45) default null,
    `title` varchar(100) default null,
    `content` text,
    `type` tinyint(4) default null comment '0-正常；1-置顶；',
    `status` tinyint(4) default null comment '0-正常；1-精华；2-拉黑',
    `create_time` timestamp null default current_timestamp,
    `comment_count` int(11) default null,
    `score` double default null,
    primary key (`id`),
    key `index_user_id` (`user_id`)
) engine = innodb auto_increment=281 default charset=utf8mb4;


drop table if exists user;
create table if not exists `user` (
    `id` int(11) not null auto_increment,
    `user_name` varchar(50) default null,
    `password` varchar(50) default null,
    `salt` varchar(50) default null comment '密码后缀',
    email varchar(100) default null,
    `activation_code` varchar(100) default null comment '激活码',
    `status` tinyint(4) default 0 comment '0-已激活;1-未激活',
    `type` tinyint(4) default 0 comment '0-普通用户；1-管理员；2-版主',
    `head_url` varchar(200) default null comment '用户头像',
    `create_time` timestamp null default current_timestamp,
    primary key (`id`),
    key `index_user_name` (`user_name`(20)),
    key `index_email` (`email`(20))
) engine = innodb auto_increment=101 default charset=utf8mb4;

-- 测试数据
insert into user (`user_name`,`password`,`salt`,`email`,`activation_code`,`status`,`type`,`head_url`)
values ('测试用户', '1234', null, null, null, 0, 0, 'https://pic.rmb.bdstatic.com/bjh/events/4500eccf5109e6a01569594a4a224ced.png@h_1280');
insert into user (id, `user_name`,`password`,`salt`,`email`,`activation_code`,`status`,`type`,`head_url`)
values (1, 'admin', 'admin', null, null, null, 0, 1, 'https://pic.rmb.bdstatic.com/bjh/events/4500eccf5109e6a01569594a4a224ced.png@h_1280');
insert into discuss_post (`user_id`,`title`, `content`,`type`,`status`,`comment_count`,`score`)
values (1, '测试博客标题', '测试博客正文', 0, 0, 0, 1);
