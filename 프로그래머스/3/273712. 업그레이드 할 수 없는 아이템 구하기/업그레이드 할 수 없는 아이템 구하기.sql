-- 코드를 작성해주세요

select ITEM_ID, ITEM_NAME, RARITY from ITEM_INFO as i
where not exists (
    select * from item_tree as t where t.parent_item_id = i.item_id
)
order by item_id desc