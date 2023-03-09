# 📘 2872 우리집엔 도서관이 있어

## 소요시간, 메모리
308ms, 32584KB

## 풀이 방법
- 끝에서부터 비교
- 최댓값이면 최댓값을 하나 줄이고, 아니면 cnt 증가

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_2872_우리집엔도서관이있어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = N, cnt = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N-1; i >= 0; i--) {
			if(arr[i] == max) {
				max--;
			} else {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}

```