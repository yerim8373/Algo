package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver3_14501_퇴사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int result = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			if(i+T <= N) {
				dp[i+T] = Math.max(dp[i+T], dp[i] + P);
				result = Math.max(result, dp[i+T]);
			}

			// i+1을 i와 비교해서 최댓값을 넣어놓는다.
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(result);
	}
}
