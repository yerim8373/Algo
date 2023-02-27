# 📘 23971 ZOAC 4

## 소요시간, 메모리
124ms, 14152KB

## 풀이 방법
- 행, 열 앉을 수 있는 수 구해서 곱함

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bronze3_23971_ZOAC4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = ((H-1)/(N+1)+1) * ((W-1)/(M+1)+1);
        System.out.println(result);
    }
}


```