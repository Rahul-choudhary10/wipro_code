package day12;
import java.util.Stack;

public class SequenceInStack {
 
	public static boolean isSequenceInStack(Stack<Integer> stack,int[] sequence) {
		int sequenceIndex=sequence.length-1;
		
		while(!stack.isEmpty() && sequenceIndex>=0) {
			if(stack.peek()==sequence[sequenceIndex]) {
				stack.pop();
				sequenceIndex--;
			}
			else
			{
				stack.pop();
			}
		}
		return sequenceIndex==-1;
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);

		int[] sequence= {3,4,5};
		System.out.println(isSequenceInStack(stack,sequence));
		
		stack.clear();
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(5);
		stack.push(3);
		stack.push(6);
		System.out.println(isSequenceInStack(stack,sequence));
}
}