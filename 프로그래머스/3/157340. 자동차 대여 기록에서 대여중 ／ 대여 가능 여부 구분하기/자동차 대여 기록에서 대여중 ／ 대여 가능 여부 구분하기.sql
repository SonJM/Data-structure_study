-- 코드를 입력하세요
SELECT CAR_ID,
IF(
    COUNT(CASE WHEN START_DATE <= '2022-10-16' 
          AND 
          END_DATE >= '2022-10-16' 
          THEN 1 ELSE NULL END) > 0, '대여중','대여 가능'
) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

    # IF(
    #     COUNT(START_DATE < '2022-10-16' AND END_DATE >= '2022-10-16') > 0,
    #     '대여중',
    #     '대여 가능'
    # ) AS AVAILABILITY