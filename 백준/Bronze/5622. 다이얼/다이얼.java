import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = reader.readLine();
		char[] arr = new char[str.length()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		// 65~90
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			int n = arr[i];
			if(n>=65 && n<68) {
				count += 3;
			}
			else if(n>=68 && n<71) {
				count += 4;
			}
			else if(n>=71 && n<74) {
				count += 5;
			}
			else if(n>=74 && n<77) {
				count += 6;
			}
			else if(n>=77 && n<80) {
				count += 7;			
			}
			else if(n>=80 && n<84) {
				count += 8;
			}
			else if(n>=84 && n<87) {
				count += 9;
			}
			else if(n>=87 && n<91) {
				count += 10;
			}
			else
				break;
		}
		
		writer.write(count +"");
		
		writer.flush();
	}
}