package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver1_16926_배열돌리기1 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cen = Math.min(N/2, M/2); // 몇번 돌건지
		for (int k = 0; k < R; k++) {
			for (int i = 0; i < cen; i++) {
				// i, i 부터 시작
				int temp = map[i][i];
				int dir = 0;
				int r = i;
				int c = i;
				while(true) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if(nr == i && nc == i) {
						break;
					}
					if(nr>=0+i && nr<N-i && nc>=0+i && nc<M-i) {
						map[r][c] = map[nr][nc];
						r = nr; c = nc;
					} else {
						dir++;
					}
				}
				map[r][c] = temp;
			}
		}
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
