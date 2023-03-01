package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold4_15685_드래곤커브 {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	static int result = 0;
	static Stack<Integer> stack;
	static boolean[][] map = new boolean[101][101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			stack = new Stack<>();
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			stack.add(d);
			for (int i = 0; i < g; i++) {
//				System.out.println(stack.size());
				curve();
			}
			// stack 맵에 저장
			save(x, y);
		}
//		print();
		
		check();
		System.out.println(result);
	}

	private static void print() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	private static void check() {
		for (int r = 0; r < map.length-1; r++) {
			for (int c = 0; c < map[r].length-1; c++) {
				if(map[r][c] && map[r+1][c] && map[r][c+1] && map[r+1][c+1]) {
					result++;
				}
			}
		}
	}

	private static void save(int x, int y) {
		map[y][x] = true;
		for (int i = 0; i < stack.size(); i++) {
			x += dc[stack.get(i)];
			y += dr[stack.get(i)];
			map[y][x] = true;
		}
	}

	private static void curve() {
		int size = stack.size();
		for (int i = size-1; i >= 0; i--) {
			int dir = (stack.get(i) + 1) % 4;
			stack.add(dir);
		}
	}
}
