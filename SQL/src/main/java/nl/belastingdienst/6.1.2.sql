use pubs;

SELECT CONCAT(au_fname, ' ', au_lname) author
FROM authors
WHERE city = (-- city of publisher Algodata Infosystems
             SELECT city
             FROM publishers
             WHERE pub_name = 'Algodata Infosystems');