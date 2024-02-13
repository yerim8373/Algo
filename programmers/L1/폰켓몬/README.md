# 📘 폰켓몬

## 풀이 방법
- set으로 중복 제거하고 갯수 센 후
  - N/2 보다 크면 N/2로 바꾸기

## Code

```java
import java.util.*;
import java.io.*;

class Solution {
	public int solution(int[] nums) {
		int answer = 0;

		Set<Integer> checkNum = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(!checkNum.contains(nums[i])){
				checkNum.add(nums[i]);
				answer++;
			}
		}

		if(answer > nums.length / 2){
			answer = nums.length / 2;
		}

		return answer;
	}
}
```