package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_2589_보물섬 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, result = 0;
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		// 대륙 나누기
		// 대륙에서 각 칸마다 최장거리 구하기 -> bfs 돌려서 최댓값
		// 그 중 큰거... -> 어차피 모든 정점에서 bfs 돌릴거라 대륙 안나눠도될듯
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 'L') {
					bfs(new Node(r, c, 0));
				}
			}
		}
		
		System.out.println(result);
	}

	private static void bfs(Node node) {
		v = new boolean[R][C];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		v[node.r][node.c] = true;
		int max = node.cnt;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			max = Math.max(max, cur.cnt);
			
			for (int d = 0; d < dc.length; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<R && nc>=0 && nc<C && !v[nr][nc] && map[nr][nc] == 'L') {
					v[nr][nc] = true;
					queue.offer(new Node(nr, nc, cur.cnt+1));
				}
			}
		}
		
		result = Math.max(result, max);
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
