import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String str = reader.readLine();
			int num = Integer.parseInt(str);
			if(num == 0) {
				if(pq.isEmpty()) {
					writer.write("0\n");
				}
				else {
					writer.write(pq.element() + "\n");
					pq.poll();
				}
			}
			else {
				pq.add(num);
			}
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
}
