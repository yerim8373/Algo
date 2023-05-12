# 📘 16918 봄버맨

## 소요시간, 메모리
772ms, 44172KB

## 풀이 방법
- 구현
- 짝수 시간일 때 폭탄 추가
- 홀수 시간일 때 폭탄 터트리기
- 폭탄 터트릴 때 맵 복사 주의

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_16918_봄버맨 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		int time = 1;
		// 시간이 짝수이면 폭탄 놓기, 홀수이면 폭탄 터트리기
		// 폭탄이 2이면 터트리기
		// 폭탄 놓을 때 그냥 모든 칸을 다 증가싴켜
		while(time <= N) {
			if(time % 2 == 0) {
				addBomb(map);
			} else {
				map = popBomb(map);
			}
			time++;
		}

		print(map);

	}

	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 0) {
					System.out.print('.');
				} else {
					System.out.print('O');
				}
			}
			System.out.println();
		}
	}

	private static int[][] popBomb(int[][] map) {
		int[][] tmp = new int[R][C];
		boolean[][] visit = new boolean[R][C];

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 2) {
					tmp[r][c] = 0;
					for (int d = 0; d < dc.length; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
							tmp[nr][nc] = 0;
							visit[nr][nc] = true;
						}
					}
				} else {
					if(!visit[r][c])
						tmp[r][c] = map[r][c];
				}
			}
		}

		return tmp;
	}

	private static void addBomb(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				map[r][c]++;
			}
		}
	}

}
```