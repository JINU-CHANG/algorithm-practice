-- 코드를 작성해주세요

# ID와 자식수 출력, 없다면 자식 수는 0으로 출력
# 개체 ID 오름차순

select id, coalesce(count, 0) as child_count from ecoli_data as e
left join (
    select parent_id, count(*) as count from ecoli_data 
    group by parent_id
) as c on c.parent_id = e.id
order by id asc;