
CREATE SEQUENCE dm_dependence_type_id_dependence_type_seq_1;

CREATE TABLE dm_dependence_type (
                id_dependence_type INTEGER NOT NULL DEFAULT nextval('dm_dependence_type_id_dependence_type_seq_1'),
                description VARCHAR NOT NULL,
                CONSTRAINT id_dependence_type PRIMARY KEY (id_dependence_type)
);
COMMENT ON TABLE dm_dependence_type IS 'Tabela do tipo de dependencia';
COMMENT ON COLUMN dm_dependence_type.id_dependence_type IS 'id do tipo de dependencia';
COMMENT ON COLUMN dm_dependence_type.description IS 'Descrição do tipo de dependencia';


ALTER SEQUENCE dm_dependence_type_id_dependence_type_seq_1 OWNED BY dm_dependence_type.id_dependence_type;

CREATE TABLE dm_vaccine_type (
                id_type INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT dm_vaccine_type_pk PRIMARY KEY (id_type)
);
COMMENT ON TABLE dm_vaccine_type IS 'Tabela domínio de tipos de vacinas';
COMMENT ON COLUMN dm_vaccine_type.id_type IS 'Id do tipo de vacina';
COMMENT ON COLUMN dm_vaccine_type.name IS 'Nome do tipo de vacina';


CREATE TABLE dm_allergy (
                id_allergy INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT dm_allergy_pk PRIMARY KEY (id_allergy)
);
COMMENT ON TABLE dm_allergy IS 'Tabela domínio de alergias';
COMMENT ON COLUMN dm_allergy.id_allergy IS 'Id da alergia';
COMMENT ON COLUMN dm_allergy.name IS 'nome da alergia';


CREATE TABLE dm_disease (
                id_disease INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT dm_diseases_pk PRIMARY KEY (id_disease)
);
COMMENT ON TABLE dm_disease IS 'Tabela domínio de doenças';
COMMENT ON COLUMN dm_disease.id_disease IS 'id da doença';
COMMENT ON COLUMN dm_disease.name IS 'Nome da doença';


CREATE TABLE dm_local (
                id_local INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                CONSTRAINT dm_local_pk PRIMARY KEY (id_local)
);
COMMENT ON TABLE dm_local IS 'Tabela de locais de vacinação';
COMMENT ON COLUMN dm_local.id_local IS 'Id do local';
COMMENT ON COLUMN dm_local.name IS 'Nome do local';
COMMENT ON COLUMN dm_local.address IS 'Endereço do local';


CREATE TABLE tb_vaccines (
                id_vaccine INTEGER NOT NULL,
                lot INTEGER NOT NULL,
                validate DATE NOT NULL,
                name VARCHAR NOT NULL,
                id_type INTEGER NOT NULL,
                CONSTRAINT tb_vaccines_pk PRIMARY KEY (id_vaccine)
);
COMMENT ON TABLE tb_vaccines IS 'Tabela de vacinas';
COMMENT ON COLUMN tb_vaccines.id_vaccine IS 'Id da vacina';
COMMENT ON COLUMN tb_vaccines.lot IS 'Lote da vacina';
COMMENT ON COLUMN tb_vaccines.validate IS 'Validade da vacina';
COMMENT ON COLUMN tb_vaccines.name IS 'Nome da vacina';
COMMENT ON COLUMN tb_vaccines.id_type IS 'Id do tipo de vacina';


CREATE TABLE tb_person (
                cpf BIGINT NOT NULL,
                name VARCHAR NOT NULL,
                rg VARCHAR NOT NULL,
                weight INTEGER,
                has_tattoo BOOLEAN NOT NULL,
                dt_birth DATE NOT NULL,
                CONSTRAINT tb_person_pk PRIMARY KEY (cpf)
);
COMMENT ON TABLE tb_person IS 'Tabela de registros de pessoas';
COMMENT ON COLUMN tb_person.cpf IS 'CPF do registro';
COMMENT ON COLUMN tb_person.name IS 'Nome do registro';
COMMENT ON COLUMN tb_person.rg IS 'RG do registro';
COMMENT ON COLUMN tb_person.weight IS 'Peso do registro';
COMMENT ON COLUMN tb_person.has_tattoo IS 'Campo para saber se registro tem tatuagem';
COMMENT ON COLUMN tb_person.dt_birth IS 'Data de nascimento do registro';


