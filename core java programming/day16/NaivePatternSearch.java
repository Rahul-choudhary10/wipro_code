package day16;

public class NaivePatternSearch {
	public static void searchPattern(String text, String pattern) {
		int textLength=text.length();
		int patternLength = pattern.length();
		int comparisionCount =0;
		boolean found = false;
		
		for(int i=0;i<=textLength - patternLength;i++) {
			int j;
			for(j=0;j<patternLength;j++) {
				comparisionCount++;
				if(text.charAt(i+j)!= pattern.charAt(j)) {
					break;
				}
			}
			if(j==patternLength) {
				System.out.println("Pattern found at index "+ i);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Pattern not found in the text.");
		}
		System.out.println("Total comparisions made:" + comparisionCount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text="AABAACAADAABAABA";
		String pattern="AABA";
		searchPattern(text,pattern);
	}

}
