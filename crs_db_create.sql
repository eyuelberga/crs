
    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        news_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table missing_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        date_missing varchar(255) not null,
        description longtext not null,
        fullname varchar(255) not null,
        gender varchar(255) not null,
        picture_path varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       id bigint not null auto_increment,
        address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description longtext not null,
        is_affected varchar(255),
        people_involved integer,
        seen bit not null,
        city_id bigint,
        user_id bigint,
        primary key (id)
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
       id bigint not null auto_increment,
        enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255) not null,
        city_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table wanted_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        description longtext not null,
        fullname varchar(255),
        gender varchar(255) not null,
        picture_path varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKnxm8x9npdhuwxv2x2wxsghm17 
       foreign key (news_id) 
       references news (id)

    alter table comment 
       add constraint FK8kcum44fvpupyw6f5baccx25c 
       foreign key (user_id) 
       references user (id)

    alter table missing_person 
       add constraint FKp7kw14ilpx03gg2wlw06lo3y8 
       foreign key (user_id) 
       references user (id)

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKmwn5e52f475my1vox9xf1o9k 
       foreign key (report_id) 
       references report (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        news_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table missing_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        date_missing varchar(255) not null,
        description longtext not null,
        fullname varchar(255) not null,
        gender varchar(255) not null,
        picture_path varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       id bigint not null auto_increment,
        address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description longtext not null,
        is_affected varchar(255),
        people_involved integer,
        seen bit not null,
        city_id bigint,
        user_id bigint,
        primary key (id)
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
       id bigint not null auto_increment,
        enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255) not null,
        city_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table wanted_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        description longtext not null,
        fullname varchar(255),
        gender varchar(255) not null,
        picture_path varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKnxm8x9npdhuwxv2x2wxsghm17 
       foreign key (news_id) 
       references news (id)

    alter table comment 
       add constraint FK8kcum44fvpupyw6f5baccx25c 
       foreign key (user_id) 
       references user (id)

    alter table missing_person 
       add constraint FKp7kw14ilpx03gg2wlw06lo3y8 
       foreign key (user_id) 
       references user (id)

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKmwn5e52f475my1vox9xf1o9k 
       foreign key (report_id) 
       references report (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        news_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table missing_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        date_missing varchar(255) not null,
        description longtext not null,
        fullname varchar(255) not null,
        gender varchar(255) not null,
        picture_path varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       id bigint not null auto_increment,
        address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description longtext not null,
        is_affected varchar(255),
        people_involved integer,
        seen bit not null,
        city_id bigint,
        user_id bigint,
        primary key (id)
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
       id bigint not null auto_increment,
        enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255) not null,
        city_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table wanted_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        description longtext not null,
        fullname varchar(255),
        gender varchar(255) not null,
        picture_path varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKnxm8x9npdhuwxv2x2wxsghm17 
       foreign key (news_id) 
       references news (id)

    alter table comment 
       add constraint FK8kcum44fvpupyw6f5baccx25c 
       foreign key (user_id) 
       references user (id)

    alter table missing_person 
       add constraint FKp7kw14ilpx03gg2wlw06lo3y8 
       foreign key (user_id) 
       references user (id)

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKmwn5e52f475my1vox9xf1o9k 
       foreign key (report_id) 
       references report (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        news_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table missing_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        date_missing varchar(255) not null,
        description longtext not null,
        fullname varchar(255) not null,
        gender varchar(255) not null,
        picture_path varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       id bigint not null auto_increment,
        address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description longtext not null,
        is_affected varchar(255),
        people_involved integer,
        seen bit not null,
        city_id bigint,
        user_id bigint,
        primary key (id)
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
       id bigint not null auto_increment,
        enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255) not null,
        city_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table wanted_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        description longtext not null,
        fullname varchar(255),
        gender varchar(255) not null,
        picture_path varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKnxm8x9npdhuwxv2x2wxsghm17 
       foreign key (news_id) 
       references news (id)

    alter table comment 
       add constraint FK8kcum44fvpupyw6f5baccx25c 
       foreign key (user_id) 
       references user (id)

    alter table missing_person 
       add constraint FKp7kw14ilpx03gg2wlw06lo3y8 
       foreign key (user_id) 
       references user (id)

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKmwn5e52f475my1vox9xf1o9k 
       foreign key (report_id) 
       references report (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table city (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        news_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table crime_type (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table missing_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        date_missing varchar(255) not null,
        description longtext not null,
        fullname varchar(255) not null,
        gender varchar(255) not null,
        picture_path varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table report (
       id bigint not null auto_increment,
        address varchar(255) not null,
        created_at datetime,
        date varchar(255) not null,
        description longtext not null,
        is_affected varchar(255),
        people_involved integer,
        seen bit not null,
        city_id bigint,
        user_id bigint,
        primary key (id)
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
       id bigint not null auto_increment,
        enabled integer,
        fullname varchar(255),
        password varchar(255),
        phone_number varchar(255),
        street_address varchar(255),
        username varchar(255) not null,
        city_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table wanted_person (
       id bigint not null auto_increment,
        age integer not null,
        created_at datetime,
        description longtext not null,
        fullname varchar(255),
        gender varchar(255) not null,
        picture_path varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table report_crime_type (
       report_id bigint not null,
        crime_type_id bigint not null,
        primary key (report_id, crime_type_id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKnxm8x9npdhuwxv2x2wxsghm17 
       foreign key (news_id) 
       references news (id)

    alter table comment 
       add constraint FK8kcum44fvpupyw6f5baccx25c 
       foreign key (user_id) 
       references user (id)

    alter table missing_person 
       add constraint FKp7kw14ilpx03gg2wlw06lo3y8 
       foreign key (user_id) 
       references user (id)

    alter table report 
       add constraint FKb0vqo0he8d488dwalpedmui0a 
       foreign key (city_id) 
       references city (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

    alter table user 
       add constraint FK29eqyw0gxw5r4f1ommy11nd9i 
       foreign key (city_id) 
       references city (id)

    alter table report_crime_type 
       add constraint FK4xf6ft03o2v51sl6c95td4jm3 
       foreign key (crime_type_id) 
       references crime_type (id)

    alter table report_crime_type 
       add constraint FKmwn5e52f475my1vox9xf1o9k 
       foreign key (report_id) 
       references report (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
