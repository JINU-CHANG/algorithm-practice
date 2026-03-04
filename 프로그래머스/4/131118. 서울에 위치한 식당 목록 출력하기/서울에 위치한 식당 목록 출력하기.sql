-- 코드를 입력하세요

# 서울에 위치한 식당
# 평균 점수 -> 소수점 세 번째 자리에서 반올림
# 평균 점수 기준으로 내림차순, 즐겨찾기 수 기준으로 내림차순

select 
i.rest_id, i.rest_name, 
i.food_type, i.favorites, 
i.address, sub.score as score
from REST_INFO as i
join (
    select rest_id, round(avg(review_score), 2) as score from rest_review
    group by rest_id
) as sub on sub.rest_id = i.rest_id
where address like '서울%'
order by score desc, favorites desc;
