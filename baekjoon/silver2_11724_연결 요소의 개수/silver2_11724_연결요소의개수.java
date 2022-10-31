package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver2_11724_연결요소의개수 {
	
	static boolean[][] graph;
	static boolean[] visit;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		int u, v, count = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			// 방문한적 없으면 갯수세기
			if(!visit[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	private static void dfs(int i) {
		if(visit[i])
			return;
		
		// 방문처리
		visit[i] = true;
		// 연결된 그래프 탐색
		for (int j = 1; j <= N; j++) {
			if(graph[i][j]) {
				dfs(j);
			}
		}
	}

}
