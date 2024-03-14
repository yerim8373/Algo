package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class gold3_왕실의기사대결 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int L, N, Q;
	static int[] power, result_power;
	static int[][] map, knight;
	static ArrayList<int[]>[] location;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map = new int[L+1][L+1];
		for (int r = 1; r <= L; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= L; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		location = new ArrayList[N+1];
		knight = new int[L+1][L+1];
		power = new int[N+1];
		result_power = new int[N+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			location[i+1] = new ArrayList<>();
			
			for (int m = 0; m < h; m++) {
				for (int n = 0; n < w; n++) {
					knight[r+m][c+n] = i+1;
					location[i+1].add(new int[] {r+m, c+n});
				}
			}
			
			power[i+1] = result_power[i+1] = k;
		}
		
		
		for (int command = 0; command < Q; command++) {
			print();
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// 기사 이동 가능한지 확인
			if(result_power[i] == 0) continue;
			ArrayList<Integer> moveList = move_knight(i, d);
			
//			System.out.println(moveList);
			
			if(moveList == null) {
//				System.out.println("nulllll");
				continue;
			} else { // 이동 가능한 기사 있으면
				battle_damage(moveList, d);
			}
			
		}
		
		int result = 0;
		for (int i = 1; i < power.length; i++) {
			if(result_power[i] <= 0) continue;
			result += power[i] - result_power[i];
		}
		
		System.out.println(result);
		
	}


	private static void battle_damage(ArrayList<Integer> moveList, int d) {
//		ArrayList<int[]>[] tmp_loc = new ArrayList[N+1];
		
		// 명령받은 기사
		int cnt = location[moveList.get(0)].size();
		for (int i = 0; i < cnt; i++) {
			int[] cur = location[moveList.get(0)].remove(0);
			knight[cur[0]][cur[1]] = 0;
			int nr = cur[0] + dr[d];
			int nc = cur[1] + dc[d];
			// 어차피 이동 가능한 애들이라 범위체크 안해줘도됨
			// 옮긴 좌표 저장
			location[moveList.get(0)].add(new int[] {nr, nc});
		}
		
		// 밀려난 기사
		for (int i = 1; i < moveList.size(); i++) {
			// i 자리 옮겨주면서 데미지도 계산
			cnt = location[moveList.get(i)].size();
			for(int j = 0; j < cnt; j++) {
				int[] cur = location[moveList.get(i)].remove(0);
//				knight[cur[0]][cur[1]] = 0;
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				// 이동할 때 함정있으면 power 변경
				if(map[nr][nc] == 1) {
					result_power[moveList.get(i)] -= 1;
				}
				
				// 죽었으면 걍 넘어가
				if(result_power[moveList.get(i)] != 0) {
					// 옮긴 좌표 저장
					location[moveList.get(i)].add(new int[] {nr, nc});
				}
			}
		}
		
		// 맵 다시 등록
		knight = new int[L+1][L+1];
		for (int i = 1; i < location.length; i++) {
			for (int j = 0; j < location[i].size(); j++) {
				knight[location[i].get(j)[0]][location[i].get(j)[1]] = i;
			}
		}
	}


	private static ArrayList<Integer> move_knight(int i, int d) {
		// movelist 리턴해주기 -> 벽때문에 못옮기면 null 리턴
		ArrayList<Integer> moveList = new ArrayList<>();
		moveList.add(i);
		// 이동하는 기사 확인하면서 벽이랑 안부딪히는지도 확인
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
//		boolean[] visit = new boolean[N+1];
//		visit[i] = true;
		
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int j = 0; j < location[cur].size(); j++) {
				int nr = location[cur].get(j)[0] + dr[d];
				int nc = location[cur].get(j)[1] + dc[d];
				if(check(nr, nc) && map[nr][nc] != 2) {
					// power도 확인해줘야함~!!!!!!!!!
					if(!moveList.contains(knight[nr][nc]) && result_power[knight[nr][nc]] != 0) {
//						visit[knight[nr][nc]] = true;
						moveList.add(knight[nr][nc]);
						queue.offer(knight[nr][nc]);
					}
				} else { // 범위 밖이면 걍 return
					return null;
				}
			}
		}
		
		return moveList;
	}


	private static void print() {
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= L; j++) {
				System.out.print(knight[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("========================");
	}

	private static boolean check(int nr, int nc) {
		if(0 < nr && nr <= L && 0 < nc && nc <= L) {
			return true;
		}
		return false;
	}
}
