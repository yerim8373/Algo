# 📘 1405 미친 로봇

## 소요시간, 메모리
180ms, 15016KB

## 풀이 방법
- 갈 수 있는 모든 방향을 탐색하면서 확률 계산
- 행동은 최대 14번이니까 맵을 30, 30으로 해서 15, 15부터 시작
- 방향으로 갈 때마다 그 방향 확률 계속 곱해주면서 모든 확률을 더해줌

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold4_1405_미친로봇 {

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static double[] per_dir = new double[4];
    static boolean[][] visit = new boolean[30][30];
    static int N;
    static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            per_dir[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visit[15][15] = true;
        dfs(15, 15, 0, 1);
        System.out.println(result);
    }

    private static void dfs(int r, int c, int k, double total) {
        if(k == N) {
            result += total;
            return;
        }

        for (int i = 0; i < per_dir.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!visit[nr][nc]) {
                visit[nr][nc] = true;
                dfs(nr, nc, k+1, total*per_dir[i]);
                visit[nr][nc] = false;
            }
        }
    }

}
```