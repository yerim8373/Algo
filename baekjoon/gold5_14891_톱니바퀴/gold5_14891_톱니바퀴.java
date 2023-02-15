package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_14891_톱니바퀴 {
	static List<Integer>[] list;
	static int[] twenty;
	static int[] dir;
	static int K, result=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new List[4];
		twenty = new int[4];

		for (int i = 0; i < 4; i++) {
			list[i] = new ArrayList<>();
			twenty[i] = 0;
		}

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				list[i].add(str.charAt(j) - '0');
			}
		}

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			dir = new int[4];
			save_dir(num - 1, direction);
			rotation();
		}
		
		result += list[0].get(twenty[0]) == 0 ? 0 : 1;
		result += list[1].get(twenty[1]) == 0 ? 0 : 2;
		result += list[2].get(twenty[2]) == 0 ? 0 : 4;
		result += list[3].get(twenty[3]) == 0 ? 0 : 8;
		System.out.println(result);
	}

	private static void rotation() {
		for (int i = 0; i < dir.length; i++) {
			switch(dir[i]) {
			case 0:
				break;
			case -1:
				twenty[i] = (twenty[i]+1)%8;
//				System.out.println(twenty[i]);
				break;
			case 1:
				twenty[i] = (twenty[i]+7)%8;
//				System.out.println(twenty[i]);
				break;
			} 
		}
	}

	private static void save_dir(int num, int direction) {
		dir[num] = direction;
		int cur = num;
		
		while(cur != 0) {
			if(list[cur].get((twenty[cur] + 6) % 8) != list[cur-1].get((twenty[cur - 1] + 2) % 8)) {
				dir[cur-1] = dir[cur] == 1 ? -1 : 1;
			} else {
				break;
			}
			cur--;
		}
		cur = num;
		
		while(cur!=3) {
			if(list[cur].get((twenty[cur] + 2) % 8) != list[cur+1].get((twenty[cur + 1] + 6) % 8)) {
				dir[cur+1] = dir[cur] == 1 ? -1 : 1;
			} else {
				break;
			}
			cur++;
		}
	}
}