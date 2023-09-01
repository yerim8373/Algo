# 📘 2512 예산

## 소요시간, 메모리
160ms, 15324KB

## 풀이 방법
- 이분탐색
- 처음에는 이분탐색하면 시간초과날 것 같아서 M/N해서 차이값으로 계산하는 방식으로 함
- 틀려서 이분탐색으로 바꿈
- 처음에 start 값을 배열에서 제일 작은 수로 놓고 함...
- 제일 작은 수도 예산을 초과할 수 있음...!!! 따라서 0부터 시작함

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class silver2_2512_예산 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = 0, end = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        while(start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                if(mid < arr[i]) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if(sum > M) {
                end = mid-1;
            } else if(sum < M){
                start = mid+1;
            } else {
                break;
            }
        }

        System.out.println((start+end)/2);
    }
}
```