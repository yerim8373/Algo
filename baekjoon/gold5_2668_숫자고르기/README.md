# 📘 2668 숫자고르기

## 소요시간, 메모리
148ms, 15736KB

## 풀이 방법
- 그리디 방식으로 조합만들어서 비교하면 100!이니까 시간초과
- 그림그려서 이어보니까 사이클 형성되는 수 갯수 구하면 됨
- dfs 돌려서 사이클 갯수 구함
- 사이클 구하는거 약간 헷갈렸음.. 문제 더 풀어봐야할듯❕

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class gold5_2668_숫자고르기 {
    static int N;
    static int[] adjList;
    static boolean[] visit;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        adjList = new int[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = Integer.parseInt(br.readLine());
        }

        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        sb.append(result.size()+"\n");
        for (int i : result) {
            sb.append(i+"\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int start) {
        if(adjList[cur] == start){
            result.add(start);
            return;
        }

        if(!visit[adjList[cur]]){
            visit[adjList[cur]] = true;
            dfs(adjList[cur], start);
            visit[adjList[cur]] = false;
        }
    }
}
```