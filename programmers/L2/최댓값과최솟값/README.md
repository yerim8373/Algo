# 📘 최댓값과 최솟값

## 풀이 방법
- 문자열 나눠준 후 최대, 최소 구하기

## Code

```java
import java.util.*;
class Solution {
	public String solution(String s) {
		String answer = "";
		StringTokenizer st = new StringTokenizer(s);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int cnt = st.countTokens();

		for (int i = 0; i < cnt; i++) {
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(a, max);
			min = Math.min(a, min);
		}

		answer = Integer.toString(min) + " " + Integer.toString(max);
		return answer;
	}
}

```