## **동물 수 구하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59406)

🔑 풀이 답안 - MySQL

```SQL
SELECT COUNT(animal_id) AS "count"
FROM animal_ins;
```

------

#### 💡 COUNT()

- COUNT() 로 모든 동물의 수 구함
- name은 null 값 있을수도 있어서 id로 구함