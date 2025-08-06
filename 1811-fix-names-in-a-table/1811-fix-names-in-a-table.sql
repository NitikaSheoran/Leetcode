# Write your MySQL query statement below
select user_id, CONCAT(UPPER(LEFT(LOWER(name), 1)), SUBSTRING(LOWER(name), 2)) as name
from Users
order by user_id