-- 코드를 입력하세요

# 서울에 위치한 식당
# 평균 점수 -> 소수점 세 번째 자리에서 반올림
# 평균 점수 기준으로 내림차순, 즐겨찾기 수 기준으로 내림차순

select 
distinct i.rest_id, i.rest_name, 
i.food_type, i.favorites, 
i.address,
round(avg(r.review_score) over (partition by rest_id), 2) as score
from REST_INFO as i
join rest_review as r on r.rest_id = i.rest_id
where address like '서울%'
order by score desc, favorites desc;