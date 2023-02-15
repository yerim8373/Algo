package BAEKJOON;

import java.io.*;
import java.util.*;;

public class gold4_17144_미세먼지안녕 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, T;
	static int[][] map;
	static Queue<Node> before = new LinkedList<>();
	static Queue<Node> after = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			check();
			cal();
			save();
			fresh();
		}
	}

	private static void fresh() {
		
	}

	private static void save() {
		while(!after.isEmpty()) {
			Node cur = after.poll();
			map[cur.r][cur.c] += cur.cnt; 
		}
	}

	private static void cal() {
		while(!before.isEmpty()) {
			Node cur = before.poll();
			int num = 0;
			
			for (int d = 0; d < dr.length; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] != -1) {
					after.offer(new Node(nr, nc, (cur.cnt/5)));
					num++;
				}
			}
			
			after.offer(new Node(cur.r, cur.c, (cur.cnt - (cur.cnt/5*num))));
		}
	}

	private static void check() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] > 0) {
					before.offer(new Node(r, c, map[r][c]));
				}
			}
		}
	}

	static class Node{
		int r, c, cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
