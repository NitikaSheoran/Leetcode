# Write your MySQL query statement below
select w.id
from Weather w
where w.temperature > (
    select temperature
    from Weather f
    where DATEDIFF(w.recordDate, f.recordDate) = 1
)