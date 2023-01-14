# 📘 숫자 게임

## 풀이 방법
- A, B 배열 정렬 후 탐색 시작
- B, A 둘 다 끝에서부터 탐색
- B가 A보다 클때까지 반복, 크면 다음 B원소로 넘어가는데 어차피 다음 원소는 작으니까 for문 하나로 돌려도 충분함!!

## Code

```java
package programmers;

import java.util.Arrays;

public class L3_숫자게임 {
	//	static boolean[] visit;

	public static void main(String[] args) {
		int[] A = {5, 1, 3, 7};
		int[] B = {2,2,6,8};
		System.out.println(solution(A, B));
	}
	public static int solution(int[] A, int[] B) {
		int answer = 0;
		//        visit = new boolean[A.length];

		Arrays.sort(A);
		Arrays.sort(B);

		int a = B.length-1;
		for (int i = B.length-1; i >= 0; i--) {
			if(A[i] < B[a]) {
				answer++;
				a--;
			}
		}

		return answer;
	}
}

```