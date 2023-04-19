CREATE TABLE tb_video (
    id UUID PRIMARY KEY NOT NULL,
    reference VARCHAR(255) NOT NULL UNIQUE,
    exercise_id UUID REFERENCES tb_exercise(id)
);