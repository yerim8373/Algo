# 📘 1520 내리막 길

## 소요시간, 메모리
396ms, 36348KB

## 풀이 방법
- dfs, dp
- 처음에 dfs 했다가 시간초과
- 메모이제이션으로 방문했던 곳(-1)은 탐색하지 않음

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold3_1520_내리막길 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    static int[][] map, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int r, int c) {
        if(r == M-1 && c == N-1){
            return 1;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;
        for (int d = 0; d < dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]){
                dp[r][c] += dfs(nr, nc);
            }
        }

        return dp[r][c];
    }
}
```
