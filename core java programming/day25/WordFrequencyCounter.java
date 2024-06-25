package day25;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordFrequencyCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputFilePath="input.txt";
		String outputFilePath="output.txt";
		
		Map<String,Integer> wordCountMap = new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader(inputFilePath))){
			String line;
			while((line=br.readLine())!=null) {
				StringTokenizer tokenizer=new StringTokenizer(line);
				while(tokenizer.hasMoreTokens()) {
					String word=tokenizer.nextToken().toLowerCase();
					wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(outputFilePath))){
			for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
				bw.write(entry.getKey()+" : "+entry.getValue());
				bw.newLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Word frequency count written to "+outputFilePath);
	}

}
