# 📘 나무박멸

## 소요시간, 메모리
142ms, 11MB

## 풀이 방법
- 구현
- 제초제 year를 증가시킨 후에 새로운 제초제를 뿌려야했는데
- 새로운 제초제를 먼저 뿌리고 year를 증가시켜서 새로운 제초제도 같이 증가됐었음 ㅠㅠㅠ

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
    // 0 : 인접, 1 : 대각
    static int[][] dr = {{-1, 0, 0, 1}, {-1, -1, 1, 1}};
    static int[][] dc = {{0, -1, 1, 0}, {-1, 1, -1, 1}};
    static int N, K, C, result = 0;
    static int[][] map, mediMap;
    static int[] maxTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        mediMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 빈 칸 : 0, 벽 : -1, 제초제 : -2
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < m; t++) {
            grow_up();
            breeding();
            select_loc();
            sprinkle();
        }

        System.out.println(result);
    }

    private static void sprinkle() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 1이면 제초제 첨 뿌려진거니까 더해야되는데 제초제있던곳에 또 뿌려지는 경우도 있네 ..
                // 제초제가 있는 곳이면 지도에 -2로 되어있으면 그냥 넘어가고 안되어있으면 result +=
                if(mediMap[r][c] > 0){
                    if(mediMap[r][c] == C) {
                        // year 끝나면 빈칸으로
                        mediMap[r][c] = 0;
                        map[r][c] = 0;
                    } else {
                        mediMap[r][c]++;
                    }
                }
            }
        }


        // 제초제 위치 저장
        if(maxTree[0] != -1) {
            mediMap[maxTree[0]][maxTree[1]] = 1;
            result += map[maxTree[0]][maxTree[1]];
            map[maxTree[0]][maxTree[1]] = -2;
            for (int d = 0; d < dr[1].length; d++) {
                for (int k = 1; k <= K; k++) {
                    int nr = maxTree[0] + dr[1][d] * k;
                    int nc = maxTree[1] + dc[1][d] * k;
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        //  벽있으면 추가안하고, 빈칸이면 추가함
                        if (map[nr][nc] == -1) {
                            break;
                        }
                        result += map[nr][nc] > 0 ? map[nr][nc] : 0;
                        mediMap[nr][nc] = 1;
                        // 빈칸, 제초제이면 그만
                        if (map[nr][nc] <= 0) {
                            map[nr][nc] = -2;
                            break;
                        }
                        map[nr][nc] = -2;
                    }
                }
            }
        }
    }

    private static void select_loc() {
        maxTree = new int[] {-1, -1, -1}; // r, c, sum
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 나무가 있는 칸
                if (map[r][c] > 0 ){
                    int sum = map[r][c];
                    // 대각 탐색
                    for (int d = 0; d < dr[1].length; d++) {
                        for (int k = 1; k <= K; k++) {
                            int nr = r + dr[1][d] * k;
                            int nc = c + dc[1][d] * k;
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                // 멍청 ........ -1이 자꾸 더해진듯
                                sum += map[nr][nc] > 0 ? map[nr][nc] : 0;
                                // 빈칸, 벽이면 그만
                                if (map[nr][nc] <= 0) {
                                    break;
                                }
                            }
                        }
                    }
                    //  합이 크면 최댓값 갱신
                    if (maxTree[2] < sum){
                        maxTree[0] = r;
                        maxTree[1] = c;
                        maxTree[2] = sum;
                    }
                }
            }
        }
    }

    private static void breeding() {
        // 맵 복사 해야함
        int[][] tmpMap = new int[N][N];

        // 맵 복사
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                tmpMap[r][c] = map[r][c];
            }
        }

        // 번식
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 나무가 있으면 주변 탐색
                if(tmpMap[r][c] > 0){
                    int cnt = 0; // 번식 가능 칸 개수
                    for (int d = 0; d < dr[0].length; d++) {
                        int nr = r + dr[0][d];
                        int nc = c + dc[0][d];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N && tmpMap[nr][nc] == 0){
                            cnt++;
                        }
                    }

                    if(cnt == 0){
                        continue;
                    }
                    // 번식하기
                    int breed = tmpMap[r][c] / cnt;
                    for (int d = 0; d < dr[0].length; d++) {
                        int nr = r + dr[0][d];
                        int nc = c + dc[0][d];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N && tmpMap[nr][nc] == 0){
                            map[nr][nc] += breed;
                        }
                    }
                }
            }
        }
    }

    private static void grow_up() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // r,c 칸에 나무 있으면 주변 칸 확인해서 더해주기
                if (map[r][c] > 0){
                    for (int d = 0; d < dr[0].length; d++) {
                        int nr = r + dr[0][d];
                        int nc = c + dc[0][d];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > 0){
                            map[r][c]++;
                        }
                    }
                }
            }
        }
    }
}
```