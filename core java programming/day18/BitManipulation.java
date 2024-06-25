package day18;

public class BitManipulation {
	public static int countSetBits(int num) {
		int count=0;
		while(num>0) {
			count +=num&1;
			num>>=1;
		}
		return count;
		}
	
	public static int countTotalSetBits(int n) {
		int totalCount=0;
		for(int i=1;i<=n;i++) {
			totalCount +=countSetBits(i);
		}
		return totalCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=53;
		System.out.println("Number of set bits in " + n + " : " + countSetBits(n));
		System.out.println("Total number of set bits from 1 to " +n+" : "+countTotalSetBits(n));
	}

}
