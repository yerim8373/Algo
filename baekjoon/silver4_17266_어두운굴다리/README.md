# 📘 17266 어두운굴다리

## 소요시간, 메모리
292ms, 25120KB

## 풀이 방법
- 두 위치 사이 거리가 최대가 되는 값을 구하면 된다
- 이분탐색으로도 풀어보자!

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver4_17266_어두운굴다리 {

    static int N, M;
    static int[] x;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M];
        st = new StringTokenizer(br.readLine());

        int answer = 0;

        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        answer = Math.max(x[0], N - x[M-1]);
        for (int i = 1; i < M-1; i++) {
            int t;
            if((x[i] - x[i-1]) % 2 == 0)
                t = (x[i] - x[i-1]) / 2;
            else
                t = ((x[i] - x[i-1]) / 2) + 1;
            answer = Math.max(answer, t);
        }

        System.out.println(answer);
    }

}

```