package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class silver1_1926_그림 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int n, m, count = 0, area = 0;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if(!visit[r][c] && map[r][c] == 1) {
					bfs(r, c);
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(area);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r, c});
		visit[r][c] = true;
		int areaTmp = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < dr.length; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc] && map[nr][nc] == 1) {
					visit[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
					areaTmp++;
				}
			}
		}
		
		area = Math.max(area, areaTmp);
	}

}
