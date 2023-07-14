# 📘 15903 카드 합체 놀이

## 소요시간, 메모리
168ms, 15212KB

## 풀이 방법
- PriorityQueue
- pq로 정렬해준 후 작은거 두개빼서 더해서 다시 넣어주기
- Long 타입 주의 ❗ (PQ에 더해준 값 넣으니까 Long 타입)

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a+b);
            pq.offer(a+b);
        }
        long result = 0;
        for (Long i : pq) {
            result += i;
        }
        System.out.println(result);
    }
}
```