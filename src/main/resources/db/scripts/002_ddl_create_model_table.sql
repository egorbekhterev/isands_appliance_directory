CREATE TABLE IF NOT EXISTS model
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    size NUMERIC(8, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    available BOOLEAN NOT NULL,
    category VARCHAR(255),
    technology VARCHAR(255),
    memory INT,
    camera INT,
    volume NUMERIC(5, 2),
    mode INT,
    door INT,
    compressor VARCHAR(255),
    processor VARCHAR(255),
    appliance_id INT REFERENCES appliance(id) NOT NULL
);
