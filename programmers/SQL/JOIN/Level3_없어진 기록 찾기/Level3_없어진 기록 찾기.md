## **없어진 기록 찾기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59042)

🔑 풀이 답안 - MySQL

```SQL
SELECT o.animal_id, o.name
FROM animal_ins i RIGHT JOIN animal_outs o
                             ON i.animal_id = o.animal_id
WHERE i.animal_id is null;
```

------

#### 💡 RIGHT OUTER JOIN ON

- **테이블명 a RIGHT (OUTER) JOIN 테이블명 b ON 조건**
- 조건 - animal_id가 같은거끼리 조인하는데 outs에 있는 것들 다 가져오기
- WHERE절 사용해서 ins의 animal_id가 null인 것만 가져오기

#### 💡 -- is null

- outs를 기준으로 조인해서 ins에 없는 것만 가져오면 됨