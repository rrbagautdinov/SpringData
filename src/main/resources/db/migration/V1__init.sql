create schema shop;

alter schema shop owner to postgres;

create table shop.products
(
	id bigserial not null
		constraint products_pkey
			primary key,
	name text not null,
	price bigserial not null
);

alter table shop.products owner to postgres;

insert into shop.products (name, price)
values
    ('Молоко', 99),
    ('Сыр', 199),
    ('Колбаса', 299),
    ('Хлеб', 29),
    ('Йогурт', 50),
    ('Вафли', 79),
    ('Блины', 99),
    ('Курица', 249),
    ('Котлеты', 149),
    ('Сушки', 29);
