package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class gold5_2866_문자열잘라내기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        int result = 0;
        if(R != 2){
            int left = 0, right = R-1;
            while(left <= right) {
                int mid = (right + left) / 2;

                HashSet<String> set = new HashSet<>();
                for (int c = 0; c < C; c++) {
                    String str = "";
                    for (int r = mid; r < R; r++) {
                        str += map[r][c];
                    }
                    set.add(str);
                }

                if (set.size() == C){
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(result);
    }
}
