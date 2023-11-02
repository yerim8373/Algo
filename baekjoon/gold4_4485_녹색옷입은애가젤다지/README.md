# 📘 3190 뱀

## 소요시간, 메모리
264ms, 21024KB

## 풀이 방법
- bfs, PriorityQueue
- tmp에 최댓값 넣어두고 bfs 돌리면서 '현재칸+옮길칸'이랑 'tmp에 저장된 값' 비교해서 앞에꺼가 더 작으면 tmp바꿔주고 pq에 추가
- pq에서 꺼냈는데 끝에 칸이면 끝내기

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class gold4_4485_녹색옷입은애가젤다지 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, Rupee;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int t = 1;
        while(N != 0) {
            sb.append("Problem " + t + ": ");
            map = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(0, 0);
            t++;
            N = Integer.parseInt(br.readLine());
        }

        System.out.print(sb);
    }

    private static void bfs(int r, int c) {
        PriorityQueue<Link> pq = new PriorityQueue<>();
        pq.offer(new Link(r, c, map[r][c]));
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(tmp[i], Integer.MAX_VALUE);
        }
        tmp[r][c] = map[r][c];

        while(!pq.isEmpty()) {
            Link cur = pq.poll();

            if(cur.r == N-1 && cur.c == N-1) {
                sb.append(cur.cost + "\n");
                return;
            }

            for (int d = 0; d < dc.length; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if(tmp[nr][nc] > cur.cost + map[nr][nc]) {
                        tmp[nr][nc] = cur.cost + map[nr][nc];
                        pq.offer(new Link(nr, nc, tmp[nr][nc]));
                    }
                }
            }
        }
    }

    static class Link implements Comparable<Link>{
        int r, c, cost;

        public Link(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        public int compareTo(Link o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
```