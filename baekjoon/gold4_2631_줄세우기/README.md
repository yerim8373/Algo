# 📘 2631 줄세우기

## 소요시간, 메모리
128ms, 14120KB

## 풀이 방법
- LIS (최장 증가 부분 수열)
- LIS를 구하는 방법이 세가지정도 있는데, 
- 여기서 dp로 푼 방식은 시간복잡도가 O(n^2)임
- LIS 구하는 다른 방법도 공부해야겠음 -> 이분탐색 사용한 방식의 시간복잡도 : O(nlogn)

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class gold4_2631_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 1;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(N-result);
    }
}
```