CREATE TABLE tb_user (
    id UUID PRIMARY KEY NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    birth_date DATE,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    gender VARCHAR(15),
    phone_number VARCHAR(20) UNIQUE,
    email VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    profile_photo_id UUID REFERENCES tb_image(id),
    address_id UUID REFERENCES tb_address(id),
    user_type VARCHAR(20) NOT NULL,
    professional_id UUID REFERENCES tb_user(id)
);