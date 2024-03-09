package codetree;

import java.io.*;
import java.util.*;

public class gold2_루돌프의반란 {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int N, M, P, C, D, result = 0;
	static int[][] map;
	static Node rudolf;
	static ArrayList<Node> santa = new ArrayList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		Node rudolf = new Node(0, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, false);
		map[rudolf.r][rudolf.c] = P+1; 
		
		//  PQ -> 산타 움직일 때마다 루돌프와의 거리 계산해서 넣기 !!!!
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			double dist = calDist(rudolf, r, c);
			santa.add(new Node(no, r, c, dist, false));
			map[r][c] = no;
		}
		
		Collections.sort(santa);
		
		for (int t = 0; t < M; t++) {
			// 루돌프 움직임
			moveRudolf();
			
			// 산타 움직임
			
			// 산타 없으면 끝
			if(santa.isEmpty()) break;
		}
		
//		for (Node s : santa) {
//			System.out.println(s.no + " " + s.r + " " + s.c + " " + s.dist);
//		}
	}
	
	private static void moveRudolf() {
		Node tmp_santa = santa.get(0);
		int dir = selectDirRudolf(rudolf, tmp_santa);
		
		// 루돌프 움직임
		map[rudolf.r][rudolf.c] = 0;
		rudolf.r = rudolf.r + dr[dir];
		rudolf.c = rudolf.c + dc[dir];
//		map[rudolf.r][rudolf.c] = P+1;
		
		// 충돌나면 get(0)산타랑 충돌난거임!!!!!
		if(0 < map[rudolf.r][rudolf.c] && map[rudolf.r][rudolf.c] <= P) {
			// 루돌프 움직인거 저장해줘
			map[rudolf.r][rudolf.c] = P+1;
			
			// 충돌난 산타가 움직이는 자리
			tmp_santa.r += dr[dir] * C;
			tmp_santa.c += dc[dir] * C;

			// 충돌났으니까 상호작용 일어나는지 확인해
			interaction(tmp_santa, dir);
			
			// 충돌난 산타 faint 변경해줘야함
		}
		// 충돌 안났으면 루돌프 움직인거 저장해줘 (안났어도 저장해줘야해)
	}

	private static void interaction(Node tmp_santa, int dir) {

		// 범위 벗어나면 그 산타 삭제해주고 다른 산타 옮겨주기 
		if(0 < tmp_santa.r && tmp_santa.r <= N && 0 < tmp_santa.c && tmp_santa.c <= N) {
			
		}
		
		// 산타랑 다른 산타랑 출동해서 상호작용 일어남
		if(0 < map[tmp_santa.r][tmp_santa.c] && map[tmp_santa.r][tmp_santa.c] <= N) {
			int r = tmp_santa.r + dr[dir];
			int c = tmp_santa.c + dc[dir];
			interaction(new Node(tmp_santa.no, r, c, tmp_santa.dist, tmp_santa.faint), dir);
		}
	}

	private static int selectDirRudolf(Node ru, Node san) {
		if(ru.r == san.r) {
			if(ru.c > san.c) {
				return 3;
			} else {
				return 4;
			}
		} else if(ru.r > san.r) {
			if(ru.c > san.c) {
				return 0;
			} else if(ru.c == san.c) {
				return 1;
			} else {
				return 2;
			}
		} else {
			if(ru.c > san.c) {
				return 5;
			} else if(ru.c == san.c) {
				return 6;
			} else {
				return 7;
			}
		}
	}

	static class Node implements Comparable<Node>{
		int no, r, c;
		double dist;
		boolean faint;
		
		public Node(int no, int r, int c, double dist, boolean faint) {
			this.no = no;
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.faint = faint;
		}
		
		public int compareTo(Node o) {
			if(this.dist == o.dist) {
				if(this.r == o.r) {
					return Integer.compare(o.c, this.c);
				}
				return Integer.compare(o.r, this.r);
			}
			return Double.compare(this.dist, o.dist);
		}
	}
	
	private static double calDist(Node ru, int r, int c) {
		return Math.pow(ru.r - r, 2) + Math.pow(ru.c - c, 2);
	}
}
