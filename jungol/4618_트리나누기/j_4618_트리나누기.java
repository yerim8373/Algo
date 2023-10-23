package JUNGOL;

import java.io.*;
import java.util.*;

public class j_4618_트리나누기 {
	static int N;
	static boolean[] visit, v;
	static int[] remove, result;
	static Node[] adj;
	static boolean[][] map;
	static boolean check = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		adj = new Node[N-1];
		remove = new int[N/3-1];
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[i] = new Node(a, b);
			map[a][b] = map[b][a] = true;
		}
		

		// n/3-1 조합 만들어서 되는지 탐색
		visit = new boolean[N-1];
		combi(0);
	}
	
	private static void combi(int cnt) {
		if(check) {
			return;
		}
		
		if(cnt == N/3-1) {
			// 탐색
			v = new boolean[N];
			for(int i = 0; i < remove.length; i++) {
				Node cur = adj[remove[i]];
				map[cur.a][cur.b] = map[cur.b][cur.a] = false;
			}
			
			for (int i = 0; i < N; i++) {
				if(!v[i]) {
					if(!bfs(i)) {
						break;
					}
				}
				if(i == N-1) check = true;
			}
			
			if(check) {
				for (int r : remove) {
					System.out.print(r + " ");
				}
				return;
			} else {
				for(int i = 0; i < remove.length; i++) {
					Node cur = adj[remove[i]];
					map[cur.a][cur.b] = map[cur.b][cur.a] = true;
				}
			}
			
			return;
		}
		
		for(int i = 0; i < N-1; i++) {
			if(!visit[i]) {
				visit[i] = true;
				remove[cnt] = i;
				combi(cnt+1);
				visit[i] = false;
			}
		}
	}

	private static boolean bfs(int a) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(a);
		v[a] = true;
		int c = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 0; i < map[cur].length; i++) {
				if(!v[i] && map[cur][i]) {
					v[i] = true;
					queue.offer(i);
					c++;
				}
			}
		}
		
		if(c == 3) return true;
		else return false;
	}

	static class Node{
		int a, b;
		
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
