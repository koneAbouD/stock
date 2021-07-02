DROP TABLE IF EXISTS client;
CREATE TABLE client
(
    id INT8 CONSTRAINT client_pk PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255),
    adresse VARCHAR(255),
    telephone VARCHAR(255),
    email VARCHAR(255),
    adresse_livraison VARCHAR(255),
    version INT8 NOT NULL DEFAULT 0
);