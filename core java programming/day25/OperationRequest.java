package day25;
import java.io.Serializable;
public class OperationRequest implements Serializable {

	private static final long serialVersionUID=1L;
	private double number1;
	private double number2;
	private String operation;
	
	public OperationRequest(double number1,double number2, String operation) {
		this.number1=number1;
		this.number2=number2;
		this.operation=operation;
	}
	public double getNumber1() {
		return number1;
	}
	public double getNumber2() {
		return number2;
	}
	public String getOperation() {
		return operation;
	}
}
