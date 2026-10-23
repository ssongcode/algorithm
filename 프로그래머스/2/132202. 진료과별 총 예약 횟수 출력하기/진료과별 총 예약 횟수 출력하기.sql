--  2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문

SELECT MCDP_CD AS "진료과코드",
        COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE 1=1
    AND APNT_YMD >= DATE '2022-05-01'
    AND APNT_YMD < DATE '2022-06-01'
GROUP BY MCDP_CD
ORDER BY "5월예약건수" ASC, "진료과코드" ASC
;