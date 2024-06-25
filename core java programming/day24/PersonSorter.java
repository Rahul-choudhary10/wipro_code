package day24;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
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
		return "Person{name='"+name+"',age="+age+"}";
	}
}
public class PersonSorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> people=new ArrayList<>();
		people.add(new Person("Alice",30));
		people.add(new Person("Bob",25));
		people.add(new Person("Rohan",35));
		
		Comparator<Person> byAge=(Person p1,Person p2) -> Integer.compare(p1.getAge(), p2.getAge());
		
		Collections.sort(people,byAge);
		for(Person person : people) {
			System.out.println(person);
		}
	}

}
