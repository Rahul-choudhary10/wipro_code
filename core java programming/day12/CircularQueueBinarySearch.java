package day12;

public class CircularQueueBinarySearch {

	public int search(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			
			if(nums[mid]==target) {
				return mid;
			}
			if(nums[start]<=nums[mid]) {
				if(nums[start]<=target && target<nums[mid]) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}else {
				if(nums[mid]<target&&target<=nums[end]) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularQueueBinarySearch searcher = new CircularQueueBinarySearch();
		int[] nums= {4,5,6,7,0,1,2};
		int target=0;
		int index=searcher.search(nums, target);
		System.out.println("Index of" + target + "is:" + index);
		}

}
