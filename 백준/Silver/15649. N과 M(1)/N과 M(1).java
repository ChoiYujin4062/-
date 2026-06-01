package baekjoon;

import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int[] A;
	static ArrayList<Integer> selected = new ArrayList<>();
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void DFS() throws IOException {
		if(selected.size() == M) {
			for(int i:selected) {
				writer.write(i + " ");
			}
			writer.write('\n');
			return;
		}
		for(int i:A) {
			if(!selected.contains(i)) {
				selected.add(i);
				DFS();
				selected.remove(selected.size()-1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = i+1;
		}
		
		DFS();
		
		writer.flush();
	}
}
