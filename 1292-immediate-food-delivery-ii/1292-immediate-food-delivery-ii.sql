# Write your MySQL query statement below
select round(count(*)*100/(Select count(distinct customer_id) from Delivery), 2) as immediate_percentage
from (
    Select customer_id, min(order_date) as first_order_date
    from Delivery
    group by customer_id
    ) as first_order
    join Delivery d on first_order.customer_id = d.customer_id and first_order.first_order_date = d.order_date
where d.order_date = d.customer_pref_delivery_date
