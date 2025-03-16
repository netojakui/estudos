-- Create table for users
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Create table for roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Create table for products
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    value DECIMAL(10, 2) NOT NULL
);

-- Create table for orders
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    user_id BIGINT,
    product_id BIGINT,
    status INT NOT NULL,
    delivery_fee DECIMAL(10, 2) NOT NULL,
    delivery_fee_part_person DECIMAL(10, 2),
    product_value DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);