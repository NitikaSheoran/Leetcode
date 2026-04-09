# Write your MySQL query statement below
select t.id,
    case 
        when t.p_id is null then 'Root'
        when parent_count is null then 'Leaf'
        else 'Inner'
    end as type
from Tree t
left join (
    select p_id, count(*) as parent_count
    from Tree
    group by p_id
) as e on t.id = e.p_id
