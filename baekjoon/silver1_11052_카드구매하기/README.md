# 📘 11052 카드 구매하기

## 소요시간, 메모리
144ms, 14564KB

## 풀이 방법
- dp
- 우선 기본값으로 다 채운 후
- 앞에서부터 비교하면서 최댓값 채워나가기
- dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
- ([1] + [6-1]), ([2] + [6-2]), ([3] + [6-3])

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_11052_카드구매하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];

		for(int i = 1; i < N+1; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}

		//		int[] dp = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j <= i/2; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
				//				System.out.println(dp[i]);
			}
		}

		System.out.println(dp[N]);
	}

}
```