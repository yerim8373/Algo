# 📘 1916 최소 비용 구하기

## 소요시간, 메모리
564ms, 50832KB

## 풀이 방법
- 다익스트라로 목적지까지 최소 비용 구하기

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_1916_최소비용구하기 {
	static int N, M, start, end;
	static ArrayList<Node>[] graph;
	static boolean[] visit;
	static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		dist = new int[N+1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int iu = Integer.parseInt(st.nextToken());
			int iv = Integer.parseInt(st.nextToken());
			int iw = Integer.parseInt(st.nextToken());
			graph[iu].add(new Node(iv, iw));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dist[start] = 0;

		dijkstra();

		System.out.println(dist[end]);
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, dist[start]));

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(!visit[n.v]) {
				visit[n.v] = true;

				for (Node next : graph[n.v]) {
					if(!visit[next.v] && dist[next.v] > next.w + n.w) {
						dist[next.v] = next.w + n.w;
						pq.offer(new Node(next.v, dist[next.v]));
					}
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
}


```