## **상품을 구매한 회원 비율 구하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/131534)

🔑 풀이 답안 - MySQL

```SQL
SELECT YEAR(o.sales_date) AS YEAR, MONTH(o.sales_date) AS MONTH, COUNT(DISTINCT u.user_id) AS PUCHASED_USERS,
    ROUND(COUNT(DISTINCT u.user_id) / (SELECT COUNT(*) FROM user_info WHERE YEAR(joined) = 2021), 1) AS PUCHASED_RATIO
FROM user_info u JOIN online_sale o
ON u.user_id = o.user_id
    AND YEAR(u.joined) = 2021
GROUP BY MONTH(o.sales_date)
ORDER BY YEAR, MONTH;
```

------
