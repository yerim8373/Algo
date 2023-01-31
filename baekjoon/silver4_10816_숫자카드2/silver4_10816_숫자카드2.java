import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] sang;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		sang = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sang[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sang);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int vs = Integer.parseInt(st.nextToken());
			int cnt = end(vs) - start(vs);
			sb.append(cnt).append(" ");
		}
		System.out.println(sb);

	}

	private static int start(int vs) {
		int left = 0;
		int right = N;

		while(left<right) {
			int mid = (right + left) / 2;
			if(vs <= sang[mid]) {
				right = mid;
			} else {
				left = mid+1;
			}
		}

		return left;
	}

	private static int end(int vs) {
		int left = 0;
		int right = N;

		while(left<right) {
			int mid = (right + left) / 2;
			if(vs < sang[mid]) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}
}