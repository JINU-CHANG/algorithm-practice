-- 코드를 입력하세요

# - 생산일자 : 2022년 5월
# - 총매출을 조회
# - 총매출 기준으로 내림차순, 식품 ID 오름차순

select p.product_id, p.product_name, sum(price * amount) as total_sales from FOOD_PRODUCT as p
join FOOD_ORDER as o on p.product_id = o.product_id
where "2022-05-01" <= o.produce_date and o.produce_date <= "2022-05-31"
group by p.product_id
order by total_sales desc, p.product_id asc;