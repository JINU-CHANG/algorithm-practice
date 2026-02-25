-- 코드를 입력하세요

# - 입양 X, 오랫동안 보호소에 있었던 동물 3마리
# - 보호 시작일 asc

select i.name, i.datetime from ANIMAL_INS as i
where i.animal_id not in (
    select animal_id from ANIMAL_OUTS as o
)
order by datetime asc
limit 3