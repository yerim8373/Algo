# π 1956

## μμμκ°, λ©λͺ¨λ¦¬
728ms, 53296KB

## νμ΄ λ°©λ²
λͺ¨λ  κ°μ  νμν΄ λ λΈλ κ° μ΅μ λΉμ© μΆλ ₯ -> νλ‘μ΄λ μμ

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold4_1956_μ΄λ {

    static int V, E, result;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V+1][V+1];
        result = Integer.MAX_VALUE;

        // μκΈ°μμ  = 0
        for (int r = 1; r < dist.length; r++) {
            for (int c = 1; c < dist[r].length; c++) {
//				if(r != c) -> μκΈ°μμ  maxλ‘ λκ³  κ°±μ 
                dist[r][c] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[s][e] = w;
        }

        // i : μ€κ°, j : μμ, k : λ
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                // μκΈ°μμ  μ μΈ
                if(i == j)
                    continue;
                for (int k = 1; k < dist.length; k++) {
                    if(dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE)
                        continue;
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        // μ¬μ΄ν΄ -> μΆλ°, λμ°© λΈλ κ°μ
        for (int i = 1; i < dist.length; i++) {
            result = Math.min(result, dist[i][i]);
        }

        result = (result == Integer.MAX_VALUE) ? -1 : result;

        System.out.println(result);
    }
}

```