CREATE TABLE tb_employees (
                cre BIGINT NOT NULL,
                id_local INTEGER NOT NULL,
                cpf BIGINT NOT NULL,
                CONSTRAINT tb_employees_pk PRIMARY KEY (cre, id_local)
);
COMMENT ON TABLE tb_employees IS 'Tabela de empregados';
COMMENT ON COLUMN tb_employees.cre IS 'Número do CRE';
COMMENT ON COLUMN tb_employees.id_local IS 'Id do local de trabalho';
COMMENT ON COLUMN tb_employees.cpf IS 'CPF do registro';


CREATE SEQUENCE tb_emails_seq_email_seq;

CREATE TABLE tb_emails (
                seq_email INTEGER NOT NULL DEFAULT nextval('tb_emails_seq_email_seq'),
                cpf BIGINT NOT NULL,
                email VARCHAR NOT NULL,
                CONSTRAINT tb_emails_pk PRIMARY KEY (seq_email, cpf)
);
COMMENT ON TABLE tb_emails IS 'Tabela de email de registros';
COMMENT ON COLUMN tb_emails.seq_email IS 'Sequencial de email';
COMMENT ON COLUMN tb_emails.cpf IS 'CPF do registro';
COMMENT ON COLUMN tb_emails.email IS 'Email do registro';


ALTER SEQUENCE tb_emails_seq_email_seq OWNED BY tb_emails.seq_email;

CREATE TABLE tb_dependents (
                cpf BIGINT NOT NULL,
                cpf_dependent BIGINT NOT NULL,
                id_dependence_type INTEGER NOT NULL,
                CONSTRAINT tb_dependences_pk PRIMARY KEY (cpf, cpf_dependent, id_dependence_type)
);
COMMENT ON TABLE tb_dependents IS 'Tabela de dependentes';
COMMENT ON COLUMN tb_dependents.id_dependence_type IS 'id do tipo de dependencia';


CREATE SEQUENCE tb_addresses_seq_address_seq;

CREATE TABLE tb_addresses (
                seq_address INTEGER NOT NULL DEFAULT nextval('tb_addresses_seq_address_seq'),
                cpf BIGINT NOT NULL,
                address VARCHAR NOT NULL,
                number INTEGER NOT NULL,
                CONSTRAINT tb_addresses_pk PRIMARY KEY (seq_address, cpf)
);
COMMENT ON TABLE tb_addresses IS 'Tabela de endereços de registros';
COMMENT ON COLUMN tb_addresses.seq_address IS 'Coluna com sequencial de endereços da tabela para registros';
COMMENT ON COLUMN tb_addresses.cpf IS 'CPF do registro';
COMMENT ON COLUMN tb_addresses.address IS 'Coluna de logradouro do endereço';
COMMENT ON COLUMN tb_addresses.number IS 'Numero do endereço';


ALTER SEQUENCE tb_addresses_seq_address_seq OWNED BY tb_addresses.seq_address;

CREATE TABLE tb_access (
                cpf BIGINT NOT NULL,
                login VARCHAR NOT NULL,
                password VARCHAR NOT NULL,
                CONSTRAINT tb_access_pk PRIMARY KEY (cpf)
);
COMMENT ON TABLE tb_access IS 'Tabela de acesso de registros';
COMMENT ON COLUMN tb_access.cpf IS 'CPF do registro';
COMMENT ON COLUMN tb_access.login IS 'Login';
COMMENT ON COLUMN tb_access.password IS 'Senha';


CREATE TABLE tb_allergies (
                id_allergy INTEGER NOT NULL,
                cpf BIGINT NOT NULL,
                CONSTRAINT tb_allergies_pk PRIMARY KEY (id_allergy, cpf)
);


