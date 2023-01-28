# 📘 1406 에디터

## 소요시간, 메모리
740ms, 146068KB

## 풀이 방법
- 처음에는 커서 위치를 저장하면서 문자열 substring, concat 활용해서 함 -> 시간초과
- 두번째에는 스택, 커서 위치 활용해서 stack.add(curser, s.charAt(0)) 으로 중간중간 추가함 -> 시간초과
- 스택 두개를 두고 L이면 오른쪽 스택으로 옮기고 R이면 왼쪽 스택으로 옮겨가면서 처리!!!
- 스택은 모든 연산이 O(1)의 시간 복잡도를 가짐 (시간초과 걸리지 않음)

## Code

```java
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

```