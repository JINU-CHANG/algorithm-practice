-- 코드를 입력하세요

# 2022-03월 판매 날짜, 상품 ID, 유저 ID, 판매량 출력
# offline_sale 테이블 -> user_id값 null로 출력
# 판매일 기준 오름차순, 상품 ID 기준 오름차순, 유저 ID 기준 오름차순 정렬

select
DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE,
PRODUCT_ID,
USER_ID,
SALES_AMOUNT
from online_sale as ons
where sales_date like '2022-03%'
union all
select
DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE,
PRODUCT_ID,
null as user_id,
SALES_AMOUNT
from offline_sale
where sales_date like '2022-03%'
order by sales_date asc, product_id asc, user_id asc