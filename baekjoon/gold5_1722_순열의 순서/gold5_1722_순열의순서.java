package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold5_1722_순열의순서 {
	static int N, k, cnt = 0;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		if(t == 1) {
			k = Integer.parseInt(st.nextToken());
			int[] res = new int[N];
			perm1(0, res);
		} else {
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] res = new int[N];
			perm2(0, res);
		}
	}

	private static void perm2(int idx, int[] res) {
		if(idx == res.length) {
			cnt++;
			for (int i = 0; i < res.length; i++) {
				if(res[i] != arr[i]) {
					return;
				}
			}
			System.out.println(cnt);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				res[idx] = i;
				visit[i] = true;
				perm2(idx+1, res);
				visit[i] = false;
			}
		}
	}

	private static void perm1(int idx, int[] res) {
		if(idx == res.length) {
			cnt++;
			if(cnt == k) {
				for (int i = 0; i < res.length; i++) {
					System.out.print(res[i] + " ");
				}
			}
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				res[idx] = i;
				visit[i] = true;
				perm1(idx+1, res);
				visit[i] = false;
			}
		}
	}
}