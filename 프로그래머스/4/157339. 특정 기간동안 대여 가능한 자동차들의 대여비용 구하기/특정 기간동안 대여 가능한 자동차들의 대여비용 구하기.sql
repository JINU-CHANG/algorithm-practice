-- 코드를 입력하세요


# 1. 세단 or SUV
# 2. 대여 가능

select c.car_id, 
    c.car_type, 
    FLOOR(daily_fee * ((100 - discount_rate) / 100) * 30) as FEE
from CAR_RENTAL_COMPANY_CAR as c
join (
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    where car_id not in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date <= '2022-11-30' AND end_date >= '2022-11-01')
) as sub on c.car_id = sub.car_id 
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p 
    on c.car_type = p.car_type
where (c.car_type = '세단' or c.car_type = 'SUV') and duration_type = '30일 이상'
group by car_id
having (FEE >= 500000 AND FEE < 2000000)
ORDER BY FEE desc, car_type asc, car_id desc;

