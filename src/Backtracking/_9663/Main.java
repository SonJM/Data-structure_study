package Backtracking._9663;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// N-Queen - 전형적인 백트래킹 문제
// + 모양과 / \ 모양 처리하는게 조금 피곤한 문제
public class Main {
	static int[][] map;
	static int N, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		NQueen(0, 0);
		System.out.println(result);
	}
	private static void NQueen(int startY, int count) {
		if(count == N) {
			result++;
			return;
		}

		for(int i=0; i<N; i++) {
			Point nxtPoint = new Point(i, startY);
			if(map[nxtPoint.y][nxtPoint.x] == 0) {
				putQueen(nxtPoint);
				NQueen(startY + 1, count + 1);
				rollback(nxtPoint);
			}
		}
	}
	private static void putQueen(Point point) {
		for(int i=0; i<N; i++) {
			map[i][point.x]++;
			map[point.y][i]++;
		}
		for(int i=1; i<N; i++) {
			if(point.x-i >= 0 && point.y-i >= 0) map[point.y-i][point.x-i]++;
			if(point.x+i < N && point.y+i < N) map[point.y+i][point.x+i]++;
			if(point.x-i >= 0 && point.y+i < N) map[point.y+i][point.x-i]++;
			if(point.x+i < N && point.y-i >= 0) map[point.y-i][point.x+i]++;
		}
	}
	private static void rollback(Point point) {
		for(int i=0; i<N; i++) {
			map[i][point.x]--;
			map[point.y][i]--;
		}
		for(int i=1; i<N; i++) {
			if(point.x-i >= 0 && point.y-i >= 0) map[point.y-i][point.x-i]--;
			if(point.x+i < N && point.y+i < N) map[point.y+i][point.x+i]--;
			if(point.x-i >= 0 && point.y+i < N) map[point.y+i][point.x-i]--;
			if(point.x+i < N && point.y-i >= 0) map[point.y-i][point.x+i]--;
		}
	}
}
