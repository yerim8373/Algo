# 📘 5014 스타트링크

## 소요시간, 메모리
208ms, 57868KB

## 풀이 방법
- 1697 숨바꼭질이랑 비슷한 문제
- 처음 탐색 시작할때 0으로 시작하면 같은 층 한번 더 탐색하게됨
- 그래서 초기값 1로 둠

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_5014_스타트링크 {
    static int F, S, G, U, D, result = -1;
    static int[] visit = new int[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 강호있는 곳
        G = Integer.parseInt(st.nextToken()); // 스타트링크있는 곳
        U = Integer.parseInt(st.nextToken()); // 위로 U층
        D = Integer.parseInt(st.nextToken()); // 아래로 D층
        bfs();
        System.out.println(result==-1 ? "use the stairs":result);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visit[S] = 1;

        if(S == G) {
            result = 0;
        }

        while(!queue.isEmpty()) {
            int q = queue.poll();

            if(q == G) {
                result = visit[q]-1;
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next;
                if(i==0) {
                    next = q+U;
                } else {
                    next = q-D;
                }

                if(next>0 && next<=F && visit[next]==0) {
                    queue.offer(next);
                    visit[next] = visit[q] + 1;
                }
            }
        }
    }

}


```