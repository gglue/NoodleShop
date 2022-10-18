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
    price smallint not null
    );

create table if not exists Custom_Item (
    id identity,
    total_Price smallint not null,
    item bigint not null
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

/*alter table Item_Extras
    add foreign key (extra) references Extra(id);
alter table Item_Extras
    add foreign key (item) references Item(id);
 */
