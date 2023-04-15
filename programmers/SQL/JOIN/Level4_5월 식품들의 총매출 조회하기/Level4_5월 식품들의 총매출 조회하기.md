## **5월 식품들의 총매출 조회하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/131117)

🔑 풀이 답안 - MySQL

```SQL
SELECT p.product_id, p.product_name, o.total * p.price as TOTAL_SALES
FROM food_product p JOIN
     (SELECT product_id, sum(amount) as total
      FROM food_order
      WHERE produce_date LIKE '2022-05-%'
      GROUP BY product_id) o
     ON p.product_id = o.product_id
ORDER BY TOTAL_SALES DESC, p.product_id ASC;
```

------

#### 💡 JOIN ON

- **테이블명 a JOIN 테이블명 b ON 조건**
- 조건 - product_id가 같은거끼리 조인

#### 💡 LIKE '--%'

- 날짜 비교할 때 '2022-05-%'로 5월인 것만 추출해줌

#### 💡 YEAR(produce_date) = 2022 AND MONTH(produce_date) = 5 // DATE(--)

- 날짜 비교할때 년도, 월만 변환해서 비교해주는 방법도 있음!

#### 💡 GROUP BY --

- product_id 기준으로 SUM(amount) 구함