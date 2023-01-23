package programmers;

public class L2_다음큰숫자 {

	public static void main(String[] args) {
		System.out.println(solution(78));
	}

	public static int solution(int n) {
		int answer = n;
		int cnt_n = 0;

		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				cnt_n++;
			}
		}

		while(true) {
			int cnt_next = 0;
			answer++;
			String str_next = Integer.toBinaryString(answer);
			for(int i = 0; i < str_next.length(); i++) {
				if(str_next.charAt(i) == '1') {
					cnt_next++;
				}
			}

			if(cnt_n == cnt_next) {
//                System.out.println(cnt_next);
				break;
			}
		}

		return answer;
	}
}
