-- 코드를 작성해주세요
select t2.score as SCORE, t1.EMP_NO, t1.EMP_NAME, t1.POSITION, t1.EMAIL
from HR_EMPLOYEES as t1
join (select SUM(score) as score, EMP_NO
from HR_GRADE
where YEAR = 2022
group by EMP_NO, YEAR
order by score desc
limit 1) as t2 on t1.EMP_NO = t2.EMP_NO;