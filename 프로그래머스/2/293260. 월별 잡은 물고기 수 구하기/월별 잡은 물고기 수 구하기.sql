-- 코드를 작성해주세요
select count(*) as FISH_COUNT, MONTH(TIME) as MONTH 
from fish_info 
group by MONTH(TIME)
order by MONTH(TIME) ASC;