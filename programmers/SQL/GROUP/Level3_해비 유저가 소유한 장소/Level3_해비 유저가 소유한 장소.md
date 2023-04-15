## **해비 유저가 소유한 장소**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/77487)

🔑 풀이 답안 - MySQL

```SQL
SELECT ID, NAME, HOST_ID
FROM places
WHERE host_id in
      (SELECT host_id
       FROM places
       GROUP BY host_id
       HAVING count(host_id) > 1)
ORDER BY ID;
```

------

#### 💡 HAVING

- GROUP BY한 결과에 조건을 줄 때 WHERE 처럼 사용