package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static ArrayList<Integer>[] neighbors;
	
	static int BFS(int start, int goal) {
		var visited = new boolean[n+1];
		var queue = new ArrayDeque<int[]>();
		queue.add(new int[] {start, 0});
		while(queue.size() > 0) {
			int[] temp = queue.remove();
			int node = temp[0], distance = temp[1];
			if(visited[node]) continue;
			else visited[node] = true;
			if(node == goal) return distance;
			for(int neighbor:neighbors[node]) {
				queue.add(new int[] {neighbor, distance + 1});
				}
			}
		return -1;
		}
	 
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(tokenizer.nextToken());
		
		tokenizer = new StringTokenizer(reader.readLine());
		int num1 = Integer.parseInt(tokenizer.nextToken());
		int num2 = Integer.parseInt(tokenizer.nextToken());
		
		tokenizer = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		
		int[][] edge = new int[m][2];
		for(int i=0; i<m; i++) {
			tokenizer = new StringTokenizer(reader.readLine());;
			for(int j=0; j<2; j++) {
				edge[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		neighbors = new ArrayList[n+1];
		for(int i=1; i<=n; ++i) {
			neighbors[i] = new ArrayList<Integer>();
		}
		for(int[] e:edge) {
			int a = e[0], b = e[1];
			neighbors[a].add(b);
			neighbors[b].add(a);
		}
		
		writer.write(BFS(num1, num2 + ""));
		writer.flush();
	}
}
