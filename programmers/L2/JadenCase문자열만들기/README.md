# 📘 JadenCase문자열만들기

## 풀이 방법
- 공백 기준으로 문자열 분리 후 대소문자 변경
- case8에서 자꾸 틀림... -> 마지막에 공백이 들어갈 수 있음! 예외처리

## Code

```java
package programmers;

import java.util.*;

public class L2_JadenCase문자열만들기 {

	public static void main(String[] args) {
		System.out.println(solution("3people   unFollowed me "));
	}

	public static String solution(String s) {
		String answer = "";

		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals("")) {
				sb.append(" ");
			} else {
				sb.append(str[i].substring(0, 1).toUpperCase()).append(str[i].substring(1).toLowerCase()).append(" ");
			}
		}

		if(s.substring(s.length()-1).equals(" ")) {
			sb.append(" ");
		}

		answer = sb.substring(0, sb.length()-1);
		return answer;
	}
}


```