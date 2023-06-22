# 📘 11497 통나무 건너뛰기

## 소요시간, 메모리
548ms, 47332KB

## 풀이 방법
- 그리디
- 배열 정렬 후 가운데부터 양쪽으로 하나씩 넣어주면 최소값이 됨

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver1_11497_통나무건너뛰기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int result = 0;

            // 2 4 5 7 9
            // 7 4 2 5 9
            for (int i = 2; i < N; i++) {
                result = Math.max(result, arr[i] - arr[i-2]);
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

}
```