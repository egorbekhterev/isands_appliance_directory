CREATE TABLE IF NOT EXISTS appliance
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    online BOOLEAN NOT NULL,
    instalment BOOLEAN NOT NULL
);
