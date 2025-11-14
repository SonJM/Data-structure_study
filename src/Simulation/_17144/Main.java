package Simulation._17144;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static Point cleaner = null;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(cleaner == null && num == -1) {
					cleaner = new Point(j, i);
				}
			}
		}

		while(T-- > 0) {
			// 미세먼지 확장
			spread(map);
			// 공기청정기 작동
			// 공치 청정기 위치 map[cleaner.y][cleaner.x], map[cleaner.y+1][cleaner.x]
			// 위치는 위 아래로 최소 2공간이 존재하기 때문에 IndexBound Error는 고려하지 않아도 됨.
			clean(map, cleaner.y, true);
			clean(map, cleaner.y+1, false);
		}
		System.out.println(result(map));
	}

	/**
	 * 공기청정기를 동작시킵니다.
	 *
	 * @param map        미세먼지 맵
	 * @param cleanerRow 현재 동작시킬 공기청정기의 행 (y 좌표)
	 * @param isTop      true면 위쪽(반시계), false면 아래쪽(시계)
	 */
	private static void clean(int[][] map, int cleanerRow, boolean isTop) {
		if (isTop) {
			for (int r=cleanerRow-1; r>0; r--) {
				map[r][0] = map[r - 1][0];
			}
			for (int c=0; c<C-1; c++) {
				map[0][c] = map[0][c+1];
			}
			for (int r=0; r<cleanerRow; r++) {
				map[r][C-1] = map[r+1][C-1];
			}
			for (int c=C-1; c>1; c--) {
				map[cleanerRow][c] = map[cleanerRow][c-1];
			}
		} else {
			for (int r=cleanerRow+1; r<R-1; r++) {
				map[r][0] = map[r + 1][0];
			}
			for (int c=0; c<C-1; c++) {
				map[R-1][c] = map[R-1][c+1];
			}
			for (int r=R-1; r>cleanerRow; r--) {
				map[r][C-1] = map[r-1][C-1];
			}
			for (int c=C-1; c>1; c--) {
				map[cleanerRow][c] = map[cleanerRow][c-1];
			}
		}
		map[cleanerRow][1] = 0;
	}

	/**
	 * 미세먼지 확장 메소드
	 * 새로운 Map 을 만들어 한번에 먼지가 확산할 수 있도록 한다
	 */
	private static void spread(int[][] map) {
		int[][] tmpMap = new int[R][C];
		int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					int count = 0;
					for(int k=0; k<4; k++) {
						int newX = j+direct[k][1];
						int newY = i+direct[k][0];
						if(newX >= 0 && newX < C && newY >= 0 && newY < R && map[newY][newX] != -1) {
							tmpMap[newY][newX] += map[i][j] / 5;
							count++;
						}
					}
					map[i][j] = map[i][j] - ((map[i][j] / 5) * count);
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] += tmpMap[i][j];
			}
		}
	}

	/**
	 * Map에 남아 있는 모든 미세먼지의 총합을 계산하는 메소드
	 * @return 남아있는 미세먼지의 수
	 */
	private static int result(int[][] map) {
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		return result;
	}
}
