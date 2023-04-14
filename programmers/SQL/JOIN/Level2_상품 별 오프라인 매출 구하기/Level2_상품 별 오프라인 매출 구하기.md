## **상품 별 오프라인 매출 구하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/131533)

🔑 풀이 답안 - MySQL

```SQL
SELECT p.PRODUCT_CODE, SUM(p.PRICE * o.SALES_AMOUNT) AS SALES
FROM PRODUCT p JOIN OFFLINE_SALE o
                    ON p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY p.PRODUCT_ID
ORDER BY SALES DESC, p.PRODUCT_CODE ASC;
```

------

#### 💡 JOIN ON

- **테이블명 a JOIN 테이블명 b ON 조건**
- 조건 - product_id가 같은거끼리 조인

#### 💡 ORDER BY -- ASC, -- DESC

- 두개 이상 정렬해주고 싶으면 그냥 -- DESC, -- ASC