-- 코드를 입력하세요

select food_type, rest_id, rest_name, favorites
from (
    select food_type, rest_id, rest_name, favorites, 
    row_number() over (partition by food_type order by favorites desc) as rk
    from rest_info as r 
) as sub where rk <= 1
order by food_type desc;
