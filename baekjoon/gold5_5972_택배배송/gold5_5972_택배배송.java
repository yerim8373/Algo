package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_5972_택배배송 {
	static int N, M;
	static boolean[] visit;
	static int[] dist;
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N+1];
		visit = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList.get(a).add(new Node(b, c));
			adjList.get(b).add(new Node(a, c));
		}
		
		dijkstra();
		
		System.out.println(dist[N]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		dist[1] = 0;
		visit[1] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.weight > dist[cur.dest]) {
				continue;
			}
			
			for (int i = 0; i < adjList.get(cur.dest).size(); i++) {
				Node next = adjList.get(cur.dest).get(i);
				// 방문하지 않았고, 다음 목적지 거리보다 현재 목적지까지의 거리와 다음 목적지 가중치를 더한 것이 더 작을 때
				if(!visit[next.dest] && dist[next.dest] > dist[cur.dest] + next.weight) {
					dist[next.dest] = dist[cur.dest] + next.weight;
					pq.offer(new Node(next.dest, dist[next.dest]));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int dest, weight;
		
		public Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
