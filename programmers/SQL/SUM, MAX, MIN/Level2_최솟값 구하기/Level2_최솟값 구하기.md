## **최솟값 구하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59038)

🔑 풀이 답안 - MySQL

```SQL
SELECT MIN(datetime) AS "시간"
FROM animal_ins;
```

------

#### 💡 MIN()

- MIN() 로 가장 먼저 들어온 날짜 구함