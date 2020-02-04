CREATE TABLE users (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    pictureURL VARCHAR(255),
    is_active BOOLEAN NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE roles (
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE user_roles (
    user_id UUID NOT NULL,
    role_id INT NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);