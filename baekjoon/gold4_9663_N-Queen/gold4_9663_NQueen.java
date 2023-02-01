package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gold4_9663_NQueen {
	static int N, result=0;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		nQueen(0);
		System.out.println(result);
	}

	private static void nQueen(int k) {
		if(k == N) {
			result++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			map[k] = i;
			if(isAvailable(k)) {
				nQueen(k+1);
			}
		}
	}

	private static boolean isAvailable(int i) {
		for (int j = 0; j < i; j++) {
			if(map[j] == map[i] || Math.abs(j-i) == Math.abs(map[j]-map[i])) {
				return false;
			}
		}
		return true;
	}

}
