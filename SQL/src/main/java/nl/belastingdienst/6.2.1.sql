use pubs;

SELECT CONCAT(au_fname, ' ', au_lname) author
FROM authors A
WHERE EXISTS (-- another author living in the same city
             SELECT *
             FROM authors
             WHERE city = A.city
               AND au_id <> A.au_id);