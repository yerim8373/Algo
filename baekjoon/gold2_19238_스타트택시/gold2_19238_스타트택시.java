package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class gold2_19238_스타트택시 {
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0 ,-1};
	static int N, M, fuel;
	static boolean[][] map;
	static Node taxi;
	static int[] next;
	static ArrayList<Node> start_customer = new ArrayList<>(), end_customer = new ArrayList<>();
	static boolean[] customer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		customer = new boolean[M];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxi = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			start_customer.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			end_customer.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int cnt = 0;
		while(cnt < M) {
			// 최단 거리 손님 파악
			if(!selectCustomer()) {
				fuel = -1;
				break;
			}
			// 택시 손님한테 이동 -> 이동거리 연료 측정 , 택시 마지막에 이동해줘도 되긴함 next 있어서
			taxi = start_customer.get(next[0]);
			// next[1] : 이동 거리 즉, 연료
			fuel -= next[1];
			if(fuel <= 0) {
				fuel = -1;
				break;
			}
			// 이동가능하면 목적지 이동 -> 이동거리 연료 측정
			int endCnt = bfs(end_customer.get(next[0]));
			fuel -= endCnt;
			if(fuel <= 0) {
				fuel = -1;
				break;
			}
			// 이동가능하면 연료 추가해주기 -> 택시 -> 손님 -> 목적지 이동거리 항상 저장
			taxi = end_customer.get(next[0]);
			fuel += endCnt * 2;
			// 반복 ...
			cnt++;
		}
		
		System.out.println(fuel);
	}
	
	private static boolean selectCustomer() {
		next = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		for (int i = 0; i < start_customer.size(); i++) {
			if(customer[i]) continue;
			Node cur = start_customer.get(i);
			int tmp = bfs(cur);
			if(tmp == Integer.MAX_VALUE) continue;
			if(tmp < next[1]) {
				next[0] = i; next[1] = tmp;
			} else if(tmp == next[1]) {
				if(cur.r == start_customer.get(next[0]).r) {
					if(cur.c < start_customer.get(next[0]).c) {
						next[0] = i; next[1] = tmp; 
					}
				} else if(cur.r < start_customer.get(next[0]).r) {
					next[0] = i; next[1] = tmp;
				}
			}
		}
		
		if(next[1] == Integer.MAX_VALUE) {
			return false;
		} else {
			customer[next[0]] = true;
			return true;
		}
	}

	private static int bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N+1][N+1];
		queue.offer(new Node(taxi.r, taxi.c, 0));
		visit[taxi.r][taxi.c] = true;
		int cnt = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.r == node.r && cur.c == node.c) {
				cnt = cur.cnt;
				break;
			}
			
			for (int d = 0; d < dr.length; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr > 0 && nr <= N && nc > 0 && nc <= N && !map[nr][nc] && !visit[nr][nc]) {
					visit[nr][nc] = true;
					queue.offer(new Node(nr, nc, cur.cnt+1));
				}
			}
		}
		
		return cnt;
	}

	static class Node {
		int r, c, cnt;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
