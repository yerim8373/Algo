package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class gold5_7576_토마토 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int M, N;
	static int[][] map;
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1)
					queue.offer(new Point(r, c));
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < dc.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) {
					map[nr][nc] = map[p.r][p.c] + 1;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		
		int result = 0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 0) {
					return -1;
				} else {
					result = Math.max(result, map[r][c]);
				}
			}
		}
		
		return result==0?0:result-1;
		
	}

	static class Point{
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
