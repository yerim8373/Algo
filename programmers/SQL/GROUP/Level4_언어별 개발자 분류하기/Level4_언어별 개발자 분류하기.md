## **언어별 개발자 분류하기기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/276036)

🔑 풀이 답안 - MySQL

- 수정하다가 못하고 다른 사람 코드보고 이해하고 풀었음
- 비트연산자에 많이 약한듯
- skillcodes에 있는 code들은 각각 '100', '100000' 이런식이라 code 끼리 더하면 '100100010000' 이런식으로 나옴
- 그래서 SUM(code)로 프론트엔드를 비교해줌

```SQL
WITH front AS (
    SELECT SUM(code) CODE
    FROM skillcodes
    WHERE category LIKE 'Front End'
)

SELECT CASE
           WHEN skill_code & (SELECT * FROM front) AND skill_code & (SELECT code FROM skillcodes WHERE name LIKE 'Python')
            THEN 'A'
            WHEN skill_code & (SELECT code FROM skillcodes WHERE name LIKE 'C#')
            THEN 'B'
            WHEN skill_code & (SELECT * FROM front)
            THEN 'C'
END GRADE,
        ID,
        EMAIL
FROM developers
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID;

```

------
