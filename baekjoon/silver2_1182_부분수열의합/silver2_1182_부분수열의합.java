package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_1182_부분수열의합 {
	static int N, S, result = 0;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			visit[i] = true;
			perm(i, arr[i]);
			visit[i] = false;
		}
		
		System.out.println(result);
	}

	private static void perm(int i, int sum) {
		if(sum == S) {
			result++;
//			return;
		}
		
		for(int j = i+1; j < N; j++) {
			if(!visit[j]) {
				visit[j] = true;
				perm(j, sum+arr[j]);
				visit[j] = false;
			}
		}
	}

}
