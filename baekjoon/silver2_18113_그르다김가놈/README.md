# 📘 18113 그르다 김가놈

## 소요시간, 메모리
600ms, 93820KB

## 풀이 방법
- 이분탐색
- 처음에 수학으로 해결하려다 실패
- 1부터 L 최댓값 이분탐색하면서 최대 길이 구하기

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class silver2_18113_그르다김가놈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int start = 1, end = 1;

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int L = Integer.parseInt(br.readLine());
			if(L > 2*K) {
				L -= 2*K;
				list.add(L);
			} else if(L < 2*K && L > K) {
				L -= K;
				list.add(L);
			}
			end = Math.max(end, L);
		}

		if(list.isEmpty()) {
			System.out.println(-1);
			return;
		}

		int result = -1;
		while(start <= end) {
			int mid = (start + end) / 2;

			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				cnt += list.get(i) / mid;
			}

			// 범위안에 들면 결과값 갱신하고, start 변경
			if(cnt >= M) {
				result = mid;
				start = mid + 1;
			} else { // 범위안에 들지 않으면 end 변경
				end = mid - 1;
			}
		}

		System.out.println(result);
	}

}
```