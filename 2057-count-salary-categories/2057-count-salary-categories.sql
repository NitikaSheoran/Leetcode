# Write your MySQL query statement below
select 'Low Salary' as category, count(low.account_id) as accounts_count
from Accounts low
where low.income < 20000
union
select 'High Salary' as category, count(high.account_id) as accounts_count
from Accounts high
where high.income > 50000
union
select 'Average Salary' as category, count(avrg.account_id) as accounts_count
from Accounts avrg
where avrg.income between 20000 and 50000