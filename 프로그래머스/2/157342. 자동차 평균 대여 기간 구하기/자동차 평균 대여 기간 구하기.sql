-- 코드를 입력하세요

# - 평균 대여 기간이 7일 이상
# - 자동차 ID, 평균 대여 기간 리스트 출력 (소수점 두번째 자리에서 반올림)
# - 평균 대여 기간을 기준으로 내림차순 정렬, 자동차 ID 기준 내림차순

select
car_id,
ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
group by car_id
having AVERAGE_DURATION >= 7
order by AVERAGE_DURATION desc, car_id desc