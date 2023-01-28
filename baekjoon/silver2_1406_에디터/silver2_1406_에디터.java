package BAEKJOON;

import java.util.*;
import java.io.*;

public class silver2_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Stack<Character> L_stack = new Stack<>();
		Stack<Character> R_stack = new Stack<>();
		int M = Integer.parseInt(br.readLine());
		int curser = str.length();
		
		for (int i = 0; i < str.length(); i++) {
			L_stack.add(str.charAt(i));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "L":
				if(!L_stack.isEmpty()) {
					R_stack.push(L_stack.pop());
				}
				break;
			case "D":
				if(!R_stack.isEmpty()) {
					L_stack.push(R_stack.pop());
				}
				break;
			case "B":
				if(!L_stack.isEmpty()) {
					L_stack.pop();
				}
				break;
			case "P":
				String s = st.nextToken();
				L_stack.push(s.charAt(0));
				break;
			}
		}
		
		while(!L_stack.isEmpty()) {
			R_stack.push(L_stack.pop());
		}

		while(!R_stack.isEmpty()) {
			sb.append(R_stack.pop());
		}
		System.out.println(sb);
	}

}
