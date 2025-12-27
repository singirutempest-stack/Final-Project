
CREATE TABLE roles (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(50) NOT NULL UNIQUE
);


CREATE TABLE users (
id BIGSERIAL PRIMARY KEY,
email VARCHAR(120) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
blocked BOOLEAN NOT NULL DEFAULT FALSE
);


CREATE TABLE user_roles (
user_id BIGINT NOT NULL,
role_id BIGINT NOT NULL,
PRIMARY KEY (user_id, role_id),
CONSTRAINT fk_user_roles_user
FOREIGN KEY (user_id) REFERENCES users(id),
CONSTRAINT fk_user_roles_role
FOREIGN KEY (role_id) REFERENCES roles(id)
);


CREATE TABLE sellers (
id BIGSERIAL PRIMARY KEY,
user_id BIGINT NOT NULL UNIQUE,
active BOOLEAN NOT NULL DEFAULT TRUE,
CONSTRAINT fk_seller_user
FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE categories (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(120) NOT NULL,
description VARCHAR(255)
);


CREATE TABLE products (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(150) NOT NULL,
description VARCHAR(500),
price NUMERIC(12,2) NOT NULL,
stock_quantity INT NOT NULL,
category_id BIGINT NOT NULL,
seller_id BIGINT NOT NULL,
CONSTRAINT fk_product_category
FOREIGN KEY (category_id) REFERENCES categories(id),
CONSTRAINT fk_product_seller
FOREIGN KEY (seller_id) REFERENCES sellers(id)
);


CREATE TABLE carts (
id BIGSERIAL PRIMARY KEY,
user_id BIGINT NOT NULL UNIQUE,
CONSTRAINT fk_cart_user
FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE cart_items (
id BIGSERIAL PRIMARY KEY,
cart_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
quantity INT NOT NULL,
CONSTRAINT fk_cart_item_cart
FOREIGN KEY (cart_id) REFERENCES carts(id) ON DELETE CASCADE,
CONSTRAINT fk_cart_item_product
FOREIGN KEY (product_id) REFERENCES products(id)
);


CREATE TABLE orders (
id BIGSERIAL PRIMARY KEY,
user_id BIGINT NOT NULL,
created_at TIMESTAMP NOT NULL,
status VARCHAR(30) NOT NULL,
CONSTRAINT fk_order_user
FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE order_items (
id BIGSERIAL PRIMARY KEY,
order_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
quantity INT NOT NULL,
price_at_purchase NUMERIC(12,2) NOT NULL,
CONSTRAINT fk_order_item_order
FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
CONSTRAINT fk_order_item_product
FOREIGN KEY (product_id) REFERENCES products(id)
);


CREATE TABLE payments (
id BIGSERIAL PRIMARY KEY,
order_id BIGINT NOT NULL UNIQUE,
amount NUMERIC(12,2) NOT NULL,
status VARCHAR(30) NOT NULL,
paid_at TIMESTAMP NOT NULL,
CONSTRAINT fk_payment_order
FOREIGN KEY (order_id) REFERENCES orders(id)
);
