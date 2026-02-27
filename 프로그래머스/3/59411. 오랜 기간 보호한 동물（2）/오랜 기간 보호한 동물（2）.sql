-- 코드를 입력하세요

# 입양 간 동물 중, 보호 기간이 가장 길었던 동물 두마리
# 보호 기간 desc

select i.animal_id, i.name from ANIMAL_INS as i
join ANIMAL_OUTS as o on i.animal_id = o.animal_id
order by datediff(o.datetime, i.datetime) desc 
limit 2