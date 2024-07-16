# 📘 연속 펄스 부분 수열의 합

## 풀이 방법
- 처음에는 홀수, 짝수 부분 나눠서 누적합 구하려고 함
- But,,,
- 그냥 [-1, 1, -1, 1], [1, -1, 1, -1] 배열 두개의 누적합 구해서 최댓값 구하면 된다❗❗

## Code

```java
package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class L3_연속펄스부분수열의합 {

    class Solution {
        public long solution(int[] sequence) {
            long answer = 0;

            long[] sumEven = new long[sequence.length];
            long[] sumOdd = new long[sequence.length];

            sumEven[0] = sequence[0];
            sumOdd[0] = sequence[0] * -1;

            answer = Math.max(sequence[0], sequence[0]*-1);

            // 누적합
            for(int i = 1; i < sequence.length; i++){
                long num = i % 2 == 0 ? sequence[i] : sequence[i]*-1;
                sumEven[i] = Math.max(sumEven[i-1] + num, num);
                sumOdd[i] = Math.max(sumOdd[i-1] + num*-1, num*-1);

                answer = Math.max(answer, sumEven[i]);
                answer = Math.max(answer, sumOdd[i]);
            }

            return answer;
        }
    }
}
```