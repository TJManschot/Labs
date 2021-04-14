use pubs;

SELECT stor_id
FROM Discounts
WHERE discount = 5;

SELECT stor_name
FROM Stores
WHERE stor_id IN (SELECT stor_id
                 FROM Discounts
                 WHERE discount = 5);