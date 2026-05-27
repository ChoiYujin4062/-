package baekjoon;

import java.io.*;
import java.util.*;

public class Main{
	static int ROW, COL;
	static int[][] field;
	static boolean[][] visited;
	
	public static int Solution(int k) {
		int answer = 0;
		
		visited = new boolean[ROW][COL];
		for(int i=0; i<ROW; ++i) {
			for(int j=0; j<COL; ++j) {
				if(field[i][j] == 1 && !visited[i][j]) {
					++answer;
					DFS(i, j);
				}
			}
		}
		return answer;
	}
	
	static void DFS(int row, int col) {
		if(field[row][col] != 1 || visited[row][col]) return;
		else visited[row][col] = true;
		if(row > 0) DFS(row-1, col);
		if(col > 0) DFS(row, col-1);
		if(row < ROW-1) DFS(row+1, col);
		if(col < COL-1) DFS(row, col+1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int T = Integer.parseInt(tokenizer.nextToken());
		for(int i=0; i<T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			COL = Integer.parseInt(tokenizer.nextToken()); // M
			ROW = Integer.parseInt(tokenizer.nextToken()); // N
			int K = Integer.parseInt(tokenizer.nextToken());
			field = new int[ROW][COL];
			for(int j=0; j<K; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokenizer.nextToken());
				int y = Integer.parseInt(tokenizer.nextToken());
				field[ROW-1-y][x] = 1;
			}
			writer.write(Solution(K) + "\n");
		}
		writer.flush();
	}
}
