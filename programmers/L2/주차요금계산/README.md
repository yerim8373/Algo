# ๐ ์ฃผ์ฐจ ์๊ธ ๊ณ์ฐ

## ํ์ด ๋ฐฉ๋ฒ
- ์์ฐจํ ์ฐจ, ๋์  ์๊ฐ, ์ฐจ๋ฒํธ ๋ฐ๋ก ๋ฐ์
- ์ถ์ฐจํ  ๋ ๋งต์์ ๊บผ๋ด์ ๊ณ์ฐ
- ์ฌ๋ฆผํจ์ -> Math.ceil()

## Code

```java
package programmers;

import java.util.*;

public class L2_์ฃผ์ฐจ์๊ธ๊ณ์ฐ {

	public static void main(String[] args) {
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};
		System.out.println(Arrays.toString(solution(fees, records)));
	}

	public static int[] solution(int[] fees, String[] records) {
		int[] answer = {};

		Map<String, Integer> in = new HashMap<String, Integer>(); // ์์ฐจ๋ ์ฐจ๋
		Map<String, Integer> time = new HashMap<String, Integer>(); // ๋์  ์ฃผ์ฐจ์๊ฐ
		List<String> car = new ArrayList<>(); // ์ฐจ๋๋ฒํธ
		for (int i = 0; i < records.length; i++) {
			StringTokenizer st = new StringTokenizer(records[i]);
			String t = st.nextToken();
			int h = Integer.parseInt(t.substring(0, 2));
			int m = Integer.parseInt(t.substring(3));
			int minute = (h * 60) + m; // ์ฃผ์ฐจ์๊ฐ
			String num = st.nextToken();
			String inout = st.nextToken();

			if(inout.equals("OUT")) {
				int tt = minute - in.remove(num);
				// ๋์  ์ฃผ์ฐจ์๊ฐ์ ์กด์ฌํ๋ฉด ๊ธฐ์กด๊บผ์์ ++
				if(time.containsKey(num)) {
					time.replace(num, time.get(num)+tt);
				} else {
					time.put(num, tt);
				}
			} else {
				in.put(num, minute);
				if(!car.contains(num))
					car.add(num);
			}
		}

		answer = new int[car.size()];
		Collections.sort(car);
		//        System.out.println(car.toString());

		for (int i = 0; i < answer.length; i++) {
			int tt = 0;
			if(time.containsKey(car.get(i))) {
				tt = time.get(car.get(i));
			}

			// ์ถ์ฐจ์๋ ์ฐจ๋ค ๊ณ์ฐ
			if(in.containsKey(car.get(i))) {
				tt += ((23*60)+59) - in.get(car.get(i));
			}

			// ์๊ธ๊ณ์ฐ
			if(tt-fees[0] < 0) {
				answer[i] = fees[1];
			} else {
				tt -= fees[0];
				answer[i] = fees[1] + (int)(Math.ceil(tt/(fees[2]*1.0)))*fees[3];
			}
		}

		return answer;
	}
}

```