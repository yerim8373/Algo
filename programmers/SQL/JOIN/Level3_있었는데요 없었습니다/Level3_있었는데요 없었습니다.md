## **있었는데요 없었습니다**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59043)

🔑 풀이 답안 - MySQL

```SQL
SELECT ins.animal_id, ins.name
FROM animal_ins ins join animal_outs outs
                         ON ins.animal_id = outs.animal_id AND ins.datetime > outs.datetime
ORDER BY ins.datetime ASC;
```

------

#### 💡 JOIN ON

- **테이블명 a JOIN 테이블명 b ON 조건**
- 조건 - animal_id가 같은거끼리 조인하는데 datetime이 ins가 더 늦은 걸 해야하니까 더 큰값 비교