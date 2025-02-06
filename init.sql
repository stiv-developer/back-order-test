CREATE TABLE IF NOT EXISTS client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(100) UNIQUE
);

INSERT INTO client (name, email, phone) VALUES
('Stiv Rua', 'stiv@gmail.com', '987456321'),
('Roberto Rodrigues', 'roberto@gmail.com', '987456322'),
('Alex Huertas', 'alex@gmail.com', '987456323');

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    price VARCHAR(100),
    stock VARCHAR(100)
);

INSERT INTO product (name, price, stock) VALUES
('Gaseosa Inka Kola', '2.00', '5'),
('Galleta Oreo', '1.20', '3'),
('Galleta Rellenitas', '1.00', '5');