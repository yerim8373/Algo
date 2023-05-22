# 📘 9465 스티커

## 소요시간, 메모리
764ms, 112108KB

## 풀이 방법
- 처음에 완탐으로 dfs 돌려서 풀었는데 메모리 초과 ...
- 찾아보니까 dp였음
- 0행 or 1행일 때, 전칸, 전전칸 중 더 큰값 더해서 메모리제이션

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver1_9465_스티커_dp {

	static int[][] map, memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[2][n];
			memo = new int[2][n];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if(n == 1) {
				sb.append(Math.max(map[0][0], map[1][0]) + "\n");
				continue;
			}

			memo[0][0] = map[0][0];
			memo[0][1] = map[0][1] + map[1][0];
			memo[1][0] = map[1][0];
			memo[1][1] = map[1][1] + map[0][0];

			for (int i = 2; i < n; i++) {
				memo[0][i] = Math.max(memo[1][i-1], memo[1][i-2]) + map[0][i];
				memo[1][i] = Math.max(memo[0][i-1], memo[0][i-2]) + map[1][i];
			}

			sb.append(Math.max(memo[0][n-1], memo[1][n-1]) + "\n");
		}
		System.out.println(sb);
	}

}
```