## **NULL 처리하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59410)

🔑 풀이 답안 - Oracle

```SQL
SELECT animal_type, NVL(name, 'No name') AS name, sex_upon_intake
FROM animal_ins
ORDER BY animal_id;
```

------

#### 💡 NVL()

- **NVL(a, '문자')**
- a 필드가 NULL일 경우 '문자' 출력