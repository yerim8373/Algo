# 📘 2206 벽 부수고 이동하기

## 소요시간, 메모리
852ms, 161592KB

## 풀이 방법
- bfs
- 방문배열을 3차원 배열로 선언하여 벽을 부신적이 있는지 없는지에 따라 방문배열이 나눠짐
- 방문배열 조건 처리 안해줘서 틀렸었음 (메모리초과)

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold3_2206_벽부수고이동하기 {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		bfs();

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		// 3차원 방문배열 -> 벽 부셨으면 [r][c][1] = true / 안부셨으면 [r][c][0] = true
		boolean[][][] visit = new boolean[N][M][2];
		queue.offer(new Node(0, 0, 1, false));
		visit[0][0][0] = true;

		while(!queue.isEmpty()) {
			Node cur = queue.poll();

			if(cur.r == N-1 && cur.c == M-1) {
				result = Math.min(result, cur.cnt);
				return;
			}

			for (int d = 0; d < dr.length; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					// 벽이 아닐때
					if(map[nr][nc] == 0) {
						// 처음에 방문배열 조건 처리 안해줬음...
						if(cur.check && !visit[nr][nc][1]) {
							visit[nr][nc][1] = true;
							queue.offer(new Node(nr, nc, cur.cnt+1, cur.check));
						} else if(!cur.check && !visit[nr][nc][0]) {
							visit[nr][nc][0] = true;
							queue.offer(new Node(nr, nc, cur.cnt+1, cur.check));
						}
					}
					// 벽일때
					else {
						// 안부셨을 경우에만 진행
						if(!cur.check) {
							visit[nr][nc][1] = true;
							queue.offer(new Node(nr, nc, cur.cnt+1, true));
						}
					}
				}
			}
		}
	}

	static class Node {
		int r, c, cnt;
		boolean check;
		public Node(int r, int c, int cnt, boolean check) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.check = check;
		}
	}
}

```
