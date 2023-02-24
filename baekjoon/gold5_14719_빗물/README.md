# 📘 14719 빗물

## 소요시간, 메모리
148ms, 14324KB

## 풀이 방법
- 현재 열 기준으로 왼쪽 제일 큰 값과 오른쪽 제일 큰 값 구해서 둘 중 더 작은값 구해서 차이값 더해줌
- 맨앞, 맨뒤는 안해도됨

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold5_14719_빗물 {
	static int H, W, result = 0;
	static int[] block;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		block = new int[W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < W-1; i++) {
			rain(i);
		}

		System.out.println(result);
	}

	private static void rain(int i) {
		int left = 0, right = 0;
		for (int j = 0; j < i; j++) {
			if(block[j] > left && block[j] > block[i]) {
				left = block[j];
			}
		}

		for (int j = i+1; j < W; j++) {
			if(block[j] > right && block[j] > block[i]) {
				right = block[j];
			}
		}

		if(left == 0 || right == 0) {
			return;
		}
		result += Math.min(left, right) - block[i];
	}

}

```