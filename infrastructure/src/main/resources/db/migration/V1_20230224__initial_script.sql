create table if not exists brand
(
    id bigint not null primary key,
    name varchar(128)
);

create table if not exists price
(
    id int not null primary key,
    brand_id bigint,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list bigint,
    product_id bigint,
    priority integer,
    price float,
    currency varchar(36),
    FOREIGN KEY(brand_id) REFERENCES brand(id)
);

insert into brand (id, name) values (1, 'LOJA');

insert into price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
values (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.5, 'EUR');

insert into price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
values (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');

insert into price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
values (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.5, 'EUR');

insert into price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
values (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');

