CREATE TABLE clients
(
    id    SERIAL  PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL
);
CREATE SEQUENCE clients_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE limservices
(
    id    SERIAL  PRIMARY KEY ,
    description  VARCHAR(200) NOT NULL ,
    comment VARCHAR(500) ,
    lim INTEGER NOT NULL
);
CREATE SEQUENCE limservices_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE transactions
(
    id    SERIAL  PRIMARY KEY ,
    idclient SERIAL REFERENCES clients (Id) ,
    idlimservice SERIAL REFERENCES limservices (Id) ,
    reqdate TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    reqstate BOOLEAN NOT NULL ,
    emailstate BOOLEAN NOT NULL
);
CREATE SEQUENCE transactions_id_seq START WITH 1 INCREMENT BY 1;