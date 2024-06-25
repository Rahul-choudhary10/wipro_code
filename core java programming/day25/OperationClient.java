package day25;
import java.io.*;
import java.net.Socket;
public class OperationClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String hostname="localhost";
		int port=12345;
		
		try(Socket socket=new Socket(hostname,port);
				ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois=new ObjectInputStream(socket.getInputStream())){
			OperationRequest request = new OperationRequest(2,2,"+");
			
			oos.writeObject(request);
			oos.flush();
			
			double result= ois.readDouble();
			System.out.println("Result: "+result);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
