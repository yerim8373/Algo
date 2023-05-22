# 📘 11053 가장 긴 증가하는 부분 수열

## 소요시간, 메모리
148ms, 14484KB

## 풀이 방법
- dp
- 앞에서부터 탐색하는데 앞에꺼보다 크면 dp 갱신
- 이 시리즈 다른 것도 풀어봐야겠다 ❕

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		int[] dp = new int[N];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dp.length; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if(map[j] < map[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}

}
```