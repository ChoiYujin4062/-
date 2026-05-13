package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
	public static int BFS(int[][] maze) {
		int answer = 0;
		
		int ROW = maze.length;
		int COL = maze[0].length;
		
		var visited = new boolean[ROW][COL];
		var queue = new ArrayDeque<int[]>();
		queue.add(new int[] {0,0,1});
		
		while(queue.size() > 0) {
			int[] temp = queue.remove();
			int r = temp[0], c = temp[1], distance = temp[2];
			if(maze[r][c] == 0) continue;
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			if(r == ROW-1 && c == COL-1) answer = distance;
			if(r > 0) queue.add(new int[] {r-1, c, distance+1});
			if(c > 0) queue.add(new int[] {r, c-1, distance+1});
			if(r < ROW-1) queue.add(new int[] {r+1, c, distance+1});
			if(c < COL-1) queue.add(new int[] {r, c+1, distance+1});
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int[][] maze = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = reader.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		
		int result = BFS(maze);
		
		writer.write(result + "");
		writer.flush();
	}
}
