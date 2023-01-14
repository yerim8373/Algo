# 📘 이진 변환 반복하기

## 풀이 방법
- s가 "1"이 될때까지 반복
- for문 돌면서 "0", "1" 갯수 세기
- "1" 갯수를 이진 변환 (Integer.toBinaryString() 함수 사용)

## Code

```java
package programmers;

import java.util.Arrays;

public class L2_이진변환반복하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001")));
	}
	public static int[] solution(String s) {
		int[] answer = new int[2];

		int cnt = 0, cnt_zero = 0;

		while(!s.equals("1")) {
			int cnt_one = 0;

			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1') {
					cnt_one++;
				} else {
					cnt_zero++;
				}
			}

			s = Integer.toBinaryString(cnt_one);
			cnt++;
		}

		answer[0] = cnt;
		answer[1] = cnt_zero;

		return answer;
	}
}

```