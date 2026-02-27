-- 코드를 작성해주세요

# 수원 연도 별 평균 미세먼지 오염도, 평균 초미세먼지 오염도 // 소수 셋째 자리에서 반올림

select YEAR(YM) as year, 
ROUND(AVG(PM_VAL1), 2) as 'PM10', 
ROUND(AVG(PM_VAL2), 2) as 'PM2.5' 
from AIR_POLLUTION
where location2 = '수원'
group by year
order by year asc;