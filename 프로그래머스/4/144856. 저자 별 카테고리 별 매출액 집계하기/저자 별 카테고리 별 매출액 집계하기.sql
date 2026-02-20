select a.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM((SALES * PRICE)) from BOOK_SALES as bs
join BOOK as b on b.BOOK_ID = bs.BOOK_ID
join AUTHOR as a on a.AUTHOR_ID = b.AUTHOR_ID
where YEAR(bs.SALES_DATE) = 2022 AND MONTH(bs.SALES_DATE) = 1
group by category, AUTHOR_ID
order by a.AUTHOR_ID, CATEGORY DESC