
CREATE SCHEMA IF NOT EXISTS vacinacao;

CREATE SEQUENCE vacinacao.dm_dependence_type_id_dependence_type_seq_1;

CREATE TABLE vacinacao.dm_dependence_type (
                id_dependence_type INTEGER NOT NULL DEFAULT nextval('vacinacao.dm_dependence_type_id_dependence_type_seq_1'),
                description VARCHAR NOT NULL,
                CONSTRAINT id_dependence_type PRIMARY KEY (id_dependence_type)
);
COMMENT ON TABLE vacinacao.dm_dependence_type IS 'Tabela do tipo de dependencia';
COMMENT ON COLUMN vacinacao.dm_dependence_type.id_dependence_type IS 'id do tipo de dependencia';
COMMENT ON COLUMN vacinacao.dm_dependence_type.description IS 'Descrição do tipo de dependencia';


ALTER SEQUENCE vacinacao.dm_dependence_type_id_dependence_type_seq_1 OWNED BY vacinacao.dm_dependence_type.id_dependence_type;

CREATE TABLE vacinacao.dm_vaccine_type (
                id_type INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT dm_vaccine_type_pk PRIMARY KEY (id_type)
);
COMMENT ON TABLE vacinacao.dm_vaccine_type IS 'Tabela domínio de tipos de vacinas';
COMMENT ON COLUMN vacinacao.dm_vaccine_type.id_type IS 'Id do tipo de vacina';
COMMENT ON COLUMN vacinacao.dm_vaccine_type.name IS 'Nome do tipo de vacina';


CREATE TABLE vacinacao.dm_allergy (
                id_allergy INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT dm_allergy_pk PRIMARY KEY (id_allergy)
);
COMMENT ON TABLE vacinacao.dm_allergy IS 'Tabela domínio de alergias';
COMMENT ON COLUMN vacinacao.dm_allergy.id_allergy IS 'Id da alergia';
COMMENT ON COLUMN vacinacao.dm_allergy.name IS 'nome da alergia';


CREATE TABLE vacinacao.dm_disease (
                id_disease INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT dm_diseases_pk PRIMARY KEY (id_disease)
);
COMMENT ON TABLE vacinacao.dm_disease IS 'Tabela domínio de doenças';
COMMENT ON COLUMN vacinacao.dm_disease.id_disease IS 'id da doença';
COMMENT ON COLUMN vacinacao.dm_disease.name IS 'Nome da doença';


CREATE TABLE vacinacao.dm_local (
                id_local INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                CONSTRAINT dm_local_pk PRIMARY KEY (id_local)
);
COMMENT ON TABLE vacinacao.dm_local IS 'Tabela de locais de vacinação';
COMMENT ON COLUMN vacinacao.dm_local.id_local IS 'Id do local';
COMMENT ON COLUMN vacinacao.dm_local.name IS 'Nome do local';
COMMENT ON COLUMN vacinacao.dm_local.address IS 'Endereço do local';


CREATE TABLE vacinacao.tb_vaccines (
                id_vaccine INTEGER NOT NULL,
                lot INTEGER NOT NULL,
                validate DATE NOT NULL,
                name VARCHAR NOT NULL,
                id_type INTEGER NOT NULL,
                CONSTRAINT tb_vaccines_pk PRIMARY KEY (id_vaccine)
);
COMMENT ON TABLE vacinacao.tb_vaccines IS 'Tabela de vacinas';
COMMENT ON COLUMN vacinacao.tb_vaccines.id_vaccine IS 'Id da vacina';
COMMENT ON COLUMN vacinacao.tb_vaccines.lot IS 'Lote da vacina';
COMMENT ON COLUMN vacinacao.tb_vaccines.validate IS 'Validade da vacina';
COMMENT ON COLUMN vacinacao.tb_vaccines.name IS 'Nome da vacina';
COMMENT ON COLUMN vacinacao.tb_vaccines.id_type IS 'Id do tipo de vacina';


CREATE TABLE vacinacao.tb_person (
                cpf BIGINT NOT NULL,
                name VARCHAR NOT NULL,
                rg VARCHAR NOT NULL,
                weight INTEGER,
                has_tattoo BOOLEAN NOT NULL,
                dt_birth DATE NOT NULL,
                CONSTRAINT tb_person_pk PRIMARY KEY (cpf)
);
COMMENT ON TABLE vacinacao.tb_person IS 'Tabela de registros de pessoas';
COMMENT ON COLUMN vacinacao.tb_person.cpf IS 'CPF do registro';
COMMENT ON COLUMN vacinacao.tb_person.name IS 'Nome do registro';
COMMENT ON COLUMN vacinacao.tb_person.rg IS 'RG do registro';
COMMENT ON COLUMN vacinacao.tb_person.weight IS 'Peso do registro';
COMMENT ON COLUMN vacinacao.tb_person.has_tattoo IS 'Campo para saber se registro tem tatuagem';
COMMENT ON COLUMN vacinacao.tb_person.dt_birth IS 'Data de nascimento do registro';


