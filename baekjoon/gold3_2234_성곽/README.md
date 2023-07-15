# 📘 2234 성곽

## 소요시간, 메모리
184ms, 17044KB

## 풀이 방법
- 비트마스킹, bfs
- bfs 돌리면서 비트마스킹으로 다음 칸이 갈 수 있는 칸인지 체크
- 맵 두개를 더 선언해서 하나는 번호, 하나는 넓이를 저장
- 벽 하나를 제거한 후 최대 넓이를 구하는 과정에서 그냥 최대넓이인거 주변 땅을 더해보면 된다고 생각함...
- 다른거 두개를 더할 때 값이 더 커질 수 있음

### 비트마스킹
- (map[r][c] & (1 << d)) == 0)
- & 연산자로 둘 다 1이면 각 자리의 십진수를 더한 값이 출력됨
- 따라서 0일 경우 벽이 없다는 뜻

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold3_2234_성곽 {
    static int[] dr = { 0, -1, 0, 1 }, dc = { -1, 0, 1, 0 };
    static int N, M, idx, result_room = 0, result_area = 0, result_rem = 0;
    static int[][] map, area, no;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        area = new int[M][N];
        no = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!visit[r][c]) {
                    bfs(r, c);
                    result_room++;
                }
            }
        }

        find_rem();

        System.out.println(result_room + "\n" + result_area + "\n" + result_rem);
    }

    private static void find_rem() {
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                for (int d = 0; d < dr.length; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && no[r][c] != no[nr][nc]) {
                        result_rem = Math.max(result_rem, area[r][c] + area[nr][nc]);
                    }
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        queue.offer(new int[] { r, c });
        list.add(new int[] { r, c });
        visit[r][c] = true;
        no[r][c] = result_room;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                // 벽이 없어야함
                // 같은 자리 수가 둘 다 1이면 각 자리의 십진수가 출력됨
                // 하지만 다르면 0이 출력되고 벽이 없다는 뜻
                if ((map[cur[0]][cur[1]] & (1 << d)) == 0) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visit[nr][nc]) {
                        queue.offer(new int[] { nr, nc });
                        list.add(new int[] { nr, nc });
                        count++;
                        visit[nr][nc] = true;
                        no[nr][nc] = result_room;
                    }
                }
            }
        }

        // 넓이 표시
        for (int[] is : list) {
            area[is[0]][is[1]] = count;
        }

        result_area = Math.max(result_area, count);
    }
}
```
