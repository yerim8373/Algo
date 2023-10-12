package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class gold5_23629_이얼마나끔찍하고무시무시한수식이니 {
	static String[] word = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Deque<Character> stk = new ArrayDeque<Character>();
		boolean chk = false;

		while (!chk && str.length() != 0) {
			// 연산자일 경우
			if(checkOp(str.charAt(0))) {
				if(checkOp(stk.peekLast())) { // 앞에가 연산자면 끝내기
					chk = true;
					break;
				}
				if(str.length() > 1 && str.charAt(0) == '=') {
					chk = true;
					break;
				}
				stk.add(str.charAt(0));
				sb.append(str.charAt(0));
				str = str.substring(1);
			} else { // 숫자
				for (int i = 0; i < word.length; i++) {
					if (str.startsWith(word[i])) {
						stk.add((char) (i+'0'));
						sb.append(i);
						str = str.substring(word[i].length());
						break;
					}
					if(i == word.length-1) {
						chk = true;
					}
				}
			}
		}

		if(!stk.isEmpty() && stk.peekLast() != '=') {
			chk = true;
		}
		
		if(chk) {
			System.out.println("Madness!");
			return;
		}
		
		long result = 0;
		String cur = "";
		char c = '0';
		// 스택에서 빼면서 계산
		while (!stk.isEmpty()) {
			// 숫자 탐색
			if(!checkOp(stk.peekFirst())) {
				cur += stk.pollFirst();
			} else {
				long tmp = Long.parseLong(cur);
				cur = "";
				// c가 0이면 그냥 더해주기
				if(c == '0' || c == '+') {
					result += tmp;
				} else if(c == '-') {
					result -= tmp;
				} else if(c == 'x') {
					result *= tmp;
				} else if(c == '/') {
					result /= tmp;
				}
				
				if(stk.peekFirst() == '=') {
					break;
				} else {
					c = stk.pollFirst();
				}
			}
		}
		
		sb.append("\n");
		if(result < 0) {
			sb.append("-");
			result *= -1;
		}
		
		String s = Long.toString(result);
		for (int i = 0; i < s.length(); i++) {
			sb.append(word[s.charAt(i)-'0']);
		}
		
		System.out.println(sb);
	}

	private static boolean checkOp(Character peek) {
		if (peek == '+' || peek == '-' || peek == 'x' || peek == '/' || peek == '=') {
			return true;
		}
		return false;
	}

}
