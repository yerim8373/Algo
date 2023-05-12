# 📘 20006 랭킹전 대기열

## 소요시간, 메모리
160ms, 16140KB

## 풀이 방법
- 이중 arraylist 만들어서 구현
- 처음에 한 팀에 최고,최저 차이가 10이내인 줄 알았음
- 문제 잘 읽어보기..!

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_20006_랭킹전대기열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Player>> list = new ArrayList<>();

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();

			boolean chk = false;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).size() < m) {
					int tmp = list.get(j).get(0).l;
					if(tmp-10 <= l && tmp+10 >= l) {
						list.get(j).add(new Player(l, n));
						chk = true;
						break;
					}
				}
			}

			if(!chk) {
				list.add(new ArrayList<>());
				list.get(list.size()-1).add(new Player(l, n));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).size() == m) {
				sb.append("Started!\n");
			} else {
				sb.append("Waiting!\n");
			}

			Collections.sort(list.get(i));
			for (int j = 0; j < list.get(i).size(); j++) {
				Player c = list.get(i).get(j);
				sb.append(c.l+ " ").append(c.n + "\n");
			}
		}

		System.out.println(sb);
	}

	static class Player implements Comparable<Player>{
		int l;
		String n;

		public Player(int l, String n) {
			this.l = l;
			this.n = n;
		}

		public int compareTo(Player o) {
			return this.n.compareTo(o.n);
		}
	}
}
```