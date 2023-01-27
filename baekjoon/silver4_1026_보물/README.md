# 📘 1026 보물

## 소요시간, 메모리
124ms, 14284KB

## 풀이 방법
- 최소값이 나와야하니까 A, B 배열 정렬해준 후 A는 앞에서 B는 뒤에서부터 곱해서 합

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver4_1026_보물 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length; i++) {
            sum += A[i] * B[B.length-i-1];
        }

        System.out.println(sum);
    }

}


```