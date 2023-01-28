# 📘 6603 로또

## 소요시간, 메모리
128ms, 14296KB

## 풀이 방법
- 조합해서 6개면 출력

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_6603_로또 {
	static int[] arr, combination = new int[6];
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}

			arr = new int[k];
			visit = new boolean[k];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void comb(int k, int cnt) {
		if(cnt == 6) {
			for (int i : combination) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = k; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				combination[cnt] = i;
				comb(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}

}


```