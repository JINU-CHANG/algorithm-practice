-- 코드를 입력하세요

select YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, GENDER, count(distinct o.USER_ID) as USERS
from ONLINE_SALE as o
join USER_INFO as u on u.USER_ID = o.USER_ID
where GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER;