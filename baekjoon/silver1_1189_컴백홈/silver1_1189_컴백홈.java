package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver1_1189_컴백홈 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, K, result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				if(str.charAt(c) == 'T') {
					map[r][c] = 1;
				}
			}
		}
		
		map[R-1][0] = 1;
		dfs(R-1, 0, 1, map);
		
		System.out.println(result);
	}

	private static void dfs(int r, int c, int cnt, int[][] map) {
		if(cnt == K) {
			if(r == 0 && c == C-1) {
				result++;
			}
			return;
		}
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] == 0) {
				map[nr][nc] = 1;
				dfs(nr, nc, cnt+1, map);
				map[nr][nc] = 0;
			}
		}
	}

}
