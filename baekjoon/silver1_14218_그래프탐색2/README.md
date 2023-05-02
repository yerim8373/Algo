# 📘 14218 그래프 탐색2

## 소요시간, 메모리
ms, KB

## 풀이 방법
- 인접그래프 만들어서 탐색
- 처음에 모든 노드부터 1까지 탐색 -> 시간초과
- 1부터 모든 노드 탐색하도록 함
- 70퍼에서 자꾸 오류 why??

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_14218_그래프탐색2 {

	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new List[n+1];

		for (int i = 0; i <= n; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		int q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);

			int[] arr = addRoad(a, b);

			sb.append(0 + " ");
			for (int j = 2; j < arr.length; j++) {
				sb.append(arr[j] == 0 ? -1 : arr[j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static int[] addRoad(int a, int b) {
		int[] arr = new int[list.length];
		boolean[] visit = new boolean[list.length];
		arr[1] = 0;
		visit[1] = true;

		Queue<Node> pq = new LinkedList<Node>();
		pq.offer(new Node(1, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			arr[cur.city] = cur.cnt;

			for (int j = 0; j < list[cur.city].size(); j++) {
				if(!visit[list[cur.city].get(j)]) {
					pq.offer(new Node(list[cur.city].get(j), cur.cnt+1));
					//					arr[list[cur.city].get(j)] = cur.cnt+1;
					visit[list[cur.city].get(j)] = true;
				}
			}
		}

		return arr;
	}

	public static class Node{
		int city, cnt;
		public Node(int city, int cnt) {
			this.city = city;
			this.cnt = cnt;
		}
	}
}
```