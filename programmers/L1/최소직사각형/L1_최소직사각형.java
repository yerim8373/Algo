package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1_최소직사각형 {
	class Solution {
		public int solution(int[][] sizes) {
			int answer = 0;

			int r = 0, c = 0;
			for(int i = 0; i < sizes.length; i++){
				if(sizes[i][0] < sizes[i][1]){
					int tmp = sizes[i][0];
					sizes[i][0] = sizes[i][1];
					sizes[i][1] = tmp;
				}
				r = Math.max(r, sizes[i][0]);
				c = Math.max(c, sizes[i][1]);
			}

			answer = r * c;

			return answer;
		}
	}
}
