CREATE TABLE institutions (
    id BIGSERIAL PRIMARY KEY,
    classroom VARCHAR(255),
    school VARCHAR(255)
);

CREATE TABLE letter_sign_pairs (
    id BIGSERIAL PRIMARY KEY,
    image_id INT,
    letter VARCHAR(255)
);

CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    authority VARCHAR(255)
);

CREATE TABLE sections (
    id BIGSERIAL PRIMARY KEY,
    icon_id INT,
    image_id INT,
    name VARCHAR(255)
);

CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    image_id INT,
    is_expanded BOOLEAN DEFAULT FALSE,
    is_favorite BOOLEAN DEFAULT FALSE,
    name VARCHAR(255),
    parent_id BIGINT REFERENCES categories (id),
    section_id BIGINT REFERENCES sections (id)
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    address VARCHAR(255),
    birthday DATE,
    email VARCHAR(255),
    mobile VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    institution_id BIGINT REFERENCES institutions (id),
    role_id BIGINT REFERENCES roles (id)
);

CREATE TABLE feedbacks (
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255),
    sent_at TIMESTAMP,
    type VARCHAR(255),
    user_id BIGINT REFERENCES users (id)
);

CREATE TABLE notifications (
    id BIGSERIAL PRIMARY KEY,
    is_read BOOLEAN DEFAULT FALSE,
    message VARCHAR(255),
    sent_at TIMESTAMP,
    receiver_id BIGINT REFERENCES users (id),
    sender_id BIGINT REFERENCES users (id)
);