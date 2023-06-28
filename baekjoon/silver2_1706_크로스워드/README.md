# 📘 1706 크로스워드

## 소요시간, 메모리
164ms, 16200KB

## 풀이 방법
- 가로, 세로 다 탐색하면서 문자열을 만들어줌
- 문자열 길이가 2이상이면 priority queue에 넣어서 문자열을 정렬해줌
- 마지막에 pq에서 하나 빼주었는데..
- 어차피 하나의 값만 필요하니까 조건에 맞으면 문자열 체크해주는게 메모리 측면에서 더 효율적이지 않을까?!
- 문자열 비교 compareTo > 0 으로 해주기, 문자열 조합하는거 sb로 한 사람도 잇도라 ~

## Code

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        PriorityQueue<String> pq = new PriorityQueue<String>();

        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            String word = "";
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < R; r++) {
            String word = "";
            for (int c = 0; c <= C; c++) {
                if(c == C || map[r][c] == '#') {
                    if(word.length() > 1) {
                        pq.offer(word);
                    }
                    word = "";
                } else {
                    word += map[r][c];
                }
            }
        }

        for (int c = 0; c < C; c++) {
            String word = "";
            for (int r = 0; r <= R; r++) {
                if(r == R || map[r][c] == '#') {
                    if(word.length() > 1) {
                        pq.offer(word);
                    }
                    word = "";
                } else {
                    word += map[r][c];
                }
            }
        }

        System.out.println(pq.poll());
    }

}
```