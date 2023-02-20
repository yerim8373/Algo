package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold2_19236_청소년상어 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map = new int[4][4]; // no 저장
	static Node[] fish = new Node[17]; // 물고기 r, c
	static int[] direction = new int[17]; // 물고기 dir
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 4; c++) {
				int no = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				map[r][c] = no;
				fish[no] = new Node(r, c);
				direction[no] = dir - 1;
			}
		}

		// 상어 0,0 먹기 -> 잡아먹힌 물고기 방향 -1
		direction[0] = direction[map[0][0]]; // 상어 방향 저장
		int k = map[0][0];
		direction[map[0][0]] = -1; // 잡아먹힌 물고기 방향 -1
		fish[0] = new Node(0, 0); // 상어 위치 저장
		// 상어있는 곳 0, 빈칸 -1
		map[0][0] = 0;

		play(0, 0, k, map, fish, direction);

		System.out.println(result);
	}

	private static void play(int r, int c, int cnt, int[][] map2, Node[] fish2, int[] direction2) {

		result = Math.max(result, cnt);

		// 물고기 이동
		move_fish(map2, fish2, direction2);

		int check = 0;
		// 상어 움직이기 -> 움직일 수 있으면 움직이는 방향 리턴
		//			-> 움직일 수 없으면 -1, -1 리턴
		// return 필요 -> 상어 움직일 수 없으면 return
		for (int i = 1; i < 4; i++) {
			int nr = r + dr[direction2[0]]*i;
			int nc = c + dc[direction2[0]]*i;
			if(nr>=0 && nr<4 && nc>=0 && nc<4 && map2[nr][nc] != -1) {
				// 맵 복사
				int[][] cpyMap = copy_map(map2);
				Node[] cpyfish = copy_fish(fish2);
				int[] cpydir = copy_dir(direction2);

				// 물고기 먹기
				cpydir[0] = cpydir[cpyMap[nr][nc]]; // 상어 방향 바꾸기
				cpydir[cpyMap[nr][nc]] = -1; // 잡아먹힌 물고기 방향 -1
				cpyfish[0] = new Node(nr, nc); // 상어 위치 저장
				int k = cpyMap[nr][nc];
				cpyMap[nr][nc] = 0;
				cpyMap[r][c] = -1; // 상어 지나간곳 빈칸

				//				System.out.println(cnt+k);
				play(nr, nc, cnt+k, cpyMap, cpyfish, cpydir);
			}

		}
	}

	private static int[] copy_dir(int[] direction2) {
		int[] cpy = new int[direction2.length];
		for (int i = 0; i < direction2.length; i++) {
			cpy[i] = direction2[i];
		}
		return cpy;
	}

	private static Node[] copy_fish(Node[] fish2) {
		Node[] cpy = new Node[fish2.length];
		for (int i = 0; i < cpy.length; i++) {
			cpy[i] = fish2[i];
		}
		return cpy;
	}

	private static int[][] copy_map(int[][] map2) {
		int[][] cpy = new int[4][4];
		for (int i = 0; i < cpy.length; i++) {
			for (int j = 0; j < cpy.length; j++) {
				cpy[i][j] = map2[i][j];
			}
		}
		return cpy;
	}

	private static void move_fish(int[][] map2, Node[] fish2, int[] direction2) {
		for (int i = 1; i < 17; i++) {
			if (direction2[i] == -1) {
				continue;
			}
			// 방향 다 돌아봐야하니까...!
			for (int j = 0; j < 8; j++) {
				int nr = fish2[i].r + dr[direction2[i]];
				int nc = fish2[i].c + dc[direction2[i]];

				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map2[nr][nc] != 0) {
					// 빈칸아닐때
					int temp = map2[nr][nc];
					// 위치 바꾸기
					map2[fish2[i].r][fish2[i].c] = temp;
					map2[nr][nc] = i;
					// 빈칸 아니면 바꿔주기
					if(temp != -1) {
						fish2[temp] = new Node(fish2[i].r, fish2[i].c);
					}
					fish2[i] = new Node(nr, nc);
					break;
				} else {
					direction2[i] = (direction2[i] + 1) % 8;
				}
			}
		}
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		//		public int compareTo(Node o) {
		//			return Integer.compare(this.no, o.no);
		//		}
	}

	private static void print() {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}
