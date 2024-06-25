package day25;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class OperationServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int port=12345;
		try(ServerSocket serverSocket=new ServerSocket(port)){
			System.out.println("Server is listening on port "+port);
			
			while(true) {
				try(Socket socket = serverSocket.accept();
						ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
						ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream())){
					OperationRequest request=(OperationRequest) ois.readObject();
					double result=performOperation(request);
					oos.writeDouble(result);
					oos.flush();
				}catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static double performOperation(OperationRequest request) {
		double number1=request.getNumber1();
		double number2=request.getNumber2();
		String operation=request.getOperation();
		
		switch(operation) {
		case"+":
			return number1 + number2;
		case"-":
			return number1 - number2;
		case"*":
			return number1 * number2;
		case"/":
			if(number2 !=0) {
			return number1 / number2;
		}else {
			throw new ArithmeticException("Division by zero");
		}
		default:
			throw new IllegalArgumentException("Invalid operation: "+operation);
	}

	}
}
