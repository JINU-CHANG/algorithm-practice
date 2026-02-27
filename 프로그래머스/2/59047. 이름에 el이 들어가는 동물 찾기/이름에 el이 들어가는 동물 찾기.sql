-- 코드를 입력하세요

# %el%
# 이름 순 asc, 대소문자 구별 X

select animal_id, name from ANIMAL_INS
where lower(name) like '%el%' and animal_type = 'Dog'
order by name asc;