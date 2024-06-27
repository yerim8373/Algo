# 📘 2167 2차원 배열의 합

## 소요시간, 메모리
384ms, 27928KB

## 풀이 방법
- 누적합으로 풀었음

## Code

```java
package baekjoon;

import java.io.*;
import java.util.*;

public class silver5_2167_2차원배열의합{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r-1][c] + arr[r][c-1] - arr[r-1][c-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = arr[x][y]  - arr[x][j-1] - arr[i-1][y] + arr[i-1][j-1];
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}
```