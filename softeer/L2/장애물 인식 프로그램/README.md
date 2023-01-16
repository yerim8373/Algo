# 📘 장애물 인식 프로그램

## 풀이 방법
- bfs 탐색
- 블럭 갯수랑 블럭 당 장애물 갯수 세줌
- 어이없는 실수... this.r = r;......... 아휴아휴

## Code

```java
import java.util.*;
import java.io.*;


public class Main
{
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visit;
	static int N, cnt_block=0;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for(int r=0; r<N; r++){
			String str = br.readLine();
			for(int c=0; c<N; c++){
				map[r][c] = str.charAt(c) - '0';
			}
		}

		for(int r=0; r<N; r++){
			for(int c=0; c<N; c++){
				if(!visit[r][c] && map[r][c] == 1){
					cnt_block++;
					visit[r][c] = true;
					result.add(bfs(new Node(r, c)));
				}
			}
		}

		Collections.sort(result);
		System.out.println(cnt_block);
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i));
		}
	}

	private static int bfs(Node node){
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		int cnt_dis = 0;

		while(!queue.isEmpty()){
			Node n = queue.poll();
			cnt_dis++;

			for(int d=0; d<dc.length; d++){
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==1 && !visit[nr][nc]){
					visit[nr][nc] = true;
					queue.offer(new Node(nr, nc));
				}
			}
		}

		return cnt_dis;
	}

	static class Node{
		int r, c;

		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}

```