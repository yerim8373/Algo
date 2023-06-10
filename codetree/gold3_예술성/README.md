# 📘 예술성

## 소요시간, 메모리
131ms, 16MB

## 풀이 방법
- 구현
- 처음에 한칸씩 이동하는거로 이해하고 풀어서 시간낭비함
- 문제를 제대로 파악합시다 ㅠㅠ

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, result = 0;
    static int[][] map, group, tmpMap;
    static boolean[][] visit;
    static ArrayList<int[]> group_info; // 그룹 숫자 값, 그룹 칸 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 예술 점수 계산
        score_cal();
        for (int t = 0; t < 3; t++) {
            // 회전
            rotation();
            // 예술 점수 계산
            score_cal();
        }

        System.out.println(result);
    }

    private static void rotation() {
        // 맵 복사해서 옮기자 ㅠㅠ
        tmpMap = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                tmpMap[r][c] = map[r][c];
            }
        }

        // 십자 회전
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 세로줄이면 i,j -> j,i
                if (j == n / 2) {
                    map[j][i] = tmpMap[i][j];
                }
                // 가로줄은 i,j -> n-1-j,i
                if (i == n / 2) {
                    map[n - 1 - j][i] = tmpMap[i][j];
                }
            }
        }

        // 1영역
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                map[j][n / 2 - 1 - i] = tmpMap[i][j];
            }
        }

        // 2영역
        for (int i = 0; i < n/2; i++) {
            for (int j = n/2+1; j < n; j++) {
                map[j-n/2-1][n-1-i] = tmpMap[i][j];
            }
        }

        // 3영역
        for (int i = n/2+1; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                map[j+n/2+1][n-1-i] = tmpMap[i][j];
            }
        }

        // 4영역
        for (int i = n/2+1; i < n; i++) {
            for (int j = n/2+1; j < n; j++) {
                map[j][n+n/2-i] = tmpMap[i][j];
            }
        }
    }

    private static void score_cal() {
        // 그룹 map, 그룹 갯수
        group = new int[n][n];
        int group_no = 0;
        group_info = new ArrayList<>();

        // bfs 2번 돌려야할듯?
        // 그룹화하기
        visit = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visit[r][c]) {
                    int group_cnt = grouping(r, c, group_no);
                    group_no++;
                    group_info.add(new int[]{map[r][c], group_cnt});
                }
            }
        }

        // 만든 그룹의 맞닿아있는 변의 수 카운트
        // 맞닿아있는 수마다 다름 ... 걍 조합 돌리자
        int[][] edge = new int[group_no][group_no];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int d = 0; d < dr.length; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    // 그룹 번호가 다를 때 ++
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && group[r][c] != group[nr][nc]) {
                        edge[group[r][c]][group[nr][nc]]++;
                    }
                }
            }
        }

        // 예술점수 : 조화로움 다 더한거
        // 조화로움 : (a 칸수 + b 칸수) * a 숫자값 * b 숫자값 * a,b가 맞닿아있는 변의 수
        visit = new boolean[group_no][group_no];
        for (int a = 0; a < group_no; a++) {
            for (int b = 0; b < group_no; b++) {
                // 1, 2 && 2, 1 둘 다 안한 경우
                if (!visit[a][b] && !visit[b][a] && edge[a][b] > 0) {
                    visit[a][b] = visit[b][a] = true;
                    result += (group_info.get(a)[1] + group_info.get(b)[1]) * group_info.get(a)[0] * group_info.get(b)[0] * edge[a][b];
                }
            }
        }
    }

    private static int grouping(int r, int c, int group_no) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visit[r][c] = true;
        int cnt = 1;
        group[r][c] = group_no;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] == map[r][c]) {
                    visit[nr][nc] = true;
                    group[nr][nc] = group_no;
                    cnt++;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return cnt;
    }
}
```