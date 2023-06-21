package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold4_14938_서강그라운드 {
	static int n, m, r, result = 0;
	static int[] items, dist;
	static boolean[] visit;
//	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		items = new int[n + 1];
		adjList.add(new ArrayList<>());
		st = new StringTokenizer(br.readLine());
		for (int t = 1; t <= n; t++) {
			items[t] = Integer.parseInt(st.nextToken());
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			adjList.get(a).add(new Edge(b, l));
			adjList.get(b).add(new Edge(a, l));
		}

		for (int i = 1; i <= n; i++) {
			dijkstra(i);
		}
		
		System.out.println(result);
	}

	private static void dijkstra(int i) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist = new int[n+1];
		visit = new boolean[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new Edge(i, 0));
		dist[i] = 0;
		visit[i] = true;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.end] < cur.weight) {
				continue;
			}
			
			for (int j = 0; j < adjList.get(cur.end).size(); j++) {
				Edge next = adjList.get(cur.end).get(j);
				if(!visit[next.end] && dist[next.end] > dist[cur.end] + next.weight) {
					dist[next.end] = dist[cur.end] + next.weight;
					pq.offer(new Edge(next.end, dist[next.end]));
				}
			}
		}
		
		int sum = 0;
		for (int j = 1; j <= n; j++) {
			if(dist[j] <= m) {
				sum += items[j];
			}
		}
		
		result = Math.max(result, sum);
	}

	static class Edge implements Comparable<Edge>{
		int end, weight;

		public Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
