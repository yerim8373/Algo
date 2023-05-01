# 📘 15683 감시

## 소요시간, 메모리
320ms, 57364KB

## 풀이 방법
- 방향 배열 따로 만들어서 구현
- 방향배열 0부터 시작하게 해놔서, no 저장할 때 -1 해야함

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][][] dir = {{{0}, {1}, {2}, {3}},
		{{0, 2}, {1, 3}},
		{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
		{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
		{{0, 1, 2, 3}}};
	static int N, M, maxL, result;
	static ArrayList<CCTV> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = N * M;
		maxL = Math.max(N, M);
		int[][] map = new int[N][M];

		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] != 0 && map[r][c] != 6) {
					list.add(new CCTV(r, c, map[r][c]-1));
				}
			}
		}

		dfs(0, map);

		System.out.println(result);
	}

	private static void dfs(int k, int[][] map) {
		if(k == list.size()) {
			result = Math.min(result, countSpot(map));
			return;
		}


		// 방향 다 돌려보기
		for (int i = 0; i < dir[list.get(k).no].length; i++) {
			int[][] tmp_map = copyMap(map);
			// no번의 i번째 방향으로 감시
			tmp_map = watching(k, i, tmp_map);
			dfs(k+1, tmp_map);
		}
	}

	private static int countSpot(int[][] map) {
		int cnt = 0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int[][] watching(int k, int i, int[][] map) {
		CCTV cur = list.get(k);
		for (int j = 0; j < dir[cur.no][i].length; j++) {
			for (int d = 1; d < maxL; d++) {
				int nr = cur.r + dr[dir[cur.no][i][j]] * d;
				int nc = cur.c + dc[dir[cur.no][i][j]] * d;
				// 범위 벗어나거나 벽이면 stop
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 6) {
					break;
				} else {
					if(map[nr][nc] > 0 && map[nr][nc] < 6) { // cctv면 걍 넘기기
						continue;
					} else {
						// 사각지대 아닌 곳 9
						map[nr][nc] = 9;
					}
				}
			}
		}

		return map;
	}

	private static int[][] copyMap(int[][] map) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	static class CCTV {
		int r, c, no;
		public CCTV(int r, int c, int no) {
			this.r = r;
			this.c = c;
			this.no = no;
		}
	}
}
```