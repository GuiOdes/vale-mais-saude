CREATE TABLE tb_address (
    id UUID PRIMARY KEY NOT NULL,
    cep VARCHAR(10) NOT NULL,
    state VARCHAR(100) NOT NULL,
    city VARCHAR(255) NOT NULL,
    district VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    house_number VARCHAR(5)
);