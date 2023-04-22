CREATE TABLE IF NOT EXISTS phone_model
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    size NUMERIC(5, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    available BOOLEAN NOT NULL,
    memory INT NOT NULL,
    camera INT NOT NULL,
    phone_id INT REFERENCES phone(id) NOT NULL
);
