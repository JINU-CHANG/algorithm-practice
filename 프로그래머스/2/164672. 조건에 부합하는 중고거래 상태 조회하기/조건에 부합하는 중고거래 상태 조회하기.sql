-- 코드를 입력하세요

# - 거래 상태 출력
# - 게시글 ID 순으로 내림차순

select BOARD_ID, WRITER_ID, TITLE, PRICE, 
case 
    when status = 'SALE' then '판매중' 
    when status = 'RESERVED' then '예약중'
    when status = 'DONE' then '거래완료'
end as status
from USED_GOODS_BOARD
where CREATED_DATE = '2022-10-05'
order by board_id desc;
