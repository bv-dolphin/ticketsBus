create table bus_flight_tbl (
       id bigint not null auto_increment,
        arrival varchar(100),
        arrival_time datetime,
        departure varchar(100),
        departure_time datetime,
        flight_name varchar(100) not null,
        flight_number integer not null,
        km integer,
        price double precision,
        primary key (id)
    ) engine=MyISAM;


    create table bus_landing_tbl (
       id bigint not null auto_increment,
        place_number integer not null,
        schedule_id bigint,
        ticket_id bigint,
        primary key (id),
        foreign key (schedule_id) references schedule_tbl (id),
      foreign key (ticket_id)   references ticket_tbl (id)
    ) engine=MyISAM;

    create table bus_route_tbl (
       id bigint not null auto_increment,
        arrival_time datetime not null,
        departure_time datetime not null,
        km integer not null,
        bus_flight_id bigint,
        bus_station_id bigint,
        primary key (id),
      foreign key (bus_flight_id)   references bus_flight_tbl (id),
      foreign key (bus_station_id)   references bus_station_tbl (id)
    ) engine=MyISAM;


    create table bus_station_tbl (
       id bigint not null auto_increment,
        bus_station_name varchar(20) not null,
        latitude varchar(100),
        longitude varchar(100),
        street_name varchar(100),
        city_id bigint,
        primary key (id),
      foreign key (city_id)   references city_tbl (id)
    ) engine=MyISAM;


    create table bus_tbl (
       id bigint not null auto_increment,
        bus_brand varchar(100) not null,
        bus_condition bit not null,
        place_amount integer not null,
        wifi bit not null,
        primary key (id)
    ) engine=MyISAM;


    create table city_tbl (
       id bigint not null auto_increment,
        city varchar(50) not null,
        region_id bigint,
        primary key (id),
      foreign key (region_id)   references region_tbl (id)
    ) engine=MyISAM;


    create table country_tbl (
       id bigint not null auto_increment,
        country varchar(50) not null,
        primary key (id)
    ) engine=MyISAM;


    create table region_tbl (
       id bigint not null auto_increment,
        region varchar(50) not null,
        country_id bigint,
        primary key (id),
      foreign key (country_id)   references country_tbl (id)
    ) engine=MyISAM;


    create table schedule_tbl (
       id bigint not null auto_increment,
        depature_date datetime not null,
        bus_id bigint,
        bus_route_id bigint,
        primary key (id),
      foreign key (bus_id)   references bus_tbl (id),
      foreign key (bus_route_id)   references bus_route_tbl (id)
    ) engine=MyISAM;


-- users_tbl

create table users_tbl (
  id  bigint not null auto_increment,
  active boolean,
  email varchar(100) not null,
  fist_name varchar(100) not null,
  last_name varchar(100) not null,
  password varchar(100) not null,
  primary key (id)
);

alter table users_tbl
  add constraint email_unique unique (email);

-- user2roles_tbl

create table user2roles_tbl (
  user_id bigint not null,
  roles_enum varchar(20) not null,
  primary key (user_id, roles_enum)
);

alter table user2roles_tbl
  add constraint users2roles_user_fk foreign key (user_id) references users_tbl(id);
-- token_tbl


create table token_tbl (
  id bigint not null auto_increment,
  session varchar(100) not null,
  user_id bigint not null,
  primary key (id)
);

alter table token_tbl
  add constraint session_unique unique (session);

alter table token_tbl
  add constraint token_unique unique (session, user_id);

alter table token_tbl
  add constraint token_users_fk foreign key (user_id) references users_tbl(id);

-- tickets_tbl

create table tickets_tbl (
  id bigint not null auto_increment,
  purchase_date timestamp not null,
  ticket_number integer not null,
  user_id bigint,
  primary key (id)
);

alter table tickets_tbl
  add constraint ticket_number_unique unique (ticket_number);

alter table tickets_tbl
  add constraint ticket_user_fk foreign key (user_id) references users_tbl(id);
