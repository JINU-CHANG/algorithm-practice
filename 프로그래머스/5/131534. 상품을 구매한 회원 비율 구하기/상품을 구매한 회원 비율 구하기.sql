-- 코드를 입력하세요

# - 2021년, 가입 상품을 구매한 회원수, 상품을 구매한 회원의 비율(상품 구매 회원 수 / 전체 회원 수) -> 년, 월 별로 출력
# - 소수점 두 번째자리에서 반올림
# - 년을 기준으로 오름차순, 월을 기준으로 오름차순

# select year, month, count(*) as purchase_users, round(count(*) * 1.0 / total_users, 2) as purchase_ratio from (
#     select * from (
#         select YEAR(u.joined) as year, MONTH(u.joined) as month, count(*) as TOTAL_USERS from user_info as u
#         where YEAR(u.joined) = '2021'
#         group by YEAR(u.joined), MONTH(u.joined)
#     ) as my
#     join ONLINE_SALE as os on (my.year = YEAR(SALES_DATE) and my.month = MONTH(SALES_DATE))
#     group by user_id   
# ) as sub
# group by year, month
# order by year asc, month asc

select 
    YEAR(SALES_DATE) as year, 
    MONTH(SALES_DATE) as month, 
    count(distinct user_id) as purchase_users,
    round(count(distinct user_id) * 1.0 / (select count(*) from user_info as u
                        where YEAR(u.joined) = '2021'), 1) as purchase_ratio
from ONLINE_SALE as o
where user_id in (
    select user_id from user_info as u
    where YEAR(u.joined) = '2021'
)
group by YEAR(SALES_DATE), MONTH(SALES_DATE)
order by year asc, month asc