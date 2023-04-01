# 📘 2304 창고 다각형

## 소요시간, 메모리
152ms, 14624KB

## 풀이 방법
- 꼭대기 따로 구해서 앞에서부터 꼭대기까지 탐색한 후
- 반복문 빠져나와서 꼭대기 넓이 따로 더해준 후에
- 뒤에서부터 꼭대기까지 다시 탐색
- 😂 꼭대기 값 구할때 같은 최댓값이 여러개면 L이 더 큰값으로 저장하기 <- 이거땜에 계속 틀림

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver2_2304_창고다각형 {
	static List<Bar> list = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		Bar max = new Bar(0, 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if(H > max.H) {
				max.H = H; max.L = L;
			} else if(H == max.H) {
				if(L > max.L) {
					max.H = H; max.L = L;
				}
			}
			list.add(new Bar(L, H));
		}

		Collections.sort(list);

		int top = 0;
		Bar tmp = list.get(0);
		// 앞에서부터
		for (int i = 1; i < list.size(); i++) {
			Bar cur = list.get(i);

			// 앞에꺼보다 높으면 넓이 계산해서 더해주기
			if(cur.H > tmp.H) {
				result += (cur.L - tmp.L) * tmp.H;
				tmp = cur;
				//				System.out.println(result);
			}
			if(cur.L == max.L) {
				top = i;
				break;
			}
		}
		// 꼭대기에 도달하면 더해주기..
		Bar cur = list.get(top);
		//		System.out.println(cur.L + " " + cur.H);
		result += (cur.L+1 - tmp.L) * cur.H;
		//		System.out.println(result);
		//		System.out.println("======");

		tmp = list.get(list.size()-1);
		// 뒤에서부터
		for (int i = list.size()-2; i >= top; i--) {
			cur = list.get(i);

			// 뒤에꺼보다 높으면 넓이 계산해서 ㄷㅓ해주기
			if(cur.H > tmp.H) {
				result += ((tmp.L+1) - (cur.L+1)) * tmp.H;
				tmp = cur;
				//				System.out.println(result);
			}
		}
		System.out.println(result);
	}

	static class Bar implements Comparable<Bar>{
		int L, H;
		public Bar(int L, int H) {
			this.L = L;
			this.H = H;
		}

		public int compareTo(Bar o) {
			return Integer.compare(this.L, o.L);
		}
	}
}

```