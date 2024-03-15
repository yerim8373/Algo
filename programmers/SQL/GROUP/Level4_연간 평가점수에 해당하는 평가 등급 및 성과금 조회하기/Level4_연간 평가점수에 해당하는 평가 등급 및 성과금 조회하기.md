## **연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기.md**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/284528)

🔑 풀이 답안 - MySQL

```SQL
WITH sub AS(
    SELECT emp_no, AVG(SCORE) average
    FROM hr_grade
    GROUP BY emp_no
)

SELECT e.emp_no EMP_NO, e.emp_name EMP_NAME,
       CASE
           WHEN g.average >= 96
               THEN 'S'
           WHEN g.average >= 90
               THEN 'A'
           WHEN g.average >= 80
               THEN 'B'
           ELSE 'C'
           END GRADE,
       CASE
           WHEN g.average >= 96
               THEN e.sal * 0.2
           WHEN g.average >= 90
               THEN e.sal * 0.15
           WHEN g.average >= 80
               THEN e.sal * 0.1
           ELSE 0
           END BONUS
FROM hr_employees e JOIN sub g
                         ON e.emp_no = g.emp_no
ORDER BY e.emp_no;

```

------

#### 💡 CASE WHEN THEN ⭐

```SQL
CASE
	WHEN 조건
	THEN '반환 값'
	WHEN 조건
	THEN '반환 값'
	ELSE 'WHEN 조건에 해당 안되는 경우 반환 값'
END
```