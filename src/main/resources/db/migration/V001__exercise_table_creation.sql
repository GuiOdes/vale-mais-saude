CREATE TABLE tb_exercise (
    id UUID PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    explanation TEXT NOT NULL,
    count_sets INT NOT NULL,
    set_repetition_count INT NOT NULL,
    repetition_duration INT NOT NULL,
    exercise_group VARCHAR(50) NOT NULL
);