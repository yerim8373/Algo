import java.util.*;
import java.io.*;

class Solution {
	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};
	boolean[][] map = new boolean[52][52];
	int[][] border = new int[52][52];

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;

		for(int i = 0; i < rectangle.length; i++){
			// 사각형 채우기
			for(int x = rectangle[i][0]; x <= rectangle[i][2]; x++){
				for(int y = rectangle[i][1]; y <= rectangle[i][3]; y++){
					map[x][y] = true;
				}
			}
		}

		bfs(0, 0);

		print();

		answer = searchRoute(characterX, characterY, itemX, itemY);

		print();

		return answer;
	}

	public int searchRoute(int cx, int cy, int ix, int iy){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {cx, cy});
		border[cx][cy] = 3; // 방문했던 곳 : 3
		int cnt = 0;

		while(!queue.isEmpty()){
			int[] cur = queue.poll();

			if(cur[0] == ix && cur[1] == iy){
				return cnt;
			}

			for(int d= 0; d < dr.length; d++){
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < 52 && nc >= 0 && nc < 52 && border[nr][nc] == 2){
					cnt++;
					queue.offer(new int[] {nr, nc});
					border[nr][nc] = 3;
				}
			}
		}

		return cnt;
	}

	public void bfs(int r, int c){
		Queue<int[]> queue = new LinkedList<>();
		// 탐색한 곳 1, 테두리 표시 2
		queue.offer(new int[] {r, c});
		border[r][c] = 1;

		while(!queue.isEmpty()){
			int[] cur = queue.poll();

			for(int d = 0; d < dr.length; d++){
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < 52 && nc >= 0 && nc < 52 && border[nr][nc] == 0){
					// map - true 면 2, map - false 면 1
					if(map[nr][nc]){
						border[nr][nc] = 2;
					} else {
						border[nr][nc] = 1;
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}

	public void print(){
		for(int r = 0; r < 11; r++){
			for(int c = 0; c < 11; c++){
				System.out.print(border[r][c] == 2 ? "O " : "X ");
			}
			System.out.println();
		}
		System.out.println("=================");
	}
}