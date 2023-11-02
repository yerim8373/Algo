package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold4_11559_PuyoPuyo {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] map = new char[12][6];
	static boolean[][] visit;
	static int result = 0;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		while(true) {
			// 이어진거 확인
			check = false;
			checkPuyo();
			if(!check) break;
			
			// 내리기
			downPuyo();
			print();
			result++;
		}
		
		System.out.println(result);
	}

	private static void downPuyo() {
		for (int c = 0; c < 6; c++) {
			for (int r = 11; r >= 0; r--) {
				if(map[r][c] != '.') {
					for (int i = 11; i > r; i--) {
						if(map[i][c] == '.') {
							map[i][c] = map[r][c];
							map[r][c] = '.';
							break;
						}
					}
				}
			}
		}
	}

	private static void checkPuyo() {
		// 맵 탐색하면서 4개인거 체크 
		visit = new boolean[12][6];
		
		for (int r = 0; r < 12; r++) {
			for (int c = 0; c < 6; c++) {
				if(map[r][c] != '.' && !visit[r][c]) {
					bfs(r, c);
				}
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		queue.offer(new int[] {r, c});
		list.add(new int[] {r, c});
		visit[r][c] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < dr.length; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && map[nr][nc] == map[r][c] && !visit[nr][nc]) {
					visit[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
					list.add(new int[] {nr, nc});
					cnt++;
				}
			}
		}
		
		if(cnt >= 4) {
			for (int[] l : list) {
				map[l[0]][l[1]] = '.';
			}
			check = true;
		}
	}

	private static void print() {
		for (int r = 0; r < 12; r++) {
			for (int c = 0; c < 6; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
}
