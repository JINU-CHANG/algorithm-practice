-- 코드를 입력하세요

# - '트럭' 의 대여 기록, 기록별로 대여 금액을 구하기
# - 대여 금액 기준 내림차순, 대여 기록 ID 기준 내림차순
# - 정수 부분만 출력되어야 함


select sub.history_id, 
ROUND((sub.daily_fee * ((100 - IFNULL(p.discount_rate, 0)) / 100) *  sub.period)) as fee
from (
    select 
    h.history_id, daily_fee, car_type, DATEDIFF(end_date, start_date) + 1 as period,
    case 
          WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
      WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '30일 이상'
      WHEN DATEDIFF(end_date, start_date) + 1 >= 7 THEN '7일 이상'
    end as duration_type
    from CAR_RENTAL_COMPANY_CAR as c
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on c.car_id = h.car_id
    where c.car_type = '트럭'   
) as sub
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p 
      on sub.car_type = p.car_type and sub.duration_type = p.duration_type
order by fee desc, history_id desc