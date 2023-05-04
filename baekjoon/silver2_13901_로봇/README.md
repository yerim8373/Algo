# 📘 13901 로봇

## 소요시간, 메모리
176ms, 20876KB

## 풀이 방법
- bfs라고 하기도 애매한 ..?
- 큐에 넣고 계속 돌림
- 처음에 방향 잘못 저장해서 틀림

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_13901_로봇 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C, r_R, r_C;
	static int[] dir = new int[4];
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int k = Integer.parseInt(br.readLine());
		// 장애물 & 방문 표시 9
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int brr = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());
			map[brr][bc] = 9;
		}
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int d = Integer.parseInt(st.nextToken());
			dir[i] = d-1;
		}

		//		map[sr][sc] = 9;
		bfs(sr, sc);
		System.out.println(r_R + " " + r_C);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visit = new boolean[R][C];
		queue.offer(new int[] {sr, sc, 0});
		visit[sr][sc] = true;

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			r_R = cur[0];
			r_C = cur[1];
			//			System.out.println(r_R + " " + r_C);
			//			System.out.println("========================");

			for (int i = 0; i < dir.length; i++) {
				// 방향 조심 ㅠ
				int d = (cur[2] + i) % 4;
				int nr = cur[0] + dr[dir[d]];
				int nc = cur[1] + dc[dir[d]];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc] && map[nr][nc] != 9) {
					visit[nr][nc] = true;
					queue.offer(new int[] {nr, nc, d});
					break;
				}
			}
		}
	}
}
```