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
