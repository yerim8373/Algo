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