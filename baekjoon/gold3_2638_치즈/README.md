# 📘 2638 치즈

## 소요시간, 메모리
308ms, 42812KB

## 풀이 방법
- 구현
- 내부에 있는 공기는 안녹음 -> 외부 공기는 하나로 다 이어져 있으므로 bfs 돌면서 2로 바꿔줌
- 그리고 맵 돌면서 치즈면 맞닿은 면 갯수 확인하고 큐에 넣고 녹이기
- 치즈 사라질때까지 계속 반복해줌
- 외부공기 2로 해놧으니까 외부공기 나눠줄때 map[nr][nc] == 0 으로하믄 안됨❗

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
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

        while(check()) {
            // 외부공기 나눠주기
            divideAir();
            // 치즈 녹이기
            melting();
            result++;
        }

        System.out.println(result);
    }

    private static boolean check() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(map[r][c] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void divideAir() {
        Queue<int[]> queue = new LinkedList<>();
        visit = new boolean[N][M];
        queue.offer(new int[] {0, 0});
        map[0][0] = 2;
        visit[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && map[nr][nc] != 1) {
                    map[nr][nc] = 2;
                    visit[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }

    private static void melting() {
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(map[r][c] == 1) {
                    int cnt = 0;
                    // 맞닿은 면 갯수 확인
                    for (int d = 0; d < dc.length; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 2) {
                            cnt++;
                        }
                    }

                    if(cnt >= 2) {
                        queue.offer(new int[] {r, c});
                    }
                }
            }
        }

        for (int[] q : queue) {
            map[q[0]][q[1]] = 2;
        }
    }
}
```
