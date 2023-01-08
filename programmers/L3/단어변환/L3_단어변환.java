package programmers;

public class L3_단어변환 {
	static boolean[] visit;
	static int answer = 51;
	public static void main(String[] args) {
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution("hit", "cog", words));
		
	}
	
	public static int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        
		dfs(begin, target, words, 0);
        
        return answer == 51? 0:answer;
    }

	private static void dfs(String begin, String target, String[] words, int cnt) {
		
		if(begin.equals(target)){
			answer = Math.min(answer, cnt);
			return;
		}
		
		for (int i = 0; i < visit.length; i++) {
			if(!visit[i] && check(begin, words[i])) {
				visit[i] = true;
				dfs(words[i], target, words, cnt++);
				visit[i] = false;
			}
		}
	}

	private static boolean check(String begin, String word) {
		int cnt = 0;
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == begin.charAt(i)) {
				cnt++;
			}
		}
		
		if(cnt == begin.length()-1) {
			return true;
		}
		
		return false;
	}
}
