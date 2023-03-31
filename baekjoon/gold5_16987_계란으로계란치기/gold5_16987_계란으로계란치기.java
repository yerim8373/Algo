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
		// 완탐?
		dfs(0, 0, eggs);
		System.out.println(result);
	}
	
	private static void dfs(int cur, int cnt, Egg[] eggs) {
		// 맨 오른쪽 계란이거나 계란이 다 깨졌으면 끗
		if(cur == eggs.length-1 || cnt == eggs.length) {
			result = Math.max(result, cnt);
			return;
		}
		// 손에 든 계란이 깨져있으면 걍 넘기기
		if(eggs[cur].S <= 0) {
			dfs(cur+1, cnt, eggs);
		}
		
		Egg c = eggs[cur];
		// 모든 계란 깨보기
		for (int i = cur+1; i < eggs.length; i++) {
			Egg k = eggs[i];
			
			if(k.S <= 0) {
				continue;
			}
			// 둘 다 깨질 경우
			if(c.S - k.W <= 0 && k.S - c.W <= 0) {
				eggs[cur].S -= k.W;
				eggs[i].S -= c.W;
				dfs(cur+1, cnt+2, eggs);
			} else {
				// 들고있는 계란이 깨질 경우
				if(c.S - k.W <= 0) {
					eggs[cur].S -= k.W;
					dfs(cur+1, cnt+1, eggs);
				}
				// 친 계란이 깨진 경우
				else if(k.S - c.W <= 0) {
					eggs[i].S -= c.W;
					dfs(cur, cnt+1, eggs);
				}
			}
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