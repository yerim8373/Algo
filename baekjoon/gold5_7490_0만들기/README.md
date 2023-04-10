# 📘 7490 0 만들기

## 소요시간, 메모리
196ms, 17176KB

## 풀이 방법
- dfs 돌려서 계산
- 이전 연산자를 저장해야하니까 -1, +1로 넘겨줌
- ASCII 순서로 출력해야하는거 주의 (공백 -> + -> -)

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_7490_0만들기 {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			dfs(1, 1, 0, 1, "1");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur, int num, int sum, int oper, String str) {
		//		System.out.println(cur + " " + num + " " + sum + " " + oper + " " + str);
		if(cur == N) {
			sum = sum + (num*oper);
			if(sum == 0) {
				sb.append(str+"\n");
			}
			return;
		}

		// ASCII 순서로 출력해야하니까 공백->+->- 순서로 탐색하기!
		// 공백 
		dfs(cur+1, (num*10)+cur+1, sum, oper, str+" "+(cur+1));
		// +
		dfs(cur+1, cur+1, sum+(num*oper), 1, str+"+"+(cur+1));
		// -
		dfs(cur+1, cur+1, sum+(num*oper), -1, str+"-"+(cur+1));
	}
}
```