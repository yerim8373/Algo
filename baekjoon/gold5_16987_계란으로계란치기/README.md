# 📘 16987 계란으로 계란치기

## 소요시간, 메모리
208ms, 15284KB

## 풀이 방법
- dfs, 백트래킹
- 모든 계란을 다 쳐보기
- 손에든 계란이 맨 오른쪽이거나, 모든 계란이 다 깨졌으면 return
- 손에든 계란이 깨져있으면 다음꺼 탐색
- 모든 계란 탐색하면서 쳐야하는 계란이 깨져있는 경우 continue

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_16987_계란으로계란치기 {
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Egg[] eggs = new Egg[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(S, W);
		}
		// 백트래킹
		dfs(0, 0, eggs);
		System.out.println(result);
	}

	private static void dfs(int cur, int cnt, Egg[] eggs) {
		// 맨 오른쪽 계란이거나 계란이 다 깨졌으면 끗
		if(cur == eggs.length || cnt == eggs.length-1) {
			result = Math.max(result, cnt);
			return;
		}

		// 손에 든 계란이 깨져있으면 걍 넘기기
		if(eggs[cur].S <= 0) {
			dfs(cur+1, cnt, eggs);
			return;
		}

		for (int tmp = 0; tmp < eggs.length; tmp++) {
			int tmpCnt = cnt;

			if(tmp == cur) continue;
			// 칠 계란이 깨져있는 경우
			if(eggs[tmp].S <= 0) continue;

			eggs[cur].S -= eggs[tmp].W;
			eggs[tmp].S -= eggs[cur].W;

			if(eggs[cur].S <= 0){
				tmpCnt++;
			}
			if(eggs[tmp].S <= 0) {
				tmpCnt++;
			}

			dfs(cur+1, tmpCnt, eggs);

			eggs[cur].S += eggs[tmp].W;
			eggs[tmp].S += eggs[cur].W;
		}
	}

	static class Egg {
		int S, W;

		public Egg(int S, int W) {
			this.S = S;
			this.W = W;
		}
	}
}

```