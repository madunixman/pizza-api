create table restaurants.restaurant (id varchar PRIMARY KEY, name varchar, address1 varchar, address2 varchar, latitude double, longitude double);
create table restaurants.menu (id varchar PRIMARY KEY, id_restaurant varchar, category varchar, name varchar, toppings list<varchar>, price int, rank int);
