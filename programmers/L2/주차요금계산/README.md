# 📘 주차 요금 계산

## 풀이 방법
- 입차한 차, 누적 시간, 차번호 따로 받음
- 출차할 때 맵에서 꺼내서 계산
- 올림함수 -> Math.ceil()

## Code

```java
package programmers;

import java.util.*;

public class L2_주차요금계산 {

	public static void main(String[] args) {
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};
		System.out.println(Arrays.toString(solution(fees, records)));
	}

	public static int[] solution(int[] fees, String[] records) {
		int[] answer = {};

		Map<String, Integer> in = new HashMap<String, Integer>(); // 입차된 차량
		Map<String, Integer> time = new HashMap<String, Integer>(); // 누적 주차시간
		List<String> car = new ArrayList<>(); // 차량번호
		for (int i = 0; i < records.length; i++) {
			StringTokenizer st = new StringTokenizer(records[i]);
			String t = st.nextToken();
			int h = Integer.parseInt(t.substring(0, 2));
			int m = Integer.parseInt(t.substring(3));
			int minute = (h * 60) + m; // 주차시간
			String num = st.nextToken();
			String inout = st.nextToken();

			if(inout.equals("OUT")) {
				int tt = minute - in.remove(num);
				// 누적 주차시간에 존재하면 기존꺼에서 ++
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

			// 출차안된 차들 계산
			if(in.containsKey(car.get(i))) {
				tt += ((23*60)+59) - in.get(car.get(i));
			}

			// 요금계산
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