package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_1446_지름길 {
	static int N, D, result=0;
	static List<Node> graph;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		dist = new int[D+1];
		
		for (int i = 0; i <= D; i++) {
			dist[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(end > D) {
				continue;
			}
			graph.add(new Node(start, end, len));
		}
		
		dijkstra();
		System.out.println(dist[D]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		dist[0] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (Node next : graph) {
				
				if(next.start >= cur.end) {
					if(dist[next.end] > dist[cur.end] + next.len + (next.start - cur.end)) {
						dist[next.end] =  dist[cur.end] + next.len + (next.start - cur.end);
						pq.offer(new Node(cur.end, next.end, dist[next.end]));
					}
				}
			}
			
			dist[D] = Math.min(dist[D], dist[cur.end] + D - cur.end);
		}
	}

	public static class Node implements Comparable<Node>{
		int start, end, len;
		public Node(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.len, o.len);
		}
	}
}
