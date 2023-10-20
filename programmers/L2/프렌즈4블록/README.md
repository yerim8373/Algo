# 📘 프렌즈4블록

## 풀이 방법
- 맵 탐색하면서 4블록인거 visit에 true 해놓고 갯수세기
- 지워진 블록 갯수 0이면 끝내고, 아니면 visit에 체크한거 '.'으로 바꾸기
- 맨밑에 줄부터 탐색하면서 빈칸나오면 다시 그 위에 탐색하면서 블록나오면 자리 바꿔주면서 블록 내리기

## Code

```java
public class L2_프렌즈4블록 {

    public static void main(String[] args) {
        class Solution {
            boolean check = false;
            boolean[][] visit;
            char[][] map;
            int answer = 0;

            public int solution(int m, int n, String[] board) {
                map = new char[m][n];

                for(int r = 0; r < m; r++){
                    for(int c = 0; c < n; c++){
                        map[r][c] = board[r].charAt(c);
                    }
                }

                // ArrayList<Character>[] map = new ArrayList[n];
                // for(int i = 0; i < n; i++){
                //     map[i] = new ArrayList<>();
                // }

                // for(int r = m-1; r > 0; r--){
                //     for(int c = 0; c < n; c++){
                //         map[r].add(board[m-1-r].charAt(c));
                //     }
                // }


                // 맵 탐색하면서 4개로 된거 지우기 -> 빈칸은 '.'
                // 새로운 맵 생성해서 저장하는 방식으로 ㄱㄱ
                while(!check){
                    checkRem();
                    // print();
                }

                return answer;
            }

            public void checkRem(){
                int cnt = 0;
                visit = new boolean[map.length][map[0].length];

                for(int r = 0; r < map.length - 1; r++){
                    for(int c = 0; c < map[r].length - 1; c++){
                        if(map[r][c] != '.' && map[r][c] == map[r+1][c] && map[r][c] == map[r][c+1] && map[r][c] == map[r+1][c+1]){
                            visit[r][c] = visit[r+1][c] = visit[r][c+1] = visit[r+1][c+1] = true;
                            cnt++;
                        }
                    }
                }

                // 지워진 블록 갯수가 0이면 false
                if(cnt == 0){
                    check = true;
                    return;
                }

                // 체크한거 지우기
                for(int r = 0; r < map.length; r++){
                    for(int c = 0; c < map[r].length; c++){
                        if(visit[r][c]){
                            map[r][c] = '.';
                            answer++;
                        }
                    }
                }

                // 블록 내리기
                for(int c = 0; c < map[0].length; c++){
                    for(int r = map.length - 1; r >= 0; r--){
                        if(map[r][c] == '.'){
                            // 빈칸 나오면 그 위에 살펴보면서 블록있으면 바꿔주기
                            for(int k = r-1; k >= 0; k--){
                                if(map[k][c] != '.'){ // 블록나오면 자리 바꾸기
                                    map[r][c] = map[k][c];
                                    map[k][c] = '.';
                                    break;
                                }
                            }
                        }
                    }
                }

                return ;
            }


            public void print(){
                for(int r = 0; r < map.length; r++){
                    for(int c = 0; c < map[0].length; c++){
                        System.out.println(map[r][c] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

}
```