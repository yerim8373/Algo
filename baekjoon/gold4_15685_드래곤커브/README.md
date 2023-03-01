# 📘 15685 드래곤 커브

## 소요시간, 메모리
136ms, 14424KB

## 풀이 방법
- K-1세대의 방향의 끝에서부터 반시계방향으로 방향이 바뀜
- 이전 세대의 끝에서부터 방향이 변하니까 stack을 사용해 끝에서부터 방향구해주기
- 방향 다 구했으면 x, y부터 시작해서 방향 바꿔가며 map 채우기
- 드래곤 커브 다 구했으면 네 꼭짓점이 드래곤 커브의 일부인 것 개수 구하기

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold4_15685_드래곤커브 {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	static int result = 0;
	static Stack<Integer> stack;
	static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			stack = new Stack<>();
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			stack.add(d);
			for (int i = 0; i < g; i++) {
				//				System.out.println(stack.size());
				curve();
			}
			// stack 맵에 저장
			save(x, y);
		}
		//		print();

		check();
		System.out.println(result);
	}

	private static void print() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	private static void check() {
		for (int r = 0; r < map.length-1; r++) {
			for (int c = 0; c < map[r].length-1; c++) {
				if(map[r][c] && map[r+1][c] && map[r][c+1] && map[r+1][c+1]) {
					result++;
				}
			}
		}
	}

	private static void save(int x, int y) {
		map[y][x] = true;
		for (int i = 0; i < stack.size(); i++) {
			x += dc[stack.get(i)];
			y += dr[stack.get(i)];
			map[y][x] = true;
		}
	}

	private static void curve() {
		int size = stack.size();
		for (int i = size-1; i >= 0; i--) {
			int dir = (stack.get(i) + 1) % 4;
			stack.add(dir);
		}
	}
}

```
