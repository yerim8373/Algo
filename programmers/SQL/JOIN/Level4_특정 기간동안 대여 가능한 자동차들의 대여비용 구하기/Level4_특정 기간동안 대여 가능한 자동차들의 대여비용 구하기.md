## **특정 기간동안 대여 가능한 자동차들의 대여비용 구하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/157339)

🔑 풀이 답안 - MySQL

```SQL
-- 코드를 입력하세요
WITH sub AS (
    # SELECT DISTINCT a.car_id AS car_id, a.car_type AS car_type,
                      #     a.daily_fee AS daily_fee#, DATEDIFF(b.end_date, b.start_date) AS period
          # FROM car_rental_company_car a JOIN car_rental_company_rental_history b
          #     ON a.car_id = b.car_id
          #     AND (b.start_date  '2022-11-01'
          #     AND MONTH(b.end_date) > 11)
          # WHERE a.car_type IN ('세단', 'SUV')
SELECT *
FROM car_rental_company_car
WHERE car_type IN ('세단', 'SUV')
  AND car_id NOT IN (
    SELECT DISTINCT car_id
    FROM car_rental_company_rental_history
    WHERE start_date <= '2022-11-01'
      AND end_date >= '2022-11-30'
)
    ),

sub2 AS (
    SELECT car_type, SUBSTRING(discount_rate, 1, LENGTH(discount_rate)) discount_rate
    FROM car_rental_company_discount_plan
    WHERE SUBSTRING(duration_type, 1, 2) = 30
)

# SELECT car_type, SUBSTRING(discount_rate, 1, LENGTH(discount_rate)) discount_rate
          #     FROM car_rental_company_discount_plan
                         #     WHERE SUBSTRING(duration_type, 1, 2) = 30;

SELECT s.car_id AS CAR_ID, s.car_type AS CAR_TYPE,
       ((s.daily_fee - (s.daily_fee * 0.01 * c.discount_rate)) * 30) AS FEE
FROM sub s JOIN sub2 c
                ON s.car_type = c.car_type
HAVING FEE >= 500000
   AND FEE < 2000000
    # WHERE ((s.daily_fee - (s.daily_fee * 0.01 * c.discount_rate)) * 30) >= 500000
    # AND ((s.daily_fee - (s.daily_fee * 0.01 * c.discount_rate)) * 30) < 2000000
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC;

# SELECT *
             # FROM car_rental_company_discount_plan
                        # WHERE car_type = 'SUV';

# SELECT SUBSTRING(duration_type, 1, 2)
             # FROM car_rental_company_discount_plan
                        # WHERE SUBSTRING(duration_type, 1, 2) = 30;
```
