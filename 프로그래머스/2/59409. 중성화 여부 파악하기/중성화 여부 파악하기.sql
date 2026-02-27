-- 코드를 입력하세요

# 아이디 순으로 조회
# 중성화 여부, 'O', 'X'

select animal_id, name,
case
    when SEX_UPON_INTAKE like '%Neutered%' then 'O'
    when SEX_UPON_INTAKE like '%Spayed%' then 'O'
else 'X'
end as '중성화'
from ANIMAL_INS
order by animal_id