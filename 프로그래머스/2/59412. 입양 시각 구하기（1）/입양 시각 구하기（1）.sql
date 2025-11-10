-- 코드를 입력하세요
select HOUR(DATETIME) as HOUR, count(*) as COUNT from ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20
group by HOUR(DATETIME)
order by HOUR;