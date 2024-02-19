# 📘 15989 1, 2, 3 더하기 4

## 소요시간, 메모리
152ms, 16268KB

## 풀이 방법
- dp
- 점화식 세워서 품
- dp[i][1] = dp[i-1][1]
  dp[i][2] = dp[i-2][1] + dp[i-2][2]
  dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]

## Code

```java
package BAEKJOON;

import java.io.*;

public class gold5_15989_123더하기4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[10001][4];

		dp[1][2] = dp[1][3] = dp[2][3] = 0;
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

		for(int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i-1][1]; // 오름차순 중 1로 끝나는 거
			dp[i][2] = dp[i-2][1] + dp[i-2][2]; // 2로 끝나는 거
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]; // 3
		}

		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");
		}

		System.out.println(sb);
	}

}
```