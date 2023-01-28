# 📘 5430 AC

## 소요시간, 메모리
2828ms, 97456KB

## 풀이 방법
- 구현... 조건이 많아서 중간중간 추가하느냐고 애먹움
- 배열이 비었더라고 무조건 error가 아님!

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class gold5_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			boolean e = true;

			String p = br.readLine();
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			String[] arr = new String[N];
			String str = br.readLine();
			arr = str.substring(1, str.length()-1).split(",");

			if(N != 0) {
				for(int i = 0; i < arr.length; i++) {
					list.add(Integer.parseInt(arr[i]));
				}
			}

			int head = 0;

			for (int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'D') {
					if(list.isEmpty()) {
						e = false;
						break;
					} else {
						//						list.remove(head);
						if(head == 0) {
							list.remove(head);
						} else {
							list.remove(head-1);
							head--;
						}
					}
				} else {
					if(i+1 < p.length() && p.charAt(i+1) == 'R') {
						i++;
						continue;
					} else {
						if(head == 0) {
							head = list.size();
						} else {
							head = 0;
						}
					}
				}
			}



			if(e) {
				if(head != 0) {
					Collections.reverse(list);
					//					Collections.sort(list, Collections.reverseOrder());
				}

				sb.append("[");
				if(!list.isEmpty()) {
					for (Integer s : list) {
						sb.append(s).append(",");
					}
					sb.delete(sb.length()-1, sb.length());
				}
				sb.append("]").append("\n");
			} else {
				sb.append("error").append("\n");
			}

		}

		System.out.println(sb);
	}

}

```