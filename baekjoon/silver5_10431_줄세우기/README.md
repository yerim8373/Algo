# 📘 10431 줄세우기

## 소요시간, 메모리
192ms, 17324KB

## 풀이 방법
- 구현
- 문제 헷갈리게 설명해줌...

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class silver5_10431_줄세우기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int P = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < P; tc++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            sb.append(t).append(" ");

            int result = 0;
            int[] arr = new int[20];

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                for (int j = 0; j < i; j++) {
                    if(arr[j] > arr[i]) {
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}

```