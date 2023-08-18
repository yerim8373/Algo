# 📘 1261 알고스팟

## 소요시간, 메모리
144ms, 14704KB

## 풀이 방법
- BFS, PriortyQueue
- 0,0 부터 bfs 탐색하는데 PriorityQueue로 벽을 부순 갯수가 적은 위치부터 탐색
- 탐색하다가 N-1,M-1 이 나오면 현재 벽 부순 개수를 리턴
- 입력받을 때 '1'로 비교해야하는데 그냥 1을 비교함 ... 정신차렷 🫨

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class gold4_1261_알고스팟 {
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int N, M;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                if(str.charAt(c) == '1'){
                    map[r][c] = true;
                }
            }
        }

        System.out.println(bfs(new Node(0, 0, 0)));
    }

    private static int bfs(Node node) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][M];
        pq.offer(node);
        visit[node.r][node.c] = true;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.r == N-1 && cur.c == M-1){
                return cur.wall;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc]){
                    visit[nr][nc] = true;
                    // 벽일 경우
                    if(map[nr][nc]){
                        pq.offer(new Node(nr, nc, cur.wall+1));
                    } else {
                        pq.offer(new Node(nr, nc, cur.wall));
                    }
                }
            }
        }

        return 0;
    }

    static class Node implements Comparable<Node> {
        int r, c, wall;
        public Node(int r, int c, int wall){
            this.r = r;
            this.c = c;
            this.wall = wall;
        }

        public int compareTo(Node o){
            return Integer.compare(this.wall, o.wall);
        }
    }
}
```