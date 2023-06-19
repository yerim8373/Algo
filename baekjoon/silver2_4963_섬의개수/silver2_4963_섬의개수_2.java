package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_4963_섬의개수_2 {
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] map;
	static int w, h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			int result = 0;
			
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if(map[r][c] == 1) {
						bfs(r, c);
						result++;
					}
				}
			}
			
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		map[r][c] = 2; // 방문한거 2로 변경
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < dr.length; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1) {
					queue.offer(new int[] {nr, nc});
					map[nr][nc] = 2;
				}
			}
		}
	}

}
