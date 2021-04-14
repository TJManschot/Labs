use pubs;

SELECT t.type category, avg(t.advance) average_advance, count(s.qty) total_sold
FROM titles t
         LEFT OUTER JOIN sales s ON t.TITLE_ID = s.TITLE_ID
GROUP BY t.type;

