# 📘 가장 긴 팰린드롬

## 풀이 방법
- 가장 긴 문자열부터 검사
- palindrome(s, j, j+i-1)에서 j는 시작, j+i-1은 마지막

## Code

```java
package programmers;

public class L3_가장긴팰린드롬 {
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution("abacde"));
	}
	public static int solution(String s)
	{
		// 가장 긴 것부터 검사
		for (int i = s.length(); i > 0; i--) {
			// 시작 문자열
			for (int j = 0; j+i <= s.length(); j++) {
				if(palindrome(s, j, j+i-1)) {
					return i;
				}
			}
		}

		return 0;
	}
	private static boolean palindrome(String s, int first, int last) {
		while(first <= last) {
			// 다르면 false
			if(s.charAt(first++) != s.charAt(last--)) {
				return false;
			}
		}
		return true;
	}
}

```