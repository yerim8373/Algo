# ๐ 11724

## ์์์๊ฐ, ๋ฉ๋ชจ๋ฆฌ
540ms, 113564KB

## ํ์ด ๋ฐฉ๋ฒ
1. ์ธ์  ํ๋ ฌ๋ก ๊ทธ๋ํ ์ฐ๊ฒฐ
2. ๊ฐ ๋ธ๋ ๋ฐฉ๋ฌธ๋ฐฐ์ด ์ฒดํฌํ์ฌ dfs๋ก ํ์
3. dfs ํ์ ๋๋๊ณ  count ++

โ bfs ๋ก ํ์ด๋ณด๊ธฐใฐโ

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver2_11724_์ฐ๊ฒฐ์์์๊ฐ์ {

    static boolean[][] graph;
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        int u, v, count = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = true;
        }

        for (int i = 1; i <= N; i++) {
            // ๋ฐฉ๋ฌธํ์  ์์ผ๋ฉด ๊ฐฏ์์ธ๊ธฐ
            if(!visit[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i) {
        if(visit[i])
            return;

        // ๋ฐฉ๋ฌธ์ฒ๋ฆฌ
        visit[i] = true;
        // ์ฐ๊ฒฐ๋ ๊ทธ๋ํ ํ์
        for (int j = 1; j <= N; j++) {
            if(graph[i][j]) {
                dfs(j);
            }
        }
    }
}

```