package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_20413_MVP다이아몬드Easy {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tier = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tier.length; i++) {
			tier[i] = Integer.parseInt(st.nextToken());
		}
		
		String str = br.readLine();
		int[] price = new int[N];
		char tmp = str.charAt(0);
		switch(tmp) {
		case 'B':
			price[0] = tier[0] - 1; break;
		case 'S':
			price[0] = tier[1] - 1; break;
		case 'G':
			price[0] = tier[2] - 1; break;
		case 'P':
			price[0] = tier[3] - 1; break;
		case 'D':
			price[0] = tier[3]; break;
		}
		
		for (int i = 1; i < str.length(); i++) {
			char t = str.charAt(i);
			switch(t) {
			case 'B':
				price[i] = tier[0] - price[i-1] - 1; break;
			case 'S':
				price[i] = tier[1] - price[i-1] - 1; break;
			case 'G':
				price[i] = tier[2] - price[i-1] - 1; break;
			case 'P':
				price[i] = tier[3] - price[i-1] - 1; break;
			case 'D':
				price[i] = tier[3]; break;
			}
		}
		
		int result = 0;
		for (int i : price) {
			result += i;
		}
		
		System.out.println(result);
	}
}