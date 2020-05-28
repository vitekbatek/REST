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
    idClient SERIAL REFERENCES clients (Id) ,
    idService SERIAL REFERENCES limservices (Id) ,
    reqDate DATE NOT NULL ,
    reqState BOOLEAN NOT NULL ,
    emailState BOOLEAN NOT NULL
);
CREATE SEQUENCE transactions_id_seq START WITH 1 INCREMENT BY 1;