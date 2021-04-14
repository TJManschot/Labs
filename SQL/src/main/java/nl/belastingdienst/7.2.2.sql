use pubs;

DELETE FROM roysched
WHERE title_id = (-- title id of 'Live Without Fear'
                SELECT title_id
                FROM titles
                WHERE title = 'Live Without Fear');

DELETE FROM roysched
WHERE title_id NOT IN (-- all title ids except the one for 'Live Without Fear'
                      SELECT title_id
                      FROM titles
                      WHERE title <> 'Live Without Fear');