package day12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSorter {
	public static void sortQueue(Queue<Integer> queue) {
		Stack<Integer> stack=new Stack<>();
		
		while(!queue.isEmpty()) {
			int current=queue.poll();
			while(!stack.isEmpty() && stack.peek() > current) {
				queue.add(stack.pop());
			}
			stack.push(current);
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> queue= new LinkedList<>();
		queue.offer(34);
		queue.offer(3);
		queue.offer(31);
		queue.offer(98);
		queue.offer(92);
		
		System.out.println("Original queue:"+queue);
		
		sortQueue(queue);
		
		System.out.println("Sorted queue: "+queue);
	}

}
