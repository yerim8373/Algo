package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_12919_A와B2 {
	static String S;
//	static List<Character> t = new LinkedList<>();
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		String T = br.readLine();
		// System.out.println(S.charAt(S.length()));
		rem_a(T, 0);
		rem_b(T, 0);
		System.out.println(result);
	}

	private static void rem_b(String t, int first) {
		if(S.length() == t.length()) {
			check(t, first);
			return;
		}
		
		if(first == 0) {
			if(t.charAt(first) == 'B') {
				t = t.substring(1);
				first = t.length();
				rem_b(t, first);
				rem_a(t, first);
			}
		} else {
			if(t.charAt(first-1) == 'B') {
				t = t.substring(0, t.length()-1);
				first = 0;
				rem_b(t, first);
				rem_a(t, first);
			}
		}
	}

	private static void rem_a(String t, int first) {
		if(S.length() == t.length()) {
			check(t, first);
			return;
		}
		
		if(first == 0) {
			if(t.charAt(t.length()-1) == 'A') {
				t = t.substring(0, t.length()-1);
				rem_b(t, first);
				rem_a(t, first);
			}
		} else {
			if(t.charAt(0) == 'A') {
				t = t.substring(1);
				first = t.length();
				rem_b(t, first);
				rem_a(t, first);
			}
			
		}
	}

	private static void check(String t, int first) {
		if(first == 0) {
			if(t.equals(S)) {
				result = 1;
				return;
			}
		} else {
			String str = "";
			for (int i = t.length()-1; i >= 0; i--) {
				str += t.charAt(i);
			}
			if(str.equals(S)) {
				result = 1;
				return;
			}
		}
	}

}
