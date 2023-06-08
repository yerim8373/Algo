# 📘 13164 행복 유치원

## 소요시간, 메모리
604ms, 52636KB

## 풀이 방법
- 각 수의 차를 배열에 입력한 후 정렬해서 가장 큰 값 N-K개 빼고 더함

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_13164_행복유치원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            arr[i] = num[i+1] - num[i];
        }

        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < N-K; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }

}
```