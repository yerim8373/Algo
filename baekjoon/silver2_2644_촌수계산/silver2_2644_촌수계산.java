package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_2644_촌수계산 {
	static int N, per1, per2, M, result = -1;
	static List<List<Integer>> graph;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		per1 = Integer.parseInt(st.nextToken());
		per2 = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 양방향 그래프
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		visit[per1] = true;
		dfs(per1, 0);
		
		System.out.println(result);
	}

	private static void dfs(int p, int cnt) {
		if(p == per2) {
			result = cnt;
			return;
		}
		
		for (int i : graph.get(p)) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, cnt+1);
			}
		}
	}

	

}
