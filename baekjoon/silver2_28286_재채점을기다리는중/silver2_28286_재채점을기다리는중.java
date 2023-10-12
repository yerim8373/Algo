package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class silver2_28286_재채점을기다리는중 {
	static int N, K, result = 0;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> origin = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(origin, 0);
		
		System.out.println(result);
	}

	private static void dfs(ArrayList<Integer> arr, int cnt) {
		if(cnt > K) {
			return;
		}
		
		// 갯수 확인
		int count = 0;
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == arr.get(i)) {
				count++;
			}
		}
		
		result = Math.max(result, count);
		
		// 당기기
		for (int i = 0; i < arr.size(); i++) {
			int tmp = arr.remove(i);
			arr.add(0);
			dfs(arr, cnt+1);
			arr.remove(arr.size()-1);
			arr.add(i, tmp);
		}
		
		// 밀기
		for (int i = 0; i < arr.size(); i++) {
			int tmp = arr.remove(arr.size()-1);
			arr.add(i, 0);
			dfs(arr, cnt+1);
			arr.remove(i);
			arr.add(tmp);
		}
	}
}