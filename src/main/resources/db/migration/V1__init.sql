create sequence hibernate_sequence start 1 increment 1;
create sequence sequence_generator start 1 increment 50;

create table customer
(
        id int8 not null,
        active boolean,
        age int4,
        name text,
        primary key (id)
);

create table event
(
        id int8 not null,
        date date,
        description text,
        title text,
        creator_id int8,
        primary key (id)
);

create table roles
(
        id  bigserial not null,
        name varchar(20),
        primary key (id)
);

create table user_roles
(
        user_id int8 not null,
        role_id int8 not null,
        primary key (user_id, role_id)
);

create table users
(
        id  bigserial not null,
        email text,
        password text,
        username text,
        primary key (id)
);

create table sportsman
(
        id  bigserial not null,
        age int4 not null,
        first_name text,
        last_name text,
        event_id int8,
        year_of_birth int4 not null,
        primary key (id)
);

create table participation
(
        id  bigserial not null,
        name varchar(255),
        result int4 not null,
        sportsman_id int8,
        primary key (id)
);

create table participation_application
(
        id int8 not null,
        event_id int8,
        university text,
        creator_id int8,
        primary key (id)
);

create table participation_application_sportsmen
(
        participation_application_id int8 not null,
        sportsmen_id int8 not null
);

alter table participation_application_sportsmen
    add constraint UK_smgu3p3um0jot63se64qufbel unique (sportsmen_id);

alter table users
       add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);

alter table users
       add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email);

alter table event
       add constraint FK1h6eb0wh6dq1j6h52570b4keg
       foreign key (creator_id)
       references users;

alter table user_roles
       add constraint FKh8ciramu9cc9q3qcqiv4ue8a6
       foreign key (role_id)
       references roles;

alter table user_roles
       add constraint FKhfh9dx7w3ubf1co1vdev94g3f
       foreign key (user_id)
       references users;

alter table participation
    add constraint FKkumrptdhdbu5g3k45hfn028m5
        foreign key (sportsman_id)
            references sportsman;

alter table participation_application
    add constraint FK77k7uvbrt4srfmmsmvo696hqj
        foreign key (creator_id)
            references users;

alter table participation_application_sportsmen
    add constraint FKnwvmryg276pdhj8kdt0n04xml
        foreign key (sportsmen_id)
            references sportsman;

alter table participation_application_sportsmen
    add constraint FKob2ed8qg158h80cjcxhcexafq
        foreign key (participation_application_id)
            references participation_application;

alter table sportsman
    add constraint FKfb9t6c1c02c2v8w58w0dxh3jf
        foreign key (event_id)
            references event;