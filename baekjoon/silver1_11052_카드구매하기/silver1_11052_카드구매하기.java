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
