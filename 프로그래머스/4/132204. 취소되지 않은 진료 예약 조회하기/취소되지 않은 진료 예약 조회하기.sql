-- 코드를 입력하세요

# - 2022-04-13 취소되지 않은 흉부외과 진료 예약 내역 조회
# 진료예약일시 기준 오름차순

select 
a.APNT_NO, p.PT_NAME, 
p.PT_NO, a.MCDP_CD,
d.DR_NAME, a.APNT_YMD
from APPOINTMENT as a
join doctor as d on a.MDDR_ID = d.DR_ID
join PATIENT as p on p.PT_NO = a.PT_NO
where DATE(APNT_YMD) = '2022-04-13' and APNT_CNCL_YN = 'N' and a.MCDP_CD = 'CS'
order by APNT_YMD asc