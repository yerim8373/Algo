package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver3_2503_숫자야구 {
	static int result = 0;
	static List<List<Integer>> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		result = 0;
		int N = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[10];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(i).add(Integer.parseInt(st.nextToken()));
			list.get(i).add(Integer.parseInt(st.nextToken()));
			list.get(i).add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i < 10; i++) {
			String str = Integer.toString(i);
			visit[i] = true;
			dfs(str, visit);
			visit[i] = false;
		}
		
		System.out.println(result);
	}

	private static void dfs(String str, boolean[] visit) {
		if(str.length() == 3) {
			for (int i = 0; i < list.size(); i++) {
				String g = Integer.toString(list.get(i).get(0));
				int strike = 0, ball = 0;
				for (int j = 0; j < 3; j++) {
					if(str.charAt(j) == g.charAt(j)) {
						strike++;
					} else if(g.contains(Character.toString(str.charAt(j)))) {
						ball++;
					}
				}
				if(strike != list.get(i).get(1) || ball != list.get(i).get(2)) {
					return;
				}
			}
			result++;
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(str + Integer.toString(i), visit);
				visit[i] = false;
			}
		}
	}

}
