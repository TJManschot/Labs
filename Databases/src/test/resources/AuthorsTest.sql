CREATE TABLE IF NOT EXISTS authors
(
    au_id varchar(255) primary key,
    address varchar(255),
    au_fname varchar(255),
    au_lname varchar(255),
    city varchar(255),
    contract decimal(19,2),
    phone varchar(16),
    state varchar(2),
    zip varchar(16)
);

INSERT INTO authors (au_id, address, au_fname, au_lname, city, contract, phone, state, zip)
    VALUES ('1', '', 'Thomas', 'Test-Engine', '', 0.00, '', '', 0);

COMMIT;