-- 코드를 입력하세요

# - 주문정보
# - 2022-05-01
# - 출고여부 -> '출고완료', '출고미정', '출고대기'

select 
ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE,'%Y-%m-%d') as OUT_DATE,
case
    when OUT_DATE <= '2022-05-01' then '출고완료'
    when OUT_DATE > '2022-05-01' then '출고대기'
    else '출고미정'
end as '출고여부'
from FOOD_ORDER
order by order_id asc;