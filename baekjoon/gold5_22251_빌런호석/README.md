# 📘 22251 빌런 호석

## 소요시간, 메모리
276ms, 53080KB

## 풀이 방법
- 구현
- 모든 수가 디스플레이에 표현되는 위치를 number 배열에 저장
- 현재 층수를 자릿수에 맞게 배열에 저장
- 1부터 N층까지 탐색하기
- 목표 층수를 자릿수에 맞게 배열에 저장한 후 현재 층수와 몇개 차이나는지 체크하기

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold5_22251_빌런호석 {
    static int[][] number = {{1, 1, 1, 0, 1, 1, 1},
        {0, 0, 1, 0, 0, 1, 0},
        {1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 1, 1},
        {0, 1, 1, 1, 0, 1, 0},
        {1, 1, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1}};
    static int N, K, P, X, result = 0;
    static int[] cur_floor;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // n층
        K = Integer.parseInt(st.nextToken()); // k자리 수
        P = Integer.parseInt(st.nextToken()); // 최소 1개, 최대 P개 반전
        X = Integer.parseInt(st.nextToken()); // 실제 멈춰있는 층수

        // 현재 층수
        int cur = X;
        cur_floor = new int[K];
        for (int i = K-1; i >= 0; i--) {
            cur_floor[i] = cur % 10;
            cur /= 10;
        }

        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            if(checkFloor(i)) result++;
        }

        System.out.println(result);
    }

    private static boolean checkFloor(int target) {
        int cnt = 0;
        int[] target_floor = new int[K];

        // 목표 층 자릿수
        for (int i = K-1; i >= 0; i--) {
            target_floor[i] = target % 10;
            target /= 10;
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if(number[target_floor[i]][j] != number[cur_floor[i]][j]){
                    cnt++;
                }
            }
        }

        if(cnt > P) return false;
        return true;
    }
}
```