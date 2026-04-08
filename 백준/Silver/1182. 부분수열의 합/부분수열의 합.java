import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int count = 0;;
	
	static void DFS(int[] arr, int index, List<Integer> selected, int S){
		if(index >= arr.length) {
			int sum = 0;
			for(int n : selected) {
				sum += n;
			}
			if((!selected.isEmpty()) && (sum == S)) count++;
			return;
		}
		
		selected.add(arr[index]);
		DFS(arr, index+1, selected, S);
		selected.remove(selected.size()-1);
		DFS(arr, index+1, selected, S);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int S = Integer.parseInt(tokenizer.nextToken());
		int[] arr = new int[N];
		
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		DFS(arr, 0, new ArrayList<>(), S);
		
		writer.write(count + "");
		
		writer.flush();
	}
}