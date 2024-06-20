## **오프라인/온라인 판매 데이터 통합하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/131537)

🔑 풀이 답안 - Oracle

```SQL
SELECT *
FROM (SELECT TO_CHAR(sales_date, 'YYYY-MM-DD') AS sales_date, product_id, user_id, sales_amount
      FROM online_sale
      WHERE TO_CHAR(sales_date, 'YYYY-MM') = '2022-03'
      UNION ALL
      SELECT TO_CHAR(sales_date, 'YYYY-MM-DD') AS sales_date, product_id, NULL AS user_id, sales_amount
      FROM offline_sale
      WHERE TO_CHAR(sales_date, 'YYYY-MM') = '2022-03')
ORDER BY sales_date, product_id, user_id;
```

-----