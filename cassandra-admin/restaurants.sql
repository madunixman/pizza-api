insert into restaurants.restaurant (id, name, address1, address2, latitude, longitude) values ('1', 'Pizzeria Apan', 'Fiskaregatann 3', '120 31 Stockholm', 59.315709, 18.033507);
insert into restaurants.restaurant (id, name, address1, address2, latitude, longitude) values ('2', 'Bella Napoli', '', '120 31 Malmö', 59.315709, 18.033507);
insert into restaurants.restaurant (id, name, address1, address2, latitude, longitude) values ('3', 'Antro delle sorti', 'Xyz 4', '120 31 Stockholm', 59.315709, 18.033507);
insert into restaurants.menu (id, id_restaurant, category , name , topping, price , rank ) values ('1', '1', 'Pizza', 'my plate', ['a','b','c'], 150, 7);
insert into restaurants.menu (id, id_restaurant, category , name , topping, price , rank ) values ('2', '1', 'Pizza', 'plate x', ['a','c'], 160, 6);
insert into restaurants.menu (id, id_restaurant, category , name , topping, price , rank ) values ('3', '1', 'Pizza', 'plate y', ['b','c'], 140, 6);
