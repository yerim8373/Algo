# 📘 5073 삼각형과 세 변

## 소요시간, 메모리
124ms, 14072KB

## 풀이 방법
- 배열에 넣고 정렬해서 조건 처리

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bronze3_5073_삼각형과세번 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1]) {
                sb.append("Invalid\n");
            } else if(arr[0] == arr[1] && arr[0] == arr[2] && arr[1] == arr[2]) {
                sb.append("Equilateral\n");
            } else if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }

        }

        System.out.println(sb);
    }

}

```