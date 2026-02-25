-- 코드를 작성해주세요

# - front end 스킬 가진 개발자 조회
# - ID 기준으로 asc

select distinct id, email, first_name, last_name from developers as d
join skillcodes as s on (d.skill_code & s.code) = s.code
where s.category = 'Front End'
order by id asc
