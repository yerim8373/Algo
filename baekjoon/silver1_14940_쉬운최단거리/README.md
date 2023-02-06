# 📘 14940

## 소요시간, 메모리
2256ms, 73124KB

## 풀이 방법
- 목표지점부터 bfs 탐색
- 탐색한 곳 3으로 변경 후 마지막 출력 때 1이면 탐색안한 곳이니까 -1 출력하기

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_14940_쉬운최단거리 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int n, m, r_end, c_end;
	static int[][] map, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		result = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					r_end = i;
					c_end = j;
				}
			}
		}

		bfs(new Node(r_end, c_end, 0));

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 1) {
					result[r][c] = -1;
				}
				System.out.print(result[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		map[node.r][node.c] = 3;

		while(!queue.isEmpty()) {
			Node q = queue.poll();
			result[q.r][q.c] = q.cnt;

			for (int d = 0; d < dc.length; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]==1) {
					map[nr][nc] = 3;
					queue.offer(new Node(nr, nc, q.cnt+1));
				}
			}
		}
	}

	public static class Node{
		int r, c, cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}


```