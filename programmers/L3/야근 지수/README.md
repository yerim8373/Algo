# 📘 야근 지수

## 풀이 방법
- PriorityQueue 사용해서 역순으로 정렬 -> PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
- 문제 잘 읽어보기...!

## Code

```java
package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class L3_야근지수 {

	public static void main(String[] args) {
		int[] works = {4, 3, 3};
		System.out.println(solution(4, works));
	}

	public static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}

		while(n > 0) {
			int work = pq.poll();
			if(work == 0) break;
			work--;
			pq.offer(work);
			n--;
		}

		for(int q : pq) {
			answer += Math.pow(q, 2);
		}

		return answer;
	}
}


```