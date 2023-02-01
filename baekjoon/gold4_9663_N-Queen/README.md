# 📘 9663 N-Queen

## 소요시간, 메모리
5260ms, 14512KB

## 풀이 방법
- 백트래킹
- 이차원 배열로 탐색할 필요없고, 같은 열에 같은 수 못놓으니까 일차원 배열로 가능
- r, c 차가 같으면 대각선에 있다는 뜻

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gold4_9663_NQueen {
	static int N, result=0;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		nQueen(0);
		System.out.println(result);
	}

	private static void nQueen(int k) {
		if(k == N) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {
			map[k] = i;
			if(isAvailable(k)) {
				nQueen(k+1);
			}
		}
	}

	private static boolean isAvailable(int i) {
		for (int j = 0; j < i; j++) {
			if(map[j] == map[i] || Math.abs(j-i) == Math.abs(map[j]-map[i])) {
				return false;
			}
		}
		return true;
	}

}


```