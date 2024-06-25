package day18;

public class UniqueElementFinder {
	public static int[] findUniqueElement(int[] nums) {
		int xor=0;
		for (int num:nums) {
			xor^=num;
		}
		int setBit=xor & -xor;
		
		int[] result=new int[2];
		for(int num:nums) {
			if((num&setBit)==0) {
				result[0]^=num;
			}
			else {
				result[1]^=num;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= {1,2,3,2,1,4};
		int[] uniqueElements = findUniqueElement(nums);
		System.out.println("The two unique elements are : " + uniqueElements[0] + " and " + uniqueElements[1]);
		
	}

}
