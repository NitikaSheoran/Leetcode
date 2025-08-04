# Write your MySQL query statement below
select max(singleNum) as num
from (
    Select num as singleNum
    from MyNumbers
    group by num
    having count(*)=1
) as singles