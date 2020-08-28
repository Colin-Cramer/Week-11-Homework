CREATE database IF NOT EXISTS  pizza;

use pizza;

DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS pizza_pie;

CREATE TABLE pizza_pie (
	id int(10) NOT NULL auto_increment,
	name varchar(50) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE toppings (
	id int(10) NOT NULL auto_increment,
	crust varchar(25) NOT NULL,
	sauce varchar(25) NOT NULL,
	cheese varchar(25),
	meat varchar(25),
	vegetable varchar(25),
	pizza_pie_id int(10) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(pizza_pie_id) REFERENCES pizza_pie(id)
);
