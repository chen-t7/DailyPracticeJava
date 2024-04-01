create table message_info
(
    id         int (11) not null auto_increment,
    `from`       varchar(127) not null,
    `to`         varchar(127) not null,
    message     varchar(256) not null,
    delete_flag tinyint(4) default 0 comment '0-正常, 1-删除',
    create_time datetime default now(),
    update_time datetime default now() on update now(),
    primary key (id)
) engine = innodb default charset = utf8mb4;