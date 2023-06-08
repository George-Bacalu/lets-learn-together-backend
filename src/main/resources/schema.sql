ALTER TABLE categories DROP CONSTRAINT IF EXISTS FKsaok720gsu4u2wrgbk10b5n8d
ALTER TABLE categories DROP CONSTRAINT IF EXISTS FKi9smu6td2uq355od2mubpfb71
ALTER TABLE feedbacks DROP CONSTRAINT IF EXISTS FK312drfl5lquu37mu4trk8jkwx
ALTER TABLE notifications DROP CONSTRAINT IF EXISTS FK9kxl0whvhifo6gw4tjq36v53k
ALTER TABLE notifications DROP CONSTRAINT IF EXISTS FK13vcnq3ukas06ho1yrbc5lrb5
ALTER TABLE users DROP CONSTRAINT IF EXISTS FK2qqjpih9isqcs22710v8lef9w
ALTER TABLE users DROP CONSTRAINT IF EXISTS FKp56c1712k691lhsyewcssf40f

DROP TABLE IF EXISTS categories
DROP TABLE IF EXISTS feedbacks
DROP TABLE IF EXISTS institutions
DROP TABLE IF EXISTS letter_sign_pairs
DROP TABLE IF EXISTS notifications
DROP TABLE IF EXISTS roles
DROP TABLE IF EXISTS sections
DROP TABLE IF EXISTS users

CREATE TABLE institutions
(
    id        BIGINT IDENTITY
        CONSTRAINT PK__institut__3213E83FAFE7AE5C
        PRIMARY KEY,
    classroom VARCHAR(255),
    school    VARCHAR(255)
);
CREATE TABLE letter_sign_pairs
(
    id       BIGINT IDENTITY
        CONSTRAINT PK__letter_s__3213E83FDFA55B3F
        PRIMARY KEY,
    image_id INT,
    letter   VARCHAR(255)
);
CREATE TABLE roles
(
    id        BIGINT IDENTITY
        CONSTRAINT PK__roles__3213E83F6FAF4BC0
        PRIMARY KEY,
    authority VARCHAR(255)
);
CREATE TABLE sections
(
    id       BIGINT IDENTITY
        CONSTRAINT PK__sections__3213E83FEE7AEF07
        PRIMARY KEY,
    icon_id  INT,
    image_id INT,
    name     VARCHAR(255)
);
CREATE TABLE categories
(
    id          BIGINT IDENTITY
        CONSTRAINT PK__categori__3213E83F8BFF0AA4
        PRIMARY KEY,
    image_id    INT,
    is_expanded BIT DEFAULT 0,
    is_favorite BIT DEFAULT 0,
    name        VARCHAR(255),
    parent_id   BIGINT
        CONSTRAINT FKsaok720gsu4u2wrgbk10b5n8d
            REFERENCES categories,
    section_id  BIGINT
        CONSTRAINT FKi9smu6td2uq355od2mubpfb71
            REFERENCES sections
);
CREATE TABLE users
(
    id             BIGINT IDENTITY
        CONSTRAINT PK__users__3213E83FE675B0EF
        PRIMARY KEY,
    address        VARCHAR(255),
    birthday       DATE,
    email          VARCHAR(255),
    mobile         VARCHAR(255),
    name           VARCHAR(255),
    password       VARCHAR(255),
    institution_id bigINT
        CONSTRAINT FK2qqjpih9isqcs22710v8lef9w
            REFERENCES institutions,
    role_id        BIGINT
        CONSTRAINT FKp56c1712k691lhsyewcssf40f
            REFERENCES roles
);
CREATE TABLE feedbacks
(
    id          BIGINT IDENTITY
        CONSTRAINT PK__feedback__3213E83F1ECC505A
        PRIMARY KEY,
    description VARCHAR(255),
    sent_at     DATETIME2(6),
    type        VARCHAR(255),
    user_id     BIGINT
        CONSTRAINT FK312drfl5lquu37mu4trk8jkwx
            REFERENCES users
);
CREATE TABLE notifications
(
    id          BIGINT IDENTITY
        CONSTRAINT PK__notifica__3213E83FD40F7D52
        PRIMARY KEY,
    is_read     BIT DEFAULT 0,
    message     VARCHAR(255),
    sent_at     DATEtime2(6),
    receiver_id BIGINT
        CONSTRAINT FK9kxl0whvhifo6gw4tjq36v53k
            REFERENCES users,
    sender_id   BIGINT
        CONSTRAINT FK13vcnq3ukas06ho1yrbc5lrb5
            REFERENCES users
);