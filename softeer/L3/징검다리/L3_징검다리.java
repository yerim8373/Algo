package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L3_징검다리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] stone = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				// 다음 돌이 현재 돌보다 높이가 높으면
				if(stone[i] > stone[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}
