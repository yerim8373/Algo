# 📘 1926 그림

## 소요시간, 메모리
488ms, 46324KB

## 풀이 방법
- bfs

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_1926_그림 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int n, m, count = 0, area = 0;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];

		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 1 && !visit[r][c]) {
					count++;
					bfs(new Node(r, c));
				}
			}
		}

		System.out.println(count + "\n" + area);
	}

	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		visit[node.r][node.c] = true;
		int a = 0;

		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			a++;

			for (int d = 0; d < dc.length; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc] == 1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					queue.offer(new Node(nr, nc));
				}
			}
		}

		area = Math.max(area, a);
	}

	static class Node{
		int r, c, cnt;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

```