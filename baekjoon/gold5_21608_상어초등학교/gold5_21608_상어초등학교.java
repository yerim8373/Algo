package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_21608_상어초등학교 {
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, 1, 0, -1};
	static int N;
	static int[][] map, temp;
	static boolean[][] visit;
	static Node[] students;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		students = new Node[N*N];
		
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int[] fav = new int[4];
			fav[0] = Integer.parseInt(st.nextToken());
			fav[1] = Integer.parseInt(st.nextToken());
			fav[2] = Integer.parseInt(st.nextToken());
			fav[3] = Integer.parseInt(st.nextToken());
			
			if(con1(no, fav)) {
				
			} else {
				con2();
			}
		}
	}
	
	private static boolean con1(int no, int[] fav) {
		temp = new int[N][N];
//		Node max;
		int max = 0, cnt = 0;
		for (int i = 0; i < fav.length; i++) {
			if(students[i] != null) {
				Node cur = students[i];
				
				for (int d = 0; d < dr.length; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] == 0) {
						temp[nr][nc] += 1;
						
						if(max < temp[nr][nc]) {
							max = temp[nr][nc];
							cnt = 1;
						} else if(max == temp[nr][nc]) {
							cnt++;
						}
					}
				}
			}
		}
		
		if(cnt == 1) {
			
		}

		return false;
	}
	
	private static void con2() {
		
	}
	
	static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}