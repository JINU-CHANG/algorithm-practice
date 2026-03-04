-- 코드를 작성해주세요

# 크기 <= 100 -> 'LOW'
# 크기 <= 1000 -> 'MEDIUM'
# 크기 > 1000 -> 'HIGH'
# ID 오름차순 정렬

select id,
case when size_of_colony <= 100 then 'LOW'
    when size_of_colony <= 1000 then 'MEDIUM'
    else 'HIGH'
end as size
from ecoli_data
order by id asc;
