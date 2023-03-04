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

insert into Item (name, type_id, desc, image, price) values ('Magic Beef', 0, 'Lanzhou noodle, a dish originally served to elite guests in the Northwestern provinces, is hands down one of the most famous noodle dishes in China.', 'magicbeef.png', 999);
insert into Item (name, type_id, desc, image, price) values ('The Magic', 0, 'Enjoy the same wholesome signature beef noodle soup you love, with more protein variety! Go beyond our tender beef shank slices with items like our slow-braised herbal lamb chop, crunchy beef tripe, and delicious fried egg.', 'themagic.png', 1399);
insert into Item (name, type_id, desc, image, price) values ('Magic Lamb', 0, 'Our specialty lamb stock is made with herbs, red dates and goji berries, which are ingredients in traditional Chinese medicine known for supporting liver, kidney, immunity, and circulatory health.', 'magiclamb.png', 1499);
insert into Item (name, type_id, desc, image, price) values ('G. I. Ju', 0, 'For the adventurous, spice lovers, this dish is a spicy twist to our wholesome signature noodle soup, topped with traditional juicy, mouthwatering pig intestine, slow-braised in our specialty marinade.', 'giju.png', 1299);
insert into Item (name, type_id, desc, image, price) values ('Triple B', 0, 'A twist to our wholesome signature beef noodle soup, with the same delicious beef stock and noodles you love, topped with our slow-cooked juicy beef brisket, braised in our secret specialty marinade.', 'tripleb.png', 1299);
insert into Item (name, type_id, desc, image, price) values ('Magic Chicken', 0, 'For the chicken lovers, try this noodle soup featuring savoury chicken stock and juicy chicken thigh marinated and deep-fried to perfection.', 'magicchicken.png', 1299);
insert into Item (name, type_id, desc, image, price) values ('Smokey Duck', 0, 'Smoked duck is a specialty of Szechuan that is known for its complex cooking process. Our juicy smoked duck breast is marinated, smoked, and braised to perfection, and is an excellent pair for our wholesome noodle soup.', 'smokeyduck.png', 1299);
insert into Item (name, type_id, desc, image, price) values ('Tree Hugger', 0, 'The perfect vegetarian option, the Tree Hugger features our chewy freshly-made noodles, submerged in our light refreshing vegetable stock, topped with tasty veggies, shiitake mushrooms and fried egg.', 'treehugger.png', 1099);

insert into Noodle_User (city, full_name, password, phone_number, postal, province, street, username, is_Admin) values ('Toronto', 'Victor Li', '$2a$10$/qEEdpq7dcQdp.u5Tbp7lekyIUFxF2B166BQPAqHHiCJzeBwWUViG','647-710-8780','M1V3C1','ON','27 Historic Terrace', 'admin', 1);
insert into Noodle_User (city, full_name, password, phone_number, postal, province, street, username, is_Admin) values ('Toronto', 'Tom Ling', '$2a$10$/qEEdpq7dcQdp.u5Tbp7lekyIUFxF2B166BQPAqHHiCJzeBwWUViG','416-736-6000','M3J2C7','ON','1027 Finch Ave W,', 'customer', 0);

