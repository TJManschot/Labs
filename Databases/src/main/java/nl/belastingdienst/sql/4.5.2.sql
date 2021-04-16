use pubs;

SELECT au_id author_id
FROM authors
WHERE address LIKE '%Broadway%'
  AND city = 'San Francisco';