use pubs;

UPDATE authors
SET address = '411 Highlands Ave.',
    phone = '436 908-8982'
WHERE au_fname = 'Sylvia'
  AND au_lname = 'Panteley';
