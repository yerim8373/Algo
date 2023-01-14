package programmers;

import java.util.*;

public class L2_올바른괄호 {

	public static void main(String[] args) {
		System.out.println(solution("(()("));
	}

	static boolean solution(String s) {

		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stk.add(s.charAt(i));
			} else {
				if(stk.isEmpty()) {
					return false;
				}
				stk.pop();
			}
		}

		if(stk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
