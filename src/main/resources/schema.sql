create table if not exists Manual_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_Prov varchar(2) not null,
    delivery_Post varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_At timestamp not null,
    final_Price bigint not null
    );

create table if not exists Item (
    id identity,
    name varchar(50) not null,
    type bigint not null,
    desc varchar(200) not null,
    image varchar(200) not null,
    price smallint not null
    );

create table if not exists Custom_Item (
    id identity,
    total_Price smallint not null,
    item bigint not null,
    orderID bigint not null
    );

create table if not exists Item_Type (
    id identity,
    desc varchar(25) not null
);

create table if not exists Extra (
    id identity,
    name varchar(25) not null,
    price smallint not null
    );

create table if not exists Noodle_User (
    id identity,
    username varchar(100) not null,
    password varchar(100) not null,
    is_Admin number(1) not null,
    city varchar(25) not null,
    postal varchar(6) not null,
    province varchar(25) not null,
    street varchar(50) not null,
    phone_number varchar(25) not null,
    full_name varchar(50) not null
    );

