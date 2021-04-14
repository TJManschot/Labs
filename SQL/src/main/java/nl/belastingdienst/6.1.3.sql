use pubs;

SELECT title, price
FROM titles
WHERE price >= 1.25 * (-- average book prices
                      SELECT avg(price)
                      FROM titles);