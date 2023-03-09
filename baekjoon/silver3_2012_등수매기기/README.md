# 📘 2012 등수 매기기

## 소요시간, 메모리
820ms, 54008KB

## 풀이 방법
- 배열에 입력받은 후 정렬해서 순서대로 차이 더해주면 됨
- long 타입 주의

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver3_2012_등수매기기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long result = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			result += Math.abs((i+1) - arr[i]);
		}

		System.out.println(result);
	}

}

```