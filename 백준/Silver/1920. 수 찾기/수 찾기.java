import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
		var tokenizer = new StringTokenizer(reader.readLine());	
	int N = Integer.parseInt(tokenizer.nextToken());
	
	HashSet<Integer> set1 = new HashSet<>();
	tokenizer = new StringTokenizer(reader.readLine());
	for(int i=0; i<N; i++) {
		set1.add(Integer.parseInt(tokenizer.nextToken()));
	}
	
	tokenizer = new StringTokenizer(reader.readLine());
	int M = Integer.parseInt(tokenizer.nextToken());
	
	tokenizer = new StringTokenizer(reader.readLine());
	for(int i=0; i<M; i++) {
		int num = Integer.parseInt(tokenizer.nextToken());
		
		if(set1.contains(num)) {
			writer.write("1\n");
		}
		else
			writer.write("0\n");
	}
	
	
	
	writer.flush();
	}
}