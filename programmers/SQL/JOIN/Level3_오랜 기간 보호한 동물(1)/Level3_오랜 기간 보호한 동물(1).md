## **오랜 기간 보호한 동물(1)**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59044)

🔑 풀이 답안 - MySQL

```SQL
SELECT a.NAME, a.DATETIME
FROM animal_ins a left join animal_outs b
                            ON a.animal_id = b.animal_id
WHERE b.animal_id IS NULL
ORDER BY a.datetime
    LIMIT 3;
```

------

#### 💡 LEFT OUTER JOIN ON

- **테이블명 a LEFT (OUTER) JOIN 테이블명 b ON 조건**
- 조건 - animal_id가 같은거끼리 조인하는데 b 테이블이 null인 것 기준으로 left join

#### 💡 LIMIT 3

- 상위 3개의 컬럼만 추출