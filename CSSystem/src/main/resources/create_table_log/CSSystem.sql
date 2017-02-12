
Hibernate:

    create table Permit (
        permit_id integer not null,
        permit_name varchar(255) not null,
        primary key (permit_id)
    )
Hibernate:

    create table Role (
        role_id integer not null,
        role_name varchar(255) not null,
        primary key (role_id)
    )
Hibernate:

    create table role_permit (
        role_id integer not null,
        permit_id integer not null,
        primary key (role_id, permit_id)
    )
Hibernate:

    create table User (
        user_id integer not null,
        user_name varchar(255) not null,
        other tinyblob,
        password varchar(255) not null,
        primary key (user_id)
    )
Hibernate:

    create table user_role (
        user_id integer not null,
        role_id integer not null,
        primary key (user_id, role_id)
    )
Hibernate:

    alter table role_permit
        add constraint FKmi7ld3shihjnkliri4328pim0
        foreign key (permit_id)
        references Permit (permit_id)
Hibernate:

    alter table role_permit
        add constraint FKcqs6wbn5urebc7fhac17i70s0
        foreign key (role_id)
        references Role (role_id)
Hibernate:



    alter table user_role
        add constraint FK7ir6hi5jr98lclgjgbyxafneu
        foreign key (role_id)
        references Role (role_id)
Hibernate:

    alter table user_role
        add constraint FKcnrjdc801vcdj8n017nlriv61
        foreign key (user_id)
        references User (user_id)

