package baekjoon;

import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int[] arr;
	static ArrayList<Integer> selected = new ArrayList<>();
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void DFS() throws IOException{
		if(selected.size() == M) {
			for(int i:selected) {
				writer.write(i + " ");
			}
			writer.write("\n");
			return;
		}
		for(int i:arr) {
			selected.add(i);
			DFS();
			selected.remove(selected.size() - 1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		DFS();
		
		writer.flush();
	}
}
