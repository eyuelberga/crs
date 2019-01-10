
    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
