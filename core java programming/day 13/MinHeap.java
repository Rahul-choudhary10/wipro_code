package day13;
import java.util.ArrayList;

public class MinHeap {

	private ArrayList<Integer> heap;
	public MinHeap() {
		heap=new ArrayList<>();
	}
	public void insert(int element) {
		heap.add(element);
		heapifyUp(heap.size()-1);
	}
	public int deleteMin() {
		if(heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		int minElement = heap.get(0);
		int lastElement = heap.remove(heap.size()-1);
		if(!heap.isEmpty()) {
			heap.set(0,lastElement);
			heapifyDown(0);
		}
		return minElement;
	}
	public int getMin() {
		if(heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		return heap.get(0);
	}
	private void heapifyUp(int index) {
		int parentIndex =(index-1)/2;
		if(index>0 && heap.get(index)<heap.get(parentIndex)) {
			swap(index,parentIndex);
			heapifyUp(parentIndex);
		}
	}
	private void heapifyDown(int index) {
		int leftChildIndex=2*index+1;
		int rightChildIndex=2*index+2;
		int smallestIndex=index;
		
		if(leftChildIndex<heap.size()&&heap.get(leftChildIndex)<heap.get(smallestIndex)) {
			smallestIndex=leftChildIndex;
		}
		if(rightChildIndex<heap.size()&&heap.get(rightChildIndex)<heap.get(smallestIndex)) {
			smallestIndex=rightChildIndex;
		}
		if(smallestIndex!=index) {
			swap(index,smallestIndex);
			heapifyDown(smallestIndex);
		}
	}
	private void swap(int index1,int index2) {
		int temp=heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
	public void printHeap() {
		System.out.println(heap);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinHeap minHeap=new MinHeap();
		minHeap.insert(10);
		minHeap.insert(15);
		minHeap.insert(20);
		minHeap.insert(17);
		minHeap.insert(25);
		minHeap.printHeap();
		System.out.println("minimum element: "+ minHeap.getMin());
		System.out.println("deleted minimum element:"+ minHeap.getMin());
		minHeap.printHeap();
		System.out.println("minimum element:"+minHeap.getMin());
	}

}
