package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class silver3_8911_거북이 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String command = br.readLine();
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0; // 1 : 최소, 2 : 최대
            int direction = 0; // 바라보고있는 방향
            int x = 0, y = 0;

            for (int i = 0; i < command.length(); i++) {
                char ch = command.charAt(i);

                switch(ch){
                    case 'F':
                        x += dr[direction];
                        y += dc[direction];
                        x1 = Math.min(x1, x);
                        y1 = Math.min(y1, y);
                        x2 = Math.max(x2, x);
                        y2 = Math.max(y2, y);
                        break;
                    case 'B':
                        x -= dr[direction];
                        y -= dc[direction];
                        x1 = Math.min(x1, x);
                        y1 = Math.min(y1, y);
                        x2 = Math.max(x2, x);
                        y2 = Math.max(y2, y);
                        break;
                    case 'L':
                        direction = (direction + 3) % 4;
                        break;
                    case 'R':
                        direction = (direction + 1) % 4;
                        break;
                }
            }

            if(x1 == x2 || y1 == y2){
                sb.append(0).append("\n");
            } else {
                sb.append((x2-x1)*(y2-y1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
