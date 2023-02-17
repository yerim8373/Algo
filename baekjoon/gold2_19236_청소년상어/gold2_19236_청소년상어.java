package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold2_19236_청소년상어 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map = new int[4][4]; // no 저장
	static Node[] fish = new Node[17]; // 물고기 r, c
	static int[] direction = new int[17]; // 물고기 dir
	static boolean[][] visit;

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
		direction[map[0][0]] = -1; // 잡아먹힌 물고기 방향 -1
		fish[0] = new Node(0, 0); // 상어 위치 저장
		// 상어있는 곳 0, 빈칸 -1
		map[0][0] = 0;
		visit[0][0] = true;

		move_fish();
		play();

	}

	private static void play() {
		// 상어 움직이기 -> 움직일 수 있으면 움직이는 방향 리턴
		//			-> 움직일 수 없으면 -1, -1 리턴
		// return 필요 -> 상어 움직일 수 없으면 return
		if(move_shark()) {
			
		} else {
			visit[][] = true;
			play();
		}
		
		// 물고기 이동
		move_fish();
		
		
	}

	private static void move_fish() {
		for (int i = 1; i < 17; i++) {
			if (direction[i] == -1) {
				continue;
			}
			// 방향 다 돌아봐야하니까...!
			for (int j = 0; j < 8; j++) {
				int nr = fish[i].r + dr[direction[i]];
				int nc = fish[i].c + dc[direction[i]];

				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != 0) {
					// 빈칸아닐때
					int temp = map[nr][nc];
					// 위치 바꾸기
					map[fish[i].r][fish[i].c] = temp;
					map[nr][nc] = i;
					// 빈칸 아니면 바꿔주기
					if(temp != -1) {
						fish[temp] = new Node(fish[i].r, fish[i].c);
					}
					fish[i] = new Node(nr, nc);
					break;
				} else {
					direction[i] = (direction[i] + 1) % 8;
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
