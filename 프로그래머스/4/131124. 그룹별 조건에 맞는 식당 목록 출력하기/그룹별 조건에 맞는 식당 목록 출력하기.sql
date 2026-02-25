-- 코드를 입력하세요

# - 리뷰를 가장 많이 작성한 회원
# - 리뷰 작성일 오름차순, 리뷰 텍스트 오름차순

select member_name, review_text, DATE_FORMAT(review_date,'%Y-%m-%d') as review_date from MEMBER_PROFILE as m
join REST_REVIEW as r on m.member_id = r.member_id
where m.member_id = (
        select member_id from REST_REVIEW
        group by member_id
        order by count(*) desc
        limit 1
)
order by review_date asc, review_text asc;