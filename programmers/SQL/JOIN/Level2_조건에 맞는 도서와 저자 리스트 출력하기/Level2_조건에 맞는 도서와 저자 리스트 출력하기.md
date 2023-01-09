## **조건에 맞는 도서와 저자 리스트 출력하기**

🔒 [문제 보기](https://school.programmers.co.kr/learn/courses/30/lessons/144854)

🔑 풀이 답안 - MySQL

```SQL
SELECT a.book_id, b.author_name, DATE_FORMAT(a.published_date, '%Y-%m-%d') AS published_date
FROM book a JOIN author b
                 ON a.author_id = b.author_id
WHERE a.category LIKE "경제"
ORDER BY a.published_date ASC;
```

------

#### 💡 JOIN ON

- **테이블명 a JOIN 테이블명 b ON 조건**
- 조건 - author_id가 같은거끼리 조인

#### 💡 DATE_FORMAT()

- **DATE_FORMAT(컬럼명, '날짜 형식(ex : '%Y-%m-%d')')**
- 데이트 포맷 동일하게 맞춰줌

#### 💡 ORDER BY -- ASC

- 출판일 기준으로 오름차순이니까 ASC