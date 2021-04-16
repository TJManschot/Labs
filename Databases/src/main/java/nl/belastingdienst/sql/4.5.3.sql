use pubs;

SELECT SUM(qty) total_books_sold_outside_1994
FROM sales
WHERE ord_date NOT LIKE '1994%';