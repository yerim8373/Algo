# 📘 2573 빙산

## 소요시간, 메모리
672ms, 194412KB

## 풀이 방법
- 구현, bfs
- bfs로 빙산의 갯수 구해서 갯수가 2개 이상일 때까지 반복
- 맵 복사해서 빙산 녹이기
- 처음에 빙산이 다 녹을 때까지 분리되지 않는 경우 0 출력하는 부분을 처리 안해줘서 시간초과 -> 맵 복사할 때 빙산 개수세서 0일 경우 0 리턴해줌

## Code

```java
package Baekjoon;

import java.io.*;
import java.util.*;

public class gold4_2573_빙산 {
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int N, M, result = 0;
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while(check_land()){
            result++;

            if(!melting()) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean melting() {
        int[][] tmp = new int[N][M];
        int ice = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                tmp[r][c] = map[r][c];
                if(map[r][c] > 0){
                    ice++;
                }
            }
        }
        if(ice == 0) {
            result = 0;
            return false;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(tmp[r][c] > 0){
                    int cnt = 0;
                    for (int d = 0; d < dr.length; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < M && tmp[nr][nc] == 0){
                            cnt++;
                        }
                    }
                    map[r][c] = map[r][c] - cnt < 0 ? 0 : map[r][c] - cnt;
                }
            }
        }
        return true;
    }

    private static boolean check_land() {
        visit = new boolean[N][M];
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(!visit[r][c] && map[r][c] > 0){
                    bfs(r, c);
                    cnt++;
                }
            }
        }
        if(cnt > 1){
            return false;
        }
        return true;
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        visit[r][c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0 && !visit[nr][nc]){
                    visit[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
```