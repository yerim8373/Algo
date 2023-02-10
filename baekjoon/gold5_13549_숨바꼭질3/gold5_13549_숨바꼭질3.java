package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_13549_숨바꼭질3 {
	static int N, K;
	static int[] time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100001];
		for (int i = 0; i < time.length; i++) {
			time[i] = Integer.MAX_VALUE;
		}
		
		dijkstra();
//		System.out.println(time[9]);
		System.out.println(time[K]);
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(N, 0));
		time[N] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.v == K) {
				return;
			} else {
				if(cur.v-1 >= 0 && time[cur.v-1] > cur.t+1) {
					time[cur.v-1] = cur.t+1;
					pq.offer(new Node(cur.v-1, cur.t+1));
				}
				if(cur.v*2 <= 100000 && time[cur.v*2] > cur.t) {
					time[cur.v*2] = cur.t;
					pq.offer(new Node(cur.v*2, cur.t));
				}
				if(cur.v+1 <= 100000 && time[cur.v+1] > cur.t+1) {
					time[cur.v+1] = cur.t+1;
					pq.offer(new Node(cur.v+1, cur.t+1));
				}
			}
			
		}
	}

	static class Node implements Comparable<Node>{
		int v, t;
		public Node(int v, int t) {
			this.v = v;
			this.t = t;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.t, o.t);
		}
	}
}
