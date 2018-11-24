CREATE TABLE organization
(
    id       BIGSERIAL NOT NULL,
    name     CHARACTER(50) NOT NULL,
    fullname CHARACTER(150) NOT NULL,
    inn      CHARACTER(16) NOT NULL,
    kpp      CHARACTER(12) NOT NULL,
    address  CHARACTER(455) NOT NULL,
    phone    CHARACTER(16),
    active   BOOLEAN,
             PRIMARY KEY (id)
);

CREATE TABLE office
(
    id       BIGSERIAL NOT NULL,
    org_id   BIGINT NOT NULL,
    name     CHARACTER(150) NOT NULL,
    address  CHARACTER(255) NOT NULL,
    phone    CHARACTER(16),
    active   BOOLEAN,
             PRIMARY KEY (id)
);

CREATE TABLE "user"
(
    id               BIGSERIAL NOT NULL,
    office_id        BIGINT NOT NULL,
    first_name       CHARACTER(50) NOT NULL,
    second_name      CHARACTER(50),
    middle_name      CHARACTER(50),
    pozition         CHARACTER(50),
    phone            CHARACTER(16),
    identified       BOOLEAN,
    doc_code         CHARACTER(16),
    doc_name         CHARACTER(170),
    doc_number       CHARACTER(16),
    doc_date         TIMESTAMP WITHOUT TIME ZONE,
    citizenship_code CHARACTER(16),
                     PRIMARY KEY (id)
);

ALTER TABLE office
ADD CONSTRAINT office_organization_id_fk
FOREIGN KEY (org_id) REFERENCES organization (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "user"
ADD CONSTRAINT user_office_id_fk
FOREIGN KEY (office_id) REFERENCES organization (id) ON DELETE CASCADE ON UPDATE CASCADE;