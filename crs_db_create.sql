
    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table user (
       enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255),
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table user (
       enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255),
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table user (
       enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255),
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (city_id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(5000) not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description varchar(5000) not null,
        is_affected bit,
        people_involved integer,
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table stolen_vehicle (
       id bigint not null auto_increment,
        color varchar(255) not null,
        created_at datetime,
        license_plate varchar(255) not null,
        model varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table user (
       enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255),
        city_id bigint not null,
        primary key (city_id)
    ) engine=InnoDB

    create table report_crime_type (
       report_city_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_city_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKkqyqbrbdfh4qf6kgmppq9x41w 
       foreign key (report_city_id) 
       references report (city_id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (city_id)
