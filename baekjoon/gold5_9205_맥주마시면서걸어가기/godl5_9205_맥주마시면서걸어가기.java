package BAEKJOON;

import java.io.*;
import java.util.*;

public class godl5_9205_맥주마시면서걸어가기 {
	static int N, result = 0;
	static List<Node> cu;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			// 집, 편의점, 페스티벌 저장 -> 집 : 0, 페스티벌 : N+1
			cu = new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				cu.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			graph = new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				graph.add(new ArrayList<>());
			}
			// 그래프 연결 -> 양방향으로 저장해주기!!!
			for(int i = 0; i < N+2; i++) {
				for (int j = i+1; j < N+2; j++) {
					if(isAvailable(i, j)) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			sb.append(bfs() ? "happy" : "sad").append("\n");
		}
		System.out.println(sb);
	}

	private static boolean bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		boolean[] visit = new boolean[N+2];
		visit[0] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			if(q == N+1) {
				return true;
			}
			
			for (int i : graph.get(q)) {
				if(!visit[i]) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return false;
	}

	private static boolean isAvailable(int i, int j) {
		if((Math.abs(cu.get(i).r - cu.get(j).r) + Math.abs(cu.get(i).c - cu.get(j).c)) <= 1000) {
			return true;
		}
		return false;
	}

	static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
