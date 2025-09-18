-- 코드를 작성해주세요
# 1. 연도별 가장 큰 대장균 크기 구하기
# 2. 편차 구하기
# 3. 연도 오름차순, 크기 오름차순

select ed2.year as YEAR, (ed2.size - ed1.SIZE_OF_COLONY) as YEAR_DEV, ed1.ID
from ECOLI_DATA as ed1
join (select YEAR(DIFFERENTIATION_DATE) as year, MAX(SIZE_OF_COLONY) as size 
from ECOLI_DATA as ed2
group by YEAR(DIFFERENTIATION_DATE)) as ed2 on YEAR(ed1.DIFFERENTIATION_DATE) = ed2.year
order by YEAR, YEAR_DEV