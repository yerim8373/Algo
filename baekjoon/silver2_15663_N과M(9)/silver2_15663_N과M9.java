package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_15663_N과M9 {
	static int N, M;
	static int[] arr;
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		boolean[] visit = new boolean[N];
		dfs(0, "", visit);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void dfs(int idx, String res, boolean[] visit) {
		if(idx == M) {
			res = res.substring(0, res.length()-1);
			if(check(res)) {
				list.add(res);
			}
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(idx+1, res + arr[i] + " ", visit);
				visit[i] = false;
			}
		}
	}

	private static boolean check(String res) {
		
		for (int i = 0; i < list.size(); i++) {
			if(res.equals(list.get(i))) {
				return false;
			}
		}
		return true;
	}
}
