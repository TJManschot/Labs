use pubs;

CREATE VIEW book_count_per_category_per_publisher (
    publisher,
    category,
    amount) AS
SELECT pub_id,
       type,
       count(*)
FROM titles
GROUP BY pub_id,
         type
ORDER BY 1;

SELECT *
FROM book_count_per_category_per_publisher;