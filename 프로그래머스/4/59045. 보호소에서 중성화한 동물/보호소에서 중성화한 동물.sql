-- 코드를 입력하세요

# - 보호소 오기전에는 중성화 X, 나갈때는 중성화 O
# - 아이디 순으로 조회

select i.animal_id, i.animal_type, i.name from ANIMAL_INS as i
join ANIMAL_OUTS as o on i.animal_id = o.animal_id
where i.SEX_UPON_INTAKE like ('%Intact%') 
    and (o.SEX_UPON_OUTCOME like ('%Spayed%') 
         or o.SEX_UPON_OUTCOME like ('%Neutered%'))
order by animal_id asc