# 📘 전력망을 둘로 나누기

## 풀이 방법
- 인접배열 채운 후
- wires 배열 다 탐색해보기
- 처음에 queue 두개로 각각 탐색해보려했는데, 생각해보니까 하나만 탐색하면 방문 안한곳은 자동으로 나머지들끼리 연결되어있음
- 따라서 탐색한 후 [방문한거 - 방문 안한거] 해줌

## Code

```java
package programmers;

import java.util.*;

public class L2_전력망을둘로나누기 {

	int answer, cnt;
	boolean[][] adj;
	boolean[] visit;

	public int solution(int n, int[][] wires) {
		answer = n;

		cnt = n;
		adj = new boolean[n+1][n+1];

		for(int i = 0; i < wires.length; i++){
			adj[wires[i][0]][wires[i][1]] = adj[wires[i][1]][wires[i][0]] = true;
		}

		for(int i = 0; i < wires.length; i++){
			bfs(wires[i][0], wires[i][1]);
		}

		return answer;
	}

	public void bfs(int a, int b){
		// 하나만 탐색해보면 됨 (방문 한거 - 방문 안한거)
		Queue<Integer> queue = new LinkedList<>();
		visit = new boolean[cnt+1];
		queue.offer(a);
		visit[a] = true;
		int tmp = 1;

		while(!queue.isEmpty()){
			int cur = queue.poll();

			for(int i = 1; i < adj.length; i++){
				if(adj[cur][i] && !visit[i] && i != b){
					queue.offer(i);
					visit[i] = true;
					tmp++;
				}
			}
		}

		answer = Math.min(answer, Math.abs((cnt - tmp) - tmp));
	}
}
```