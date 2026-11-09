# Write your MySQL query statement below
select s.student_id, s.student_name, sub.subject_name, coalesce(e.exm_attended, 0) as attended_exams
from Students s cross join Subjects sub
left join (
    select student_id, subject_name, count(*) as exm_attended
    from Examinations
    group by student_id, subject_name
) as e on e.student_id = s.student_id and e.subject_name = sub.subject_name
order by student_id, subject_name