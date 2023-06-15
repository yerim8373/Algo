package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class silver1_2302_극장좌석 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int start = 1;
        long result = 1;
        for (int i = 0; i < M; i++) {
            result *= dp[arr[i]-start];
            start = arr[i]+1;
        }

        result *= dp[N-start+1];

        System.out.println(result);
    }
}
