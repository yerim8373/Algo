# 📘 뒤에 있는 큰 수 찾기

## 풀이 방법
- 앞에서부터 탐색하면서 스택이 비어있거나 스택 맨위에 있는 인덱스의 수보다 작아질 때까지 반복
- 스택 맨 위 인덱스의 값이 현재 인덱스 값보다 작으면 스택에서 뺀 인덱스에 현재값 넣기

## Code
```java
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[numbers.length-1] = -1;
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++){
            // 맨위의 수보다 크면 빼서 answer 값 저장
            while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i]){
                answer[stk.pop()] = numbers[i];
            }
            
            stk.push(i);
        }
        
        while(!stk.isEmpty()){
            answer[stk.pop()] = -1;
        }
        // for(int i = 0; i < numbers.length; i++){
        //     if(answer[i] == 0){
        //         answer[i] = -1;
        //     }
        // }
        
        return answer;
    }
}
```
#### 이중 for문 -> 시간초과
```java
class Solution {
	int maxV = 0, maxN;
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		maxV = numbers[numbers.length-1];
		maxN = numbers.length-1;
		answer[numbers.length-1] = -1;

		for(int i = numbers.length-2; i >= 0; i--){
			answer[i] = find(i, numbers);
		}

		return answer;
	}

	public int find(int k, int[] numbers){
		if(numbers[k] >= maxV){
			maxV = numbers[k];
			maxN = k;
			return -1;
		}

		for(int i = k+1; i <= maxN; i++){
			if(numbers[i] > numbers[k]){
				return numbers[i];
			}
		}
		return -1;
	}
}
```