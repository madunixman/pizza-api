create table restaurants.restaurant (id int PRIMARY KEY, name varchar, address1 varchar, address2 varchar, latitude double, longitude double);
create table restaurants.customer_order (id int PRIMARY KEY, id_restaurant int, category varchar, name varchar, toppings list<varchar>, price int, rank int);
