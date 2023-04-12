package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_3187_양치기꿍 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][] visit;
	static Queue<Node> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		
		
	}

	static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
