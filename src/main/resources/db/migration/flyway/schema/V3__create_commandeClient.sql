DROP TABLE IF EXISTS commande_client;
CREATE TABLE commande_client
(
    id INT8 CONSTRAINT commande_client_pk PRIMARY KEY,
    code VARCHAR NOT NULL,
    designation VARCHAR(255) NOT NULL,
    date TIMESTAMP,
    totalHT NUMERIC,
    tva NUMERIC,
    totalTTC NUMERIC,
    version INT8 NOT NULL DEFAULT 0,
    client_id INT8 NOT NULL,
    CONSTRAINT commande_client_client_fk FOREIGN KEY (client_id) REFERENCES client(id)
);