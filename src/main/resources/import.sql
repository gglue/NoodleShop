insert into Extra (id, name, price) values (0,'Extra Noodle', 100);
insert into Extra (id, name, price) values (1,'Extra Soup', 100);
insert into Extra (id, name, price) values (2,'Extra Bok Choy', 200);
insert into Extra (id, name, price) values (3,'Extra Egg', 150);
insert into Extra (id, name, price) values (4,'Extra Sliced Beef', 300);
insert into Extra (id, name, price) values (5,'Extra Beef Brisket', 300);
insert into Extra (id, name, price) values (6,'Extra Braised Pork Belly', 300);
insert into Extra (id, name, price) values (7,'Extra Pig Intestines', 300);
insert into Extra (id, name, price) values (8,'Extra Lamb', 300);
insert into Item_Type (id, desc) values (0, 'Noodle');
insert into Item_Type (id, desc) values (1, 'Side');
insert into Item_Type (id, desc) values (2, 'Drink');

insert into Item (name, type_id, desc, price) values ('Magic Beef', 0, 'Yum', 999);
insert into Item (name, type_id, desc, price) values ('The Magic', 0, 'Yum', 1399);
insert into Item (name, type_id, desc, price) values ('Magic Lamb', 0, 'Yum', 1499);
insert into Item (name, type_id, desc, price) values ('G. I. Ju', 0, 'Yum', 1299);
insert into Item (name, type_id, desc, price) values ('Triple B', 0, 'Yum', 1299);
insert into Item (name, type_id, desc, price) values ('Magic Chicken', 0, 'Yum', 1299);
insert into Item (name, type_id, desc, price) values ('Shrimp & Pork Wonton', 0, 'Yum', 1199);
insert into Item (name, type_id, desc, price) values ('Tree Hugger', 0, 'Yum', 1099);

insert into Noodle_User (city, full_name, password, phone_number, postal, province, street, username, is_Admin) values ('Toronto', 'Victor Li', '$2a$10$/qEEdpq7dcQdp.u5Tbp7lekyIUFxF2B166BQPAqHHiCJzeBwWUViG','647-710-8780','M1V3C1','ON','27 Historic Terrace', 'admin', 1);
insert into Noodle_User (city, full_name, password, phone_number, postal, province, street, username, is_Admin) values ('Toronto', 'Tom Ling', '$2a$10$/qEEdpq7dcQdp.u5Tbp7lekyIUFxF2B166BQPAqHHiCJzeBwWUViG','416-736-6000','M3J2C7','ON','1027 Finch Ave W,', 'customer', 0);

