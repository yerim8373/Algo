# 📘 바이러스

## 풀이 방법
- 처음에 pow() 사용했다가 제약조건보면 int형으로 안되고 long으로 해야함
- N만큼 for문 돌려서 구함

## Code

```java
package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class L2_바이러스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            K = (K*P)%1000000007;
        }
        System.out.println(K);
    }

}

```