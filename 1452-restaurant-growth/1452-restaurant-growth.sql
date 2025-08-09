# Write your MySQL query statement below
with daily_amount as (
    select visited_on, sum(amount) as amount
    from Customer
    group by visited_on
)
select c1.visited_on, sum(c2.amount) as amount, round(sum(c2.amount) / 7, 2) as average_amount
from daily_amount c1 join daily_amount c2 on c2.visited_on between DATE_SUB(c1.visited_on, INTERVAL 6 DAY) and c1.visited_on
group by c1.visited_on
having count(distinct c2.visited_on) = 7
order by c1.visited_on;

