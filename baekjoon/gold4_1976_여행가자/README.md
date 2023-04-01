# 📘 1976 여행 가자

## 소요시간, 메모리
360ms, 24672KB

## 풀이 방법
- 입력으로 인접배열 주어짐 (양방향)
- 각 여행 경로마다 bfs 탐색
- bfs 탐색 시 큐에서 꺼낼 때 목적지 나오면 true 리턴하고 다 탐색했는데 목적지 안나오면 false

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold4_1976_여행가자 {
	static boolean[][] map;
	static int[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		visit = new int[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(st.nextToken().equals("1")) {
					map[i][j] = true;
					map[j][i] = true;
				}
			}
		}


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}

		boolean result = true;
		for (int i = 0; i < visit.length-1; i++) {
			if(!result) break;
			result = bfs(visit[i], visit[i+1]);
		}

		System.out.println(result ? "YES" : "NO");
	}

	private static boolean bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] v = new boolean[map.length];
		queue.offer(start);
		v[start] = true;

		while(!queue.isEmpty()) {
			int cur = queue.poll();

			if(cur == end) {
				return true;
			}

			for (int i = 1; i < map.length; i++) {
				if(map[cur][i] && !v[i]) {
					v[i] = true;
					queue.offer(i);
				}
			}
		}

		return false;
	}

}


```