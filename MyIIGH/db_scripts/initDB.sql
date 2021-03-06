DROP TABLE IF EXISTS transaction;

DROP TABLE IF EXISTS bank_account;
DROP TABLE IF EXISTS bank_account_status;
DROP TABLE IF EXISTS bank_account_type;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_status;

DROP SEQUENCE IF EXISTS transaction_sequence;

CREATE TABLE roles (
	role_id NUMERIC(20) NOT NULL,
	role_name VARCHAR(15) NOT NULL,
	role_display_name VARCHAR(30) NOT NULL,
	CONSTRAINT roles_pk PRIMARY KEY (role_id)
	);

CREATE TABLE user_status (
	user_status_id NUMERIC(20) NOT NULL,
	status_name VARCHAR(15) NOT NULL,
	status_display_name VARCHAR(30) NOT NULL,
	CONSTRAINT user_status_pk PRIMARY KEY (user_status_id)
	);

CREATE TABLE users (
	login_name VARCHAR(30) NOT NULL,
	password_hash VARCHAR(128) NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	role_id NUMERIC(20) NOT NULL,
	postal_address VARCHAR(100) NOT NULL,
	phone VARCHAR(30) NOT NULL,
	email VARCHAR(100) NOT NULL,
	newsletter CHAR(1) NOT NULL,
	date_of_birth DATE,
	registration_date TIMESTAMP DEFAULT NOW() NOT NULL,
	last_login_date TIMESTAMP,
	user_status_id NUMERIC(20) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (login_name),
	CONSTRAINT users_ck1 CHECK (LENGTH(login_name) >= 5),
	CONSTRAINT users_ck2 CHECK (LENGTH(password_hash) = 64),
	CONSTRAINT users_ck3 CHECK (
		newsletter = 'Y'
		OR newsletter = 'N'
		),
	CONSTRAINT users_fk1 FOREIGN KEY (role_id) REFERENCES roles(role_id),
	CONSTRAINT users_fk2 FOREIGN KEY (user_status_id) REFERENCES user_status(user_status_id)
	);

CREATE TABLE bank_account_status (
	bank_account_status_id NUMERIC(20) NOT NULL,
	status_name VARCHAR(15) NOT NULL,
	status_display_name VARCHAR(30) NOT NULL,
	CONSTRAINT bank_account_status_pk PRIMARY KEY (bank_account_status_id)
	);

CREATE TABLE bank_account_type (
	bank_account_type_id NUMERIC(20) NOT NULL,
	type_name VARCHAR(30) NOT NULL,
	type_display_name VARCHAR(30) NOT NULL,
	CONSTRAINT bank_account_type_pk PRIMARY KEY (bank_account_type_id)
	);

CREATE TABLE bank_account (
	bank_account_number VARCHAR(34) NOT NULL,
	alias_name VARCHAR(50),
	login_name VARCHAR(30) NOT NULL,
	current_balance NUMERIC(20) NOT NULL,
	currency_type CHAR(3) NOT NULL,
	bank_account_status_id NUMERIC(20) NOT NULL,
	bank_account_type_id NUMERIC(20) NOT NULL,
	CONSTRAINT bank_account_pk PRIMARY KEY (bank_account_number),
	CONSTRAINT bank_account_fk1 FOREIGN KEY (login_name) REFERENCES users(login_name),
	CONSTRAINT bank_account_fk2 FOREIGN KEY (bank_account_status_id) REFERENCES bank_account_status(bank_account_status_id),
	CONSTRAINT bank_account_fk3 FOREIGN KEY (bank_account_type_id) REFERENCES bank_account_type(bank_account_type_id)
	);

CREATE SEQUENCE transaction_sequence;

CREATE TABLE transaction (
	transaction_id NUMERIC(20) NOT NULL,
	from_bank_account_number VARCHAR(34) NOT NULL,
	to_bank_account_number VARCHAR(34) NOT NULL,
	beneficiary_name VARCHAR(30) NOT NULL,
	transaction_date TIMESTAMP DEFAULT NOW() NOT NULL,
	amount NUMERIC(20) NOT NULL,
	transaction_comment VARCHAR(140),
	CONSTRAINT transaction_pk PRIMARY KEY (transaction_id),
	CONSTRAINT transaction_fk1 FOREIGN KEY (from_bank_account_number) REFERENCES bank_account(bank_account_number),
	CONSTRAINT transaction_fk2 FOREIGN KEY (to_bank_account_number) REFERENCES bank_account(bank_account_number),
	CONSTRAINT transaction_ck CHECK (amount < 2000000)
	);

INSERT INTO roles (role_id, role_name, role_display_name) VALUES (1, 'admin', 'Adminisztrátor');
INSERT INTO roles (role_id, role_name, role_display_name) VALUES (2, 'user', 'Ügyfél');
INSERT INTO user_status (user_status_id, status_name,status_display_name) VALUES (1, 'pending', 'Függőben levő aktiválás');
INSERT INTO user_status (user_status_id, status_name,status_display_name) VALUES (2, 'active','Aktív');
INSERT INTO user_status (user_status_id, status_name,status_display_name) VALUES (3, 'inactive', 'Inaktív' );
INSERT INTO bank_account_status (bank_account_status_id, status_name,status_display_name) VALUES (1, 'active','Aktív');
INSERT INTO bank_account_status (bank_account_status_id, status_name,status_display_name) VALUES (2, 'inactive','Zárolt');
INSERT INTO bank_account_type (bank_account_type_id, type_name,type_display_name) VALUES (1,'privateDeposit', 'Lakossági folyószámla');
INSERT INTO bank_account_type (bank_account_type_id, type_name,type_display_name) VALUES (2,'privateCredit', 'Lakossági hitelszámla');
COMMIT;