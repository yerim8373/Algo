package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver2_2630_색종이만들기 {
    static int N, white = 0, blue = 0;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];

        for (int r = 0; r < N; r++) { 
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                if(Integer.parseInt(st.nextToken()) == 1){
                    map[r][c] = true;
                }
            }
        }

        recursive(0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    private static void recursive(int r, int c, int n) {
        boolean color = map[r][c], chk = false;

        L:for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if(map[i][j] != color){
                    chk = true;
                    break L;
                }
            }
        }

        if(!chk){
            if(color) blue++;
            else white++;
        } else {
            recursive(r, c, n/2);
            recursive(r + n/2, c, n/2);
            recursive(r, c + n/2, n/2);
            recursive(r + n/2, c + n/2, n/2);
        }
    }
}
