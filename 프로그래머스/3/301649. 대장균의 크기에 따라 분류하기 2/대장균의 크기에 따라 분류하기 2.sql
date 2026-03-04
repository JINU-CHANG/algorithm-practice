-- 코드를 작성해주세요
select id,
case 
    when rk * 100 <= 25 then 'CRITICAL'
    when rk * 100 <= 50 then 'HIGH'
    when rk * 100 <= 75 then 'MEDIUM'
    else 'LOW'
end as 'colony_name'
from (
    select id, percent_rank() over (order by size_of_colony desc) as rk
    from ECOLI_DATA   
) as sub
order by id asc;