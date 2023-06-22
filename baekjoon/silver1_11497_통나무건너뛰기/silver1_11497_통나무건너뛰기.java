package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver1_11497_통나무건너뛰기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int result = 0;
			
			// 2 4 5 7 9
			// 7 4 2 5 9
			for (int i = 2; i < N; i++) {
				result = Math.max(result, arr[i] - arr[i-2]);
			}
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}
