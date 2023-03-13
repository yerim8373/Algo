# 📘 구명보트

## 풀이 방법
- greedy
- 배열 정렬 후 min, max 값을 두고 끝에서부터 비교하여
- min 값과 더해서 limit보다 작거나 같으면 answer++, min도 ++
- 더한 값이 크면 max 혼자 타야하니까 answer++하고 min은 그대로

## Code

```java
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int min = 0;
        int max = people.length-1;

        // 최댓값을 줄여가면서 체크
        for (int i = people.length-1; i >= min; i--) {
            // 제한보다 작거나 같을 떄
            if(people[min] + people[i] <= limit) {
                answer++;
                min++;
            } else { // 클 때
                answer++;
            }
        }

        return answer;
    }
}

```