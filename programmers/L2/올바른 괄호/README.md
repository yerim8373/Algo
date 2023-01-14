# 📘 올바른 괄호

## 풀이 방법
- '(' 만나면 스택에 넣고, ')' 만나면 빼기
- ')' 만났는데 스택이 비어있으면 false 리턴
- for문 다 돌았는데 스택에 남아있으면 false 리턴

## Code

```java
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

```