package day25;
import java.io.*;

class Person implements Serializable{
	private static final long serialVersionUID=1L;
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return "Person{name='"+name+"',age="+age+'}';
	}
}
public class SerializationDeom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person=new Person("Sunil",25);
		try(FileOutputStream fileOut = new FileOutputStream("person.ser");
				ObjectOutputStream out=new ObjectOutputStream(fileOut)){
			out.writeObject(person);
			System.out.println("Serialized data is saved in person.ser");
		}catch (IOException i) {
			i.printStackTrace();
		}
		Person deserializedPerson=null;
		try(FileInputStream fileIn=new FileInputStream("person.ser");
				ObjectInputStream in=new ObjectInputStream(fileIn)){
			deserializedPerson = (Person) in.readObject();
		}catch (IOException i) {
			i.printStackTrace();
		}catch (ClassNotFoundException c) {
			System.out.println("Person class not found");
			c.printStackTrace();
		}
		if(deserializedPerson!=null) {
			System.out.println("Deserialized Person...");
			System.out.println("Name: "+deserializedPerson.getName());
			System.out.println("Age: "+deserializedPerson.getAge());
		}
	}

}
