## **그룹별 조건에 맞는 식당 목록 출력하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/131124)

🔑 풀이 답안 - MySQL

```SQL
SELECT m.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d') as REVIEW_DATE
FROM rest_review r JOIN member_profile m
                        ON r.member_id = m.member_id
WHERE r.member_id =
      (SELECT member_id
       FROM rest_review
       GROUP BY member_id
       ORDER BY count(review_id) DESC LIMIT 1)
ORDER BY r.review_date ASC, r.review_text ASC;
```

------

#### 💡 JOIN ON

- **테이블명 a JOIN 테이블명 b ON 조건**
- 조건 - member_id가 같은거끼리 조인

#### 💡 DATE_FORMAT()

- **DATE_FORMAT(컬럼명, '날짜 형식(ex : '%Y-%m-%d')')**
- 데이트 포맷 동일하게 맞춰줌

#### 💡 GROUP BY --

- member_id를 기준으로 묶어서 review_id를 카운트한 거 내림차순으로 정렬
- 정렬한거에서 맨위에꺼만 LIMIT 1로 빼기