CREATE TABLE vacinacao.tb_employees (
                cre BIGINT NOT NULL,
                id_local INTEGER NOT NULL,
                cpf BIGINT NOT NULL,
                CONSTRAINT tb_employees_pk PRIMARY KEY (cre, id_local)
);
COMMENT ON TABLE vacinacao.tb_employees IS 'Tabela de empregados';
COMMENT ON COLUMN vacinacao.tb_employees.cre IS 'Número do CRE';
COMMENT ON COLUMN vacinacao.tb_employees.id_local IS 'Id do local de trabalho';
COMMENT ON COLUMN vacinacao.tb_employees.cpf IS 'CPF do registro';


CREATE SEQUENCE vacinacao.tb_emails_seq_email_seq;

CREATE TABLE vacinacao.tb_emails (
                seq_email INTEGER NOT NULL DEFAULT nextval('vacinacao.tb_emails_seq_email_seq'),
                cpf BIGINT NOT NULL,
                email VARCHAR NOT NULL,
                CONSTRAINT tb_emails_pk PRIMARY KEY (seq_email, cpf)
);
COMMENT ON TABLE vacinacao.tb_emails IS 'Tabela de email de registros';
COMMENT ON COLUMN vacinacao.tb_emails.seq_email IS 'Sequencial de email';
COMMENT ON COLUMN vacinacao.tb_emails.cpf IS 'CPF do registro';
COMMENT ON COLUMN vacinacao.tb_emails.email IS 'Email do registro';


ALTER SEQUENCE vacinacao.tb_emails_seq_email_seq OWNED BY vacinacao.tb_emails.seq_email;

CREATE TABLE vacinacao.tb_dependents (
                cpf BIGINT NOT NULL,
                cpf_dependent BIGINT NOT NULL,
                id_dependence_type INTEGER NOT NULL,
                CONSTRAINT tb_dependences_pk PRIMARY KEY (cpf, cpf_dependent, id_dependence_type)
);
COMMENT ON TABLE vacinacao.tb_dependents IS 'Tabela de dependentes';
COMMENT ON COLUMN vacinacao.tb_dependents.id_dependence_type IS 'id do tipo de dependencia';


CREATE SEQUENCE vacinacao.tb_addresses_seq_address_seq;

CREATE TABLE vacinacao.tb_addresses (
                seq_address INTEGER NOT NULL DEFAULT nextval('vacinacao.tb_addresses_seq_address_seq'),
                cpf BIGINT NOT NULL,
                address VARCHAR NOT NULL,
                number INTEGER NOT NULL,
                CONSTRAINT tb_addresses_pk PRIMARY KEY (seq_address, cpf)
);
COMMENT ON TABLE vacinacao.tb_addresses IS 'Tabela de endereços de registros';
COMMENT ON COLUMN vacinacao.tb_addresses.seq_address IS 'Coluna com sequencial de endereços da tabela para registros';
COMMENT ON COLUMN vacinacao.tb_addresses.cpf IS 'CPF do registro';
COMMENT ON COLUMN vacinacao.tb_addresses.address IS 'Coluna de logradouro do endereço';
COMMENT ON COLUMN vacinacao.tb_addresses.number IS 'Numero do endereço';


ALTER SEQUENCE vacinacao.tb_addresses_seq_address_seq OWNED BY vacinacao.tb_addresses.seq_address;

CREATE TABLE vacinacao.tb_access (
                cpf BIGINT NOT NULL,
                login VARCHAR NOT NULL,
                password VARCHAR NOT NULL,
                CONSTRAINT tb_access_pk PRIMARY KEY (cpf)
);
COMMENT ON TABLE vacinacao.tb_access IS 'Tabela de acesso de registros';
COMMENT ON COLUMN vacinacao.tb_access.cpf IS 'CPF do registro';
COMMENT ON COLUMN vacinacao.tb_access.login IS 'Login';
COMMENT ON COLUMN vacinacao.tb_access.password IS 'Senha';


CREATE TABLE vacinacao.tb_allergies (
                id_allergy INTEGER NOT NULL,
                cpf BIGINT NOT NULL,
                CONSTRAINT tb_allergies_pk PRIMARY KEY (id_allergy, cpf)
);


CREATE TABLE vacinacao.tb_diseases (
                id_disease INTEGER NOT NULL,
                cpf BIGINT NOT NULL,
                CONSTRAINT tb_diseases_pk PRIMARY KEY (id_disease, cpf)
);


CREATE SEQUENCE vacinacao.tb_phones_seq_phone_seq;

CREATE TABLE vacinacao.tb_phones (
                cpf BIGINT NOT NULL,
                seq_phone INTEGER NOT NULL DEFAULT nextval('vacinacao.tb_phones_seq_phone_seq'),
                phone_number BIGINT NOT NULL,
                CONSTRAINT tb_phones_pk PRIMARY KEY (cpf, seq_phone)
);
COMMENT ON TABLE vacinacao.tb_phones IS 'Tabela de telefones de registros';
COMMENT ON COLUMN vacinacao.tb_phones.cpf IS 'CPF do registro';
COMMENT ON COLUMN vacinacao.tb_phones.seq_phone IS 'Sequencial de telefone';
COMMENT ON COLUMN vacinacao.tb_phones.phone_number IS 'Número do telefone';


ALTER SEQUENCE vacinacao.tb_phones_seq_phone_seq OWNED BY vacinacao.tb_phones.seq_phone;

CREATE TABLE vacinacao.tb_vaccinations (
                cpf BIGINT NOT NULL,
                id_vaccine INTEGER NOT NULL,
                date_vaccination DATE NOT NULL,
                cre BIGINT NOT NULL,
                id_local INTEGER NOT NULL,
                dose INTEGER NOT NULL,
                CONSTRAINT tb_vaccinations_pk PRIMARY KEY (cpf, id_vaccine, date_vaccination, cre, id_local)
);
COMMENT ON TABLE vacinacao.tb_vaccinations IS 'Tabela de vacinação';
COMMENT ON COLUMN vacinacao.tb_vaccinations.cpf IS 'CPF do registro';
COMMENT ON COLUMN vacinacao.tb_vaccinations.id_vaccine IS 'Id da vacina';
COMMENT ON COLUMN vacinacao.tb_vaccinations.date_vaccination IS 'Data da vacinação';
COMMENT ON COLUMN vacinacao.tb_vaccinations.cre IS 'Número do CRE';
COMMENT ON COLUMN vacinacao.tb_vaccinations.id_local IS 'Id do local de trabalho';
COMMENT ON COLUMN  vacinacao.tb_vaccinations.dose IS 'Dose da vacina';


ALTER TABLE vacinacao.tb_dependents add constraint dm_dependence_type_tb_dependents_fk
FOREIGN KEY (id_dependence_type)
REFERENCES vacinacao.dm_dependence_type (id_dependence_type)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_vaccines add constraint dm_vaccine_type_vaccine_fk
FOREIGN KEY (id_type)
REFERENCES vacinacao.dm_vaccine_type (id_type)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_allergies add constraint dm_allergy_allergy_fk
FOREIGN KEY (id_allergy)
REFERENCES vacinacao.dm_allergy (id_allergy)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_diseases add constraint dm_disease_disease_fk
FOREIGN KEY (id_disease)
REFERENCES vacinacao.dm_disease (id_disease)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_employees add constraint dm_local_tb_employees_fk
FOREIGN KEY (id_local)
REFERENCES vacinacao.dm_local (id_local)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_vaccinations add constraint vaccine_vaccination_fk
FOREIGN KEY (id_vaccine)
REFERENCES vacinacao.tb_vaccines (id_vaccine)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_vaccinations add constraint pessoa_vacinacao_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_phones add constraint pessoa_telefone_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_diseases add constraint pessoa_disease_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_allergies add constraint pessoa_allergy_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_access add constraint pessoa_acesso_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_addresses add constraint pessoa_endereco_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_dependents add constraint person_dependents_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_emails add constraint tb_person_tb_emails_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_employees add constraint tb_person_tb_employees_fk
FOREIGN KEY (cpf)
REFERENCES vacinacao.tb_person (cpf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE vacinacao.tb_vaccinations add constraint tb_employees_tb_vaccinations_fk
FOREIGN KEY (cre, id_local)
REFERENCES vacinacao.tb_employees (cre, id_local)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

insert into vacinacao.dm_vaccine_type values (1, 'Imunização');
insert into vacinacao.dm_vaccine_type values (2, 'Virais');

insert into vacinacao.dm_dependence_type values (1, 'Filho');
insert into vacinacao.dm_dependence_type values (2, 'Filha');
insert into vacinacao.dm_dependence_type values (3, 'Marido');
insert into vacinacao.dm_dependence_type values (4, 'Esposa');
insert into vacinacao.dm_dependence_type values (5, 'Outros');