# 📘 16988 Baaaaaaaaaduk2 (Easy)

## 소요시간, 메모리
796ms, 301524KB

## 풀이 방법
- dfs로 검은돌 2개를 먼저 놓는다
- 검은돌 2개를 놓았으면 bfs로 흰색돌이 연결되어있고, 주변에 빈칸이 없을 때 더해준 값의 총합 중 최댓값 

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int result = 0, N, M;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int r = 0; r < map.length; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);

        System.out.println(result);
    }

    private static void dfs(int cnt, int[][] map) {
        if(cnt == 2) {
            check(map);
            return;
        }

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if(map[r][c] == 0) {
                    map[r][c] = 1;
                    dfs(cnt+1, map);
                    map[r][c] = 0;
                }
            }
        }
    }

    private static void check(int[][] map) {
        visit = new boolean[N][M];
        int count = 0;

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if(!visit[r][c] && map[r][c] == 2) {
                    count += bfs(new Node(r, c), map);
                }
            }
        }

        result = Math.max(result, count);
    }

    private static int bfs(Node node, int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visit[node.r][node.c] = true;
        int cnt = 1; boolean chk = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M) {
                    // 빈칸이면 탈락 -> 연결되어있는거 다 체크하려고 계속 진행
                    if(map[nr][nc] == 0) {
                        chk = false;
                    }
                    // 상대 돌이면 큐에 넣기
                    if(!visit[nr][nc] && map[nr][nc] == 2) {
                        visit[nr][nc] = true;
                        queue.offer(new Node(nr, nc));
                        cnt++;
                    }
                }
            }
        }
        return chk ? cnt : 0;
    }

    static class Node{
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

```
