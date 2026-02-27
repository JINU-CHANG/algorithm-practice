-- 코드를 작성해주세요

# 아이템 업그레이드
# root 아이템을 찾아 출력 / 아이템 ID 기준 오름차순 정렬

select i.ITEM_ID, ITEM_NAME from ITEM_INFO as i
join ITEM_TREE as t on i.ITEM_ID = t.ITEM_ID
where parent_item_id is null
order by i.ITEM_ID asc