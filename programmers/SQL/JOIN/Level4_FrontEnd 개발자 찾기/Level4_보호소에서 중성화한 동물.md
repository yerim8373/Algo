## **FrontEnd 개발자 찾기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/276035)

🔑 풀이 답안 - MySQL

```SQL
SELECT DISTINCT d.id AS ID, d.email AS EMAIL, d.first_name AS FIRST_NAME, d.last_name AS LAST_NAME
FROM developers d JOIN skillcodes s
                       ON SUBSTRING(BIN(s.code), 1, 1) LIKE SUBSTRING(BIN(d.skill_code), -LENGTH(BIN(s.code)), 1)
                           AND s.category LIKE 'Front End'
ORDER BY d.id;
```

🔑 다른 풀이 코드 - MySQL
```SQL
SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM
  SKILLCODES JOIN DEVELOPERS
    ON CODE & SKILL_CODE
WHERE CATEGORY = 'Front End'
ORDER BY ID;
```

------

#### 💡 & 연산자

- 이진수