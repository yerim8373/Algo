# 📘 16113

## 소요시간, 메모리
172ms, 18992KB

## 풀이 방법
- N/5를 가로 길이로 해서 맵에 시그널 입력받은 후
- 맨 윗줄을 기준으로 '#'이고 방문하지 않았으면 bfs 탐색
- bfs 돌면서 칸수세고, 칸수별로 숫자 구분해서 출력

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class silver2_16113_시그널 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static boolean[][] map, visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String signal = br.readLine();
        map = new boolean[5][N/5];
        visit = new boolean[5][N/5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N/5; j++) {
                if(signal.charAt((i*N/5)+j) == '#'){
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N/5; i++) {
            if(map[0][i] ){
                /*
                5 -> 1
                7 -> 7
                9 -> 4
                11 -> 2, 3, 5
                12 -> 0, 6, 9
                13 -> 8
                 */
                switch (bfs(i)){
                    case 5:
                        sb.append(1);
                        break;
                    case 7:
                        sb.append(7);
                        break;
                    case 9:
                        sb.append(4);
                        break;
                    case 11:
                        if(map[1][i+2] && map[3][i+2]){
                            sb.append(3);
                        } else if(map[1][i+2] && map[3][i]){
                            sb.append(2);
                        } else{
                            sb.append(5);
                        }
                        break;
                    case 12:
                        if(!map[2][i+1]){
                            sb.append(0);
                        } else if(!map[1][i+2]){
                            sb.append(6);
                        } else {
                            sb.append(9);
                        }
                        break;
                    case 13:
                        sb.append(8);
                        break;
                }
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int i) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, i});
        visit[0][i] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr >= 0 && nr < 5 && nc >= 0 && nc < N/5 && map[nr][nc] && !visit[nr][nc]){
                    queue.offer(new int[] {nr, nc});
                    visit[nr][nc] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
```