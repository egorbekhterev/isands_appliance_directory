CREATE TABLE IF NOT EXISTS tv_model
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    size INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    available BOOLEAN NOT NULL,
    category VARCHAR(255) NOT NULL,
    technology VARCHAR(255) NOT NULL,
    tv_id INT REFERENCES tv(id) NOT NULL
);
