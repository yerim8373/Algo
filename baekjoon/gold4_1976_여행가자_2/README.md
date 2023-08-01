# 📘 1976 여행 가자

## 소요시간, 메모리
332ms, 24740KB

## 풀이 방법
- 입력으로 인접배열 주어짐 (양방향)
- 각 여행 경로마다 bfs 탐색
- bfs 탐색 시 큐에서 꺼낼 때 목적지 나오면 true 리턴하고 다 탐색했는데 목적지 안나오면 false
- end 나오면 큐에 넣지도 않고 바로 리턴해줬는데 왜 안되는지 몰겟음

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class gold4_1976_여행가자 {
    static int N, M;
    static boolean[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1];
        int[] visit = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1){
                    graph[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < M; i++) {
            if(!bfs(visit[i-1], visit[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static boolean bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] v = new boolean[N+1];
        queue.offer(start);
        v[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end){
                return true;
            }

            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] && !v[i]){
                    queue.offer(i);
                    v[i] = true;
                }
            }
        }
        return false;
    }
}
```