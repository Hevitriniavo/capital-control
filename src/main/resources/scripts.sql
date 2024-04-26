CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    first_name VARCHAR(100),
    address TEXT,
    phone_number VARCHAR(20),
    email VARCHAR(100),
    date_of_birth DATE
);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

CREATE TABLE subcategories (
    id SERIAL PRIMARY KEY,
    category_id INT REFERENCES categories(id),
    name VARCHAR(100)
);

CREATE TABLE currencies (
    id SERIAL PRIMARY KEY,
    currency_code VARCHAR(3) UNIQUE,
    country_name VARCHAR(100)
);

CREATE TABLE currency_conversion_rates (
    id SERIAL PRIMARY KEY,
    source_currency_id VARCHAR(3) REFERENCES currencies(id),
    target_currency_id VARCHAR(3) REFERENCES currencies(id),
    exchange_rate DECIMAL(15, 6)
);


CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    client_id INT REFERENCES clients(id),
    balance DECIMAL(15, 2),
    account_number VARCHAR(20) UNIQUE,
    opening_date DATE,
    loan_limit DECIMAL(15, 2),
    has_overdraft BOOLEAN DEFAULT FALSE,
    net_salary DECIMAL(15, 2),
    currency_id VARCHAR(3) REFERENCES currencies(id)
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_id INT REFERENCES accounts(id),
    transaction_type VARCHAR(50),
    amount DECIMAL(15, 2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    subcategory_id INT REFERENCES subcategories(id),
    description TEXT
);

CREATE TABLE transfers (
    id SERIAL PRIMARY KEY,
    source_account_id INT REFERENCES accounts(id),
    destination_account_id INT REFERENCES accounts(id),
    amount DECIMAL(15, 2),
    reference VARCHAR(250) UNIQUE,
    transfer_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description TEXT,
    source_currency_id INT,
    subcategory_id INT REFERENCES subcategories(id),
    target_currency_id INT,
    FOREIGN KEY (source_currency_id, target_currency_id) REFERENCES currency_conversion_rates(id, id)
);

CREATE TABLE loans (
    id SERIAL PRIMARY KEY,
    borrower_id INT REFERENCES clients(id),
    amount DECIMAL(15, 2),
    loan_date DATE,
    repayment_date DATE,
    interest_rate DECIMAL(5, 2),
    status VARCHAR(50)
);


CREATE SEQUENCE account_number_sequence START 1000;

CREATE OR REPLACE FUNCTION generate_account_number()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.account_number IS NULL THEN
        NEW.account_number := 'ACC' || nextval('account_number_sequence');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER account_auto_number_trigger
BEFORE INSERT ON accounts
FOR EACH ROW
EXECUTE FUNCTION generate_account_number();


CREATE SEQUENCE transfer_reference_sequence START 1000;

CREATE OR REPLACE FUNCTION generate_transfer_reference()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.reference IS NULL THEN
        NEW.reference := 'TRF' || nextval('transfer_reference_sequence') || '-' || to_char(CURRENT_DATE, 'YYYYMMDD');
END IF;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER transfer_auto_reference_trigger
    BEFORE INSERT ON transfers
    FOR EACH ROW
    EXECUTE FUNCTION generate_transfer_reference();
