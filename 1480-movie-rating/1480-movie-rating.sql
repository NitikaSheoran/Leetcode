# Write your MySQL query statement below
select results
from (
    select u.name as results
    from MovieRating mr join Users u on mr.user_id=u.user_id
    group by mr.user_id
    order by count(*) desc, u.name asc
    limit 1
) as topUser
union all
select results
from (
    select m.title as results
    from MovieRating mr join Movies m on mr.movie_id = m.movie_id
    where mr.created_at like '2020-02%'
    group by mr.movie_id
    order by avg(rating) desc, m.title asc
    limit 1
) as topMovie