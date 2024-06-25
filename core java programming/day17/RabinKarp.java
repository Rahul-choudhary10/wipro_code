package day17;

public class RabinKarp {
	public static final int PRIME =101;
	
	public static long calculateHash(String str, int end) {
		long hash=0;
		for(int i=0;i<end;i++) {
			hash +=str.charAt(i)*Math.pow(PRIME, i);
		}
		return hash;
	}
	public static long recalculateHash(String str, int oldIndex,int newIndex,long oldHash,int patternLength) {
		long newHash=oldHash - str.charAt(oldIndex);
		newHash /= PRIME;
		newHash += str.charAt(newIndex)*Math.pow(PRIME, patternLength - 1);
		return newHash;
	}
	public static boolean checkEqual(String str1, int start1,int end1, String str2,int start2, int end2) {
		if(end1 - start1 != end2 - start2) {
			return false;
		}
		while(start1<=end1 && start2 <= end2) {
			if(str1.charAt(start1)!=str2.charAt(start2)) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}
	public static void searchPattern(String text, String pattern) {
		int m = pattern.length();
		int n=text.length();
		long patternHash =calculateHash(pattern,m);
		long textHash = calculateHash(text,m);
		
		for(int i=0;i<=n-m;i++) {
			if(patternHash==textHash && checkEqual(text,i,i+m-1,pattern,0,m-1)) {
				System.out.println("Pattern found at index "+i);
				
			}
			if(i<n-m) {
				textHash = recalculateHash(text,i,i+m,textHash,m);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text="ABABDABACDABABCABAB";
		String pattern="ABABCABAB";
		searchPattern(text,pattern);
	}

}
