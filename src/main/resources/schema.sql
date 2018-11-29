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
    id                BIGSERIAL NOT NULL,
    organization_id   BIGINT NOT NULL,
    name              CHARACTER(150) NOT NULL,
    address           CHARACTER(255) NOT NULL,
    phone             CHARACTER(16),
    active            BOOLEAN,
                      PRIMARY KEY (id)
);

CREATE TABLE "user"
(
    id               BIGSERIAL NOT NULL,
    office_id        BIGINT,
    first_name       CHARACTER(50) NOT NULL,
    second_name      CHARACTER(50),
    middle_name      CHARACTER(50),
    pozition         CHARACTER(50),
    phone            CHARACTER(16),
    identified       BOOLEAN,
    doc_id           BIGINT NOT NULL,
    doc_number       CHARACTER(16),
    doc_date         TIMESTAMP WITHOUT TIME ZONE,
    country_id       BIGINT NOT NULL,
                     PRIMARY KEY (id)
);

CREATE TABLE country
(
    id   BIGINT NOT NULL,
    name CHARACTER (35) NOT NULL,
    code CHARACTER(10),
         PRIMARY KEY (id)
);

CREATE TABLE doc
(
    id bigint NOT NULL,
    name character(55) NOT NULL,
    code character(10),
    country_id bigint,
    PRIMARY KEY (id)
);

CREATE INDEX ix_office_org ON office(organization_id, name, address, phone) ;
ALTER TABLE office
ADD CONSTRAINT office_organization_id_fk
FOREIGN KEY (organization_id) REFERENCES organization (id) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE INDEX ix_user_office ON "user"(office_id);
ALTER TABLE "user"
ADD CONSTRAINT user_office_id_fk
FOREIGN KEY (office_id) REFERENCES office (id) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE INDEX ix_user_doc ON "user"(doc_id);
ALTER TABLE "user"
ADD CONSTRAINT user_doc_id_fk
FOREIGN KEY (doc_id) REFERENCES doc (id) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE INDEX ix_user_country ON "user"(country_id);
ALTER TABLE "user"
ADD CONSTRAINT user_country_id_fk
FOREIGN KEY (country_id) REFERENCES country (id) ON DELETE CASCADE ON UPDATE CASCADE;