CREATE TABLE tb_diseases (
                id_disease INTEGER NOT NULL,
                cpf BIGINT NOT NULL,
                CONSTRAINT tb_diseases_pk PRIMARY KEY (id_disease, cpf)
);


CREATE SEQUENCE tb_phones_seq_phone_seq;

CREATE TABLE tb_phones (
                cpf BIGINT NOT NULL,
                seq_phone INTEGER NOT NULL DEFAULT nextval('tb_phones_seq_phone_seq'),
                phone_number BIGINT NOT NULL,
                CONSTRAINT tb_phones_pk PRIMARY KEY (cpf, seq_phone)
);
COMMENT ON TABLE tb_phones IS 'Tabela de telefones de registros';
COMMENT ON COLUMN tb_phones.cpf IS 'CPF do registro';
COMMENT ON COLUMN tb_phones.seq_phone IS 'Sequencial de telefone';
COMMENT ON COLUMN tb_phones.phone_number IS 'Número do telefone';


ALTER SEQUENCE tb_phones_seq_phone_seq OWNED BY tb_phones.seq_phone;

CREATE TABLE tb_vaccinations (
                cpf BIGINT NOT NULL,
                id_vaccine INTEGER NOT NULL,
                date_vaccination DATE NOT NULL,
                cre BIGINT NOT NULL,
                id_local INTEGER NOT NULL,
                dose INTEGER NOT NULL,
                CONSTRAINT tb_vaccinations_pk PRIMARY KEY (cpf, id_vaccine, date_vaccination, cre, id_local)
);
COMMENT ON TABLE tb_vaccinations IS 'Tabela de vacinação';
COMMENT ON COLUMN tb_vaccinations.cpf IS 'CPF do registro';
COMMENT ON COLUMN tb_vaccinations.id_vaccine IS 'Id da vacina';
COMMENT ON COLUMN tb_vaccinations.date_vaccination IS 'Data da vacinação';
COMMENT ON COLUMN tb_vaccinations.cre IS 'Número do CRE';
COMMENT ON COLUMN tb_vaccinations.id_local IS 'Id do local de trabalho';
COMMENT ON COLUMN tb_vaccinations.dose IS 'Dose da vacina';


ALTER TABLE tb_dependents ADD CONSTRAINT dm_dependence_type_tb_dependents_fk
FOREIGN KEY (id_dependence_type)
REFERENCES dm_dependence_type (id_dependence_type)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_vaccines ADD CONSTRAINT dm_vaccine_type_vaccine_fk
FOREIGN KEY (id_type)
REFERENCES dm_vaccine_type (id_type)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_allergies ADD CONSTRAINT dm_allergy_allergy_fk
FOREIGN KEY (id_allergy)
REFERENCES dm_allergy (id_allergy)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_diseases ADD CONSTRAINT dm_disease_disease_fk
FOREIGN KEY (id_disease)
REFERENCES dm_disease (id_disease)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_employees ADD CONSTRAINT dm_local_tb_employees_fk
FOREIGN KEY (id_local)
REFERENCES dm_local (id_local)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_vaccinations ADD CONSTRAINT vaccine_vaccination_fk
FOREIGN KEY (id_vaccine)
REFERENCES tb_vaccines (id_vaccine)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_vaccinations ADD CONSTRAINT pessoa_vacinacao_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_phones ADD CONSTRAINT pessoa_telefone_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_diseases ADD CONSTRAINT pessoa_disease_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_allergies ADD CONSTRAINT pessoa_allergy_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_access ADD CONSTRAINT pessoa_acesso_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_addresses ADD CONSTRAINT pessoa_endereco_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_dependents ADD CONSTRAINT person_dependents_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_dependents ADD CONSTRAINT person_dependents_fk1
FOREIGN KEY (cpf_dependent)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_emails ADD CONSTRAINT tb_person_tb_emails_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_employees ADD CONSTRAINT tb_person_tb_employees_fk
FOREIGN KEY (cpf)
REFERENCES tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_vaccinations ADD CONSTRAINT tb_employees_tb_vaccinations_fk
FOREIGN KEY (cre, id_local)
REFERENCES tb_employees (cre, id_local)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
