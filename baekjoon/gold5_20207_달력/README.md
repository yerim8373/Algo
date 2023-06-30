# 📘 15686 치킨 배달

## 소요시간, 메모리
208ms, 15700KB

## 풀이 방법
1. 치킨집, 집 위치 arraylist에 담기
2. 치킨집 개수 중 M개씩 조합
3. 조합돌리면서 집마다 치킨거리 구하기
4. 치킨거리 최솟값 갱신

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_15686_치킨배달 {
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Node> chi_list = new ArrayList<>();
	static ArrayList<Node> home_list = new ArrayList<>();
	static int[] comb;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					chi_list.add(new Node(r+1, c+1));
				} else if(map[r][c] == 1) {
					home_list.add(new Node(r+1, c+1));
				}
			}
		}

		comb = new int[M];
		visit = new boolean[chi_list.size()];

		for (int i = 0; i < chi_list.size(); i++) {
			visit[i] = true;
			comb[0] = i;
			combination(i, 1);
			visit[i] = false;
		}

		System.out.println(result);
	}

	private static void combination(int k, int cnt) {
		if(cnt == M) {
			play();
			return;
		}

		for (int i = k+1; i < chi_list.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb[cnt] = i;
				combination(i, cnt+1);
				visit[i] = false;
			}
		}
	}

	private static void play() {
		int home_chi = 0; // 조합 -치킨거리
		for (int i = 0; i < home_list.size(); i++) {
			// 집에서 치킨집까지 거리 최솟값
			int min_home = Integer.MAX_VALUE;
			for (int j = 0; j < comb.length; j++) {
				Node h = home_list.get(i);
				Node c = chi_list.get(comb[j]);
				min_home = Math.min(min_home, Math.abs(h.r-c.r)+Math.abs(h.c-c.c));
			}
			home_chi += min_home;
		}

		result = Math.min(result, home_chi);
	}

	static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}


```