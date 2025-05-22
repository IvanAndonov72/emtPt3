-- COUNTRY
CREATE TABLE country (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         continent VARCHAR(255) NOT NULL
);

-- HOST
CREATE TABLE host (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      surname VARCHAR(255) NOT NULL,
                      country_id BIGINT REFERENCES country(id)
);

-- ENUM: category for accommodations
CREATE TYPE accommodation_category AS ENUM ('HOTEL', 'APARTMENT', 'HOUSE'); -- adjust as needed

-- ACCOMMODATION
CREATE TABLE accommodation (
                               id BIGSERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               category accommodation_category NOT NULL,
                               host_id BIGINT REFERENCES host(id),
                               num_rooms BIGINT NOT NULL,
                               is_rented BOOLEAN NOT NULL DEFAULT FALSE
);

-- ENUM: user roles
CREATE TYPE user_role AS ENUM ('USER', 'HOST'); -- adjust as needed

-- USERS
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role user_role NOT NULL
);

-- TEMPORARY RESERVATION LIST (1-to-1 with users)
CREATE TABLE temporary_reservation_list (
                                            id BIGSERIAL PRIMARY KEY,
                                            user_id BIGINT UNIQUE REFERENCES users(id)
);

-- MANY-TO-MANY: reservation list <-> accommodations
CREATE TABLE user_reserved_accommodations (
                                              reservation_list_id BIGINT REFERENCES temporary_reservation_list(id),
                                              accommodation_id BIGINT REFERENCES accommodation(id),
                                              PRIMARY KEY (reservation_list_id, accommodation_id)
);
