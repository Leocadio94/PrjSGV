CREATE DATABASE IF NOT EXISTS vacinacao;
USE vacinacao;

CREATE TABLE tb_person (
    cpf BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    rg VARCHAR(16) NOT NULL,
    peso INTEGER,
    has_tatoo BOOLEAN NOT NULL,
    data_nascimento DATE NOT NULL,
    PRIMARY KEY (cpf)
);

CREATE TABLE tb_vaccines (
    id_vaccine INTEGER NOT NULL,
    lote INTEGER NOT NULL,
    validade DATE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    id_type INTEGER NOT NULL,
    PRIMARY KEY (id_vaccine)
);