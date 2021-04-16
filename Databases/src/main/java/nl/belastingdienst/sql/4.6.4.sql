use pubs;

SELECT pub_id publisher,
       sum(advance) total_of_paid_advances,
       avg(price) average_book_price
FROM titles
WHERE price >= 5
GROUP BY publisher
HAVING total_of_paid_advances >= 15000
   AND average_book_price <= 20
    OR publisher > '0800';