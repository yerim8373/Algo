package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L3_성적평균 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 구간 합 문제
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		sum[0] = 0;
		for(int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i-1];
		}
		sum[N] = sum[N-1] + arr[N-1];
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			sb.append(Math.round(((sum[b] - sum[a-1]) / (b - a + 1.0)) * 100) / 100.00).append("\n");
			sb.append(String.format("%.2f", ((sum[b] - sum[a-1]) / (b - a + 1.0)))).append("\n");
		}
		
		System.out.println(sb);
	}

}
