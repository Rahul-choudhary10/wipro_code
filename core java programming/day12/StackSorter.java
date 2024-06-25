package day12;

import java.util.Stack;

public class StackSorter {
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		while(!stack.isEmpty()) {
			int current=stack.pop();
			while(!tempStack.isEmpty() && tempStack.peek()>current) {
				stack.push(tempStack.pop());
			}
			tempStack.push(current);
		}
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Stack<Integer> stack = new Stack<>();
		stack.push(33);
		stack.push(21);
		stack.push(43);
		stack.push(15);
		stack.push(92);
		stack.push(25);
		System.out.println("original stack:"+stack);
		sortStack(stack);
		System.out.println("sorted stack:"+stack);
	}

}
