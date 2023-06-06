# 📘 11057 오르막수

## 소요시간, 메모리
120ms, 14280KB

## 풀이 방법
- dp

## Code

```java
package BAEKJOON;

import java.io.*;

public class silver1_11057_오르막수 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][10];

        // 0 일때
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 10 - i;
        }

        // 9일때 -> 1
        for (int i = 1; i < N; i++) {
            dp[i][9] = 1;
        }

        for(int i = 1; i < N; i++) {
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i-1][j] + dp[i][j+1]) % 10007;
            }
        }

        System.out.println(dp[N-1][0] % 10007);
    }

}
```