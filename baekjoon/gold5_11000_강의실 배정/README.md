# 📘 11000 강의실 배정

## 소요시간, 메모리
724ms, 68892KB

## 풀이 방법
- 그리디
- 입력받은 시간들을 s -> t 순서로 오름차순 정렬
- 정렬된 배열들 순차적으로 탐색하면서
- 시작 시간이 pq의 맨 앞에 있는 끝나는 시간보다 크거나 같으면 poll 후 offer
- 작으면 그냥 offer

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_11000_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Lesson[] arr = new Lesson[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			arr[i] = new Lesson(S, T);
		}

		Arrays.sort(arr);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(arr[0].t);

		for (int i = 1; i < arr.length; i++) {
			// 다음 시작 시간이 맨 앞 끝나는 시간보다 크거나 같으면 빼고 넣기
			if(arr[i].s >= pq.peek()) {
				pq.poll();
			}
			pq.offer(arr[i].t);
		}

		System.out.println(pq.size());

	}

	static class Lesson implements Comparable<Lesson> {
		int s, t;

		public Lesson(int s, int t) {
			this.s = s;
			this.t = t;
		}

		public int compareTo(Lesson o) {
			if(o.s == this.s) {
				return Integer.compare(this.t, o.t);
			}
			return Integer.compare(this.s, o.s);
		}
	}
}
```