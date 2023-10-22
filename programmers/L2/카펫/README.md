# 📘 카펫

## 풀이 방법
- 1부터 yellow의 제곱근까지 탐색하면서 yellow가 0으로 나눠지면
- (r * 2) + ((c + 2) * 2)의 식으로 brown 칸 수 세서
- 맞을 때까지 탐색

## Code

```java
class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		for(int i = 1; i <= Math.sqrt(yellow); i++){
			if(yellow%i == 0){
				int c = yellow / i;
				int sum = (i * 2) + ((c + 2) * 2);
				if(sum == brown){
					answer[0] = c + 2;
					answer[1] = i + 2;
					break;
				}
			}
		}

		return answer;
	}
}
```