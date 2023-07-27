# 📘 10844 쉬운 계단 수

## 소요시간, 메모리
132ms, 14192KB

## 풀이 방법
- 처음에는 맨앞에 0,1,2 순서로 생각하다가 규칙 발견 못함
- 맨뒷자리가 0,1,2 인거로 바꿔서 써보니까
- 0일때 [i-1][j+1], 9일때 [i-1][j-1], 나머지 [i-1][j-1] + [i-1][j+1]

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class silver1_10844_쉬운계단수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1];
                } else if(j == 9){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[N][i]) % 1000000000;
        }
        System.out.println(result);
    }
}
```