import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static double SubjectRating(String str) {
		double rating = 0;
		switch(str) {
			case "A+":
				rating = 4.5;
				break;
			case "A0":
				rating = 4.0;
				break;
			case "B+":
				rating = 3.5;
				break;
			case "B0":
				rating = 3.0;
				break;
			case "C+":
				rating = 2.5;
				break;
			case "C0":
				rating = 2.0;
				break;
			case "D+":
				rating = 1.5;
				break;
			case "D0":
				rating = 1.0;
				break;
			case "N":
				rating = 0;
				break;
		}
		
		return rating;
	}
	
	static double Calc(String[] arr) {
		double unit = Double.parseDouble(arr[1]);
		String str = arr[2];
		double rating = 0;
		
		if(!str.equals("P")) {
			rating = SubjectRating(str);
		}
		
		return unit*rating;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		double score = 0;
		double unitSum = 0;
		
		for(int i=0; i<20; i++) {
			String str = reader.readLine();
			String[] arr = str.split(" ");
			score += Calc(arr);
			if(!arr[2].equals("P")) {
				unitSum += Double.parseDouble(arr[1]);
			}
		}
		writer.write(score/unitSum + "");
		
		writer.flush();
	}
}