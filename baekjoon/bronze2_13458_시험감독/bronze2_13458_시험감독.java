package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bronze2_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); int C = Integer.parseInt(st.nextToken());
		long result = 0;
		
		for (int i = 0; i < A.length; i++) {
			int stu = A[i];
			stu -= B;
			result++;
			if(stu > 0) {
				result += stu / C;
				if(stu % C != 0) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
