-- 코드를 작성해주세요

# 부모 개체, 자식 개체
# 분기별 분화된 대장균의 개체 총 수, 'Q' 오름차순으로 정렬

select
case
    when MONTH(DIFFERENTIATION_DATE) <= 3 then '1Q'
    when MONTH(DIFFERENTIATION_DATE) <= 6 then '2Q'
    when MONTH(DIFFERENTIATION_DATE) <= 9 then '3Q'
    else '4Q'
end as quarter,
count(*) as ECOLI_COUNT
from ECOLI_DATA
group by quarter
order by quarter