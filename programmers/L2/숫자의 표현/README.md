# 📘 숫자의 표현

## 풀이 방법
- 큰 수 부터 이중for문 돌려서 찾기

## Code

```java
class Solution {
	public int solution(int n) {
		int answer = 0;
		for(int i = n; i > 0; i--){
			int sum = 0;
			for(int j = i; j > 0; j--){
				sum += j;
				if(sum == n){
					answer++;
					break;
				} else if(sum > n){
					break;
				}
			}
		}

		return answer;
	}
}

```