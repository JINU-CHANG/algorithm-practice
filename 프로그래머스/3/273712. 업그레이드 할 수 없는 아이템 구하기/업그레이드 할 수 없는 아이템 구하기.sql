-- 코드를 작성해주세요

select t1.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO as t1
join 
(
    select ITEM_ID from ITEM_TREE
    where ITEM_ID not in 
    (
        select PARENT_ITEM_ID
        from ITEM_TREE
        WHERE PARENT_ITEM_ID IS NOT NULL
    )
) as t2 on t1.ITEM_ID = t2.ITEM_ID
order by ITEM_ID DESC;