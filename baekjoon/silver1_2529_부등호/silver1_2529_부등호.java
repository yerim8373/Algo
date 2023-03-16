package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_2529_부등호 {
	static List<String> list = new ArrayList<>();
	static int k;
	static long max = 0, min = Long.MAX_VALUE;
	static String res_max, res_min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[10];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			list.add(st.nextToken());
		}
		
		for (int i = 0; i < 10; i++) {
			String t = Integer.toString(i);
			visit[i] = true;
			dfs(t, visit);
			visit[i] = false;
		}

		System.out.println(res_max + "\n" + res_min);
	}

	private static void dfs(String str, boolean[] visit) {
		int cur = str.length();
		if(cur == k+1) {
			long s = Long.parseLong(str);
			if(max < s) {
				max = s;
				res_max = str;
			}
			if(min > s) {
				min = s;
				res_min = str;
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!visit[i]) {
				if(list.get(cur-1).equals(">")) {
					if(str.charAt(cur-1) - '0' > i) {
						visit[i] = true;
						dfs(str + Integer.toString(i), visit);
						visit[i] = false;
					}
				} 
				if(list.get(cur-1).equals("<")){
					if(str.charAt(cur-1) - '0' < i) {
						visit[i] = true;
						dfs(str + Integer.toString(i), visit);
						visit[i] = false;
					}
				}
			}
		}
	}

}
