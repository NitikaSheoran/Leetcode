# Write your MySQL query statement below
select e.id
from Weather e, Weather f
where DATEDIFF(e.recordDate, f.recordDate) = 1 and f.temperature<e.temperature;