## **보호소에서 중성화한 동물**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/59045)

🔑 풀이 답안 - MySQL

```SQL
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
FROM animal_ins a join animal_outs b
                       ON a.animal_id = b.animal_id
WHERE a.sex_upon_intake IN ('Intact Male', 'Intact Female')
  AND b.sex_upon_outcome IN ('Neutered Male', 'Spayed Female');
```

------

#### 💡 IN

- sex_upon_intake가 'Intact Male', 'Intact Female' 일 때, sex_upon_outcome이 'Neutered Male', 'Spayed Female'일 때

- 다른 사람 풀이보니까 들어왔을 때랑 나갈 때가 다르면 중성화 한거니까
```SQL
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
FROM animal_ins a join animal_outs b
                       ON a.animal_id = b.animal_id
WHERE a.sex_upon_intake != b.sex_upon_outcome;
```