package day17;

public class BoyerMoore {
	private static int[] createBadCharTable(String pattern) {
		int[] badCharTable = new int[256];
		int m = pattern.length();
		
		for(int i=0;i<256;i++) {
			badCharTable[i]=-1;
		}
		for(int i=0;i<m;i++) {
			badCharTable[(int) pattern.charAt(i)]=i;
		}
		return badCharTable;
	}
	public static int findLastOccurrence(String text,String pattern) {
		int n=text.length();
		int m=pattern.length();
		int[] badCharTable = createBadCharTable(pattern);
		int shift=0;
		int lastOccurrenceIndex=-1;
		
		while(shift<=(n-m)) {
			int j=m-1;
			
			while(j>=0 && pattern.charAt(j)==text.charAt(shift+j)) {
				j--;
			}
			if(j<0) {
				lastOccurrenceIndex = shift;
				
				shift +=(shift+m<n)? m - badCharTable[text.charAt(shift+m)] : 1;
			}else {
				shift += Math.max(1, j - badCharTable[text.charAt(shift + j)]);
			}
		}
		return lastOccurrenceIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text ="ABABDABACDABABCABAB";
		String pattern="ABABCABAB";
		int result = findLastOccurrence(text,pattern);
		System.out.println("Last occurrence of the pattern is at index: "+ result);
	}

}
