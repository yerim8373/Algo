# 📘 게임 맵 최단거리

## 풀이 방법
- 최단 거리 -> bfs
- 방문배열 따로 생성안하고 map 갱신하면서 탐색
- dfs로 하면 효율성에서 탈락

## Code

```java
import java.util.*;
class Solution {
	int answer;
	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};
	boolean[][] visit;

	public int solution(int[][] maps) {
		answer = Integer.MAX_VALUE;

		// dfs(0, 0, 1, maps);
		bfs(maps);

		return maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
	}

	private void bfs(int[][] maps){
		Queue<Node> queue = new LinkedList<>();
		// visit = new boolean[maps.length][maps[0].length];
		queue.offer(new Node(0, 0));
		// visit[0][0] = true;

		while(!queue.isEmpty()){
			Node q = queue.poll();
			if(q.r == maps.length-1 && q.c == maps[0].length-1){
				return;
			}

			for(int d = 0; d < dr.length; d++){
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[nr].length && maps[nr][nc] == 1){
					maps[nr][nc] = maps[q.r][q.c]+1;
					queue.offer(new Node(nr, nc));
				}
			}
		}
	}

	public class Node{
		int r, c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
			// this.cnt = cnt;
		}
	}

	private void dfs(int r, int c, int cnt, int[][] maps){
		if(r==maps.length-1 && c==maps[r].length-1){
			answer = Math.min(answer, cnt);
			return;
		}

		for(int d = 0; d < dr.length; d++){
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[nr].length && !visit[nr][nc] && maps[nr][nc] == 1){
				visit[nr][nc] = true;
				dfs(nr, nc, cnt+1, maps);
				visit[nr][nc] = false;
			}
		}
	}
}

```