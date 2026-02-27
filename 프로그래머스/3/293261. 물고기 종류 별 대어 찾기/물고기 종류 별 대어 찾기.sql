-- 코드를 작성해주세요

# 종류별로 가장 큰 물고기 출력
# 물고기 ID에 대해 오름차순 정렬

select id, fish_name, length from FISH_NAME_INFO as i
join (
    select id, fish_type, length from fish_info
    where (fish_type, length) in (
        select fish_type, max(length) as length from fish_info
        group by fish_type
    )
) as m on m.fish_type = i.fish_type
order by id asc
