# 📘 12904 A와 B

## 소요시간, 메모리
164ms, 16724KB

## 풀이 방법
- T를 제거하는 방식으로 구현
- 꼬리가 A면 꼬리 삭제
- 꼬리가 B면 꼬리 삭제 후 문자열 뒤집기 (꼬리를 반대쪽으로 바꿔줌)

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gold5_12904_A와B {

	static String S, T;
	static int tail, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();

		tail = T.length()-1;
		while(T.length() > S.length()) {
			if(T.charAt(tail) == 'A') {
				if(tail == 0) {
					T = T.substring(1);
				} else {
					T = T.substring(0, tail);
					tail--;
				}
			} else {
				if(tail == 0) {
					T = T.substring(1);
					tail = T.length()-1;
				} else {
					T = T.substring(0, tail);
					tail = 0;
				}
			}
		}

		String result = "";
		if(tail == 0) {
			for (int i = T.length()-1; i >= 0; i--) {
				result += T.charAt(i);
			}
		} else {
			result = T;
		}
		//		System.out.println(result);
		System.out.println(result.equals(S) ? 1 : 0);
		//		dfs();
	}

	private static void dfs() {
		if(T.equals(S)) {
			result = 1;
			return;
		}


	}

}
```