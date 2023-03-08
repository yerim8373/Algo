package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver4_1459_걷기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		long time = 0;
		
		// 대각선 1번보다 직선 2번으로 이동한게 더 짧을 때
		if(W*2 < S) {
			time = (X+Y) * W;
		} else if(2*W > 2*S) { // 직선 2번보다 대각선으로 2번 이동한게 더 짧을 때
			if((X+Y)%2 != 0) { // 홀수라면
				time = (Math.max(X, Y)-1) * S + W;
			} else { // 짝수
				time = Math.max(X, Y) * S;
			}
		} else { // 대각선 1번이 직선 2번보단 짧고, 직선 2번이 대각선 2번보다 짧을 떼
			time = (Math.min(X, Y) * S) + (Math.abs(X - Y) * W);
		}
		
		
		System.out.println(time);
	}

}
