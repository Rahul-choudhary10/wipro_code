package day16;

public class StringManipulation {
	public static String middleSubstring(String str1 , String str2, int length) {
		String concatenated = str1 + str2;
		
		String reversed = new StringBuilder(concatenated).reverse().toString();
		
		if(length<=0 || concatenated.isEmpty()) {
			return " ";
		}
		if (length>=reversed.length()) {
			return reversed;
		}
		int mid=reversed.length()/2;
		int start=Math.max(0, mid-length /2);
		int end = Math.min(reversed.length(), start + length);
		
		return reversed.substring(start,end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(middleSubstring("hello","world",5));
		System.out.println(middleSubstring("hello","world",10));
		System.out.println(middleSubstring("hello","",3));
		System.out.println(middleSubstring("","",3));
		System.out.println(middleSubstring("abc","def",2));
	}

}
