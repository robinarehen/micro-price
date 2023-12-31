create table prices (id integer generated by default as identity, 
	brand_id integer, 
	start_date timestamp, 
	end_date timestamp, 
	price_list integer, 
	product_id integer, 
	priority integer, 
	price double, 
	curr varchar(255), 
	primary key (id));

insert into prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) 
values (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');

insert into prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) 
values (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');

insert into prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) 
values (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');

insert into prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) 
values (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');


/*
SELECT * FROM PRICES;

SELECT * FROM PRICES
WHERE '2020-06-14 10:00:00' BETWEEN START_DATE  AND END_DATE;

SELECT * FROM PRICES
WHERE '2020-06-14 16:00:00' BETWEEN START_DATE  AND END_DATE;

SELECT * FROM PRICES
WHERE '2020-06-14 21:00:00' BETWEEN START_DATE  AND END_DATE;

SELECT * FROM PRICES
WHERE '2020-06-15 10:00:00' BETWEEN START_DATE  AND END_DATE;

SELECT * FROM PRICES
WHERE '2020-06-16 21:00:00' BETWEEN START_DATE  AND END_DATE;

*/