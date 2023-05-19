# 📘 1759 암호 만들기

## 소요시간, 메모리
184ms, 18540KB

## 풀이 방법
- 문자 입력받은 후 dfs 돌림

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_1759_암호만들기 {

	static int L, C;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		dfs(0, 0, ""); // arr 순서, res 순서
	}

	private static void dfs(int idx, int k, String res) {
		// 문자열 완성되면 체크
		if(k == L) {
			if(checkStr(res)) {
				System.out.println(res);
			}
			return;
		}
		// idx 끝까지 탐색했으면 return
		if(idx == C) {
			return;
		}

		dfs(idx+1, k+1, res + arr[idx]);
		dfs(idx+1, k, res);
	}

	private static boolean checkStr(String res) {
		int m = 0, j = 0;
		for (int i = 0; i < res.length(); i++) {
			if(res.charAt(i) == 'a' || res.charAt(i) == 'e' || res.charAt(i) == 'i' || res.charAt(i) == 'o' || res.charAt(i) == 'u') {
				m++;
			} else {
				j++;
			}
		}

		if(m >= 1 && j >= 2) {
			return true;
		} else {
			return false;
		}
	}

}
```