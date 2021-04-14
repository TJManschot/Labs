use pubs;

CREATE TABLE publ_authors (name varchar(60));

INSERT INTO publ_authors
SELECT AU_LNAME
FROM authors;