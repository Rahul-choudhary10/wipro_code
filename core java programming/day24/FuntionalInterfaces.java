package day24;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class FuntionalInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person=new Person("Sunil",30);
		
		Predicate<Person> isAdult=p -> p.getAge() > 18;
		
		Function<Person, String> nameToUpperCase=p -> p.getName().toUpperCase();
		
		Consumer<Person> printName=p -> System.out.println("Name: "+p.getName());
		
		Supplier<Person> personSupplier=() -> new Person("Nil",25);
		
		operateOnPerson(person,isAdult, nameToUpperCase, printName, personSupplier);
	}
	public static void operateOnPerson(Person person,Predicate<Person> predicate,
			Function<Person,String> function,
			Consumer<Person> consumer,
			Supplier<Person> supplier) {
		System.out.println("Is adult: "+ predicate.test(person));
		String upperCaseName=function.apply(person);
		System.out.println("Name in uppercase: " + upperCaseName);
		
		consumer.accept(person);
		
		Person newPerson=supplier.get();
		System.out.println("New person: "+ newPerson.getName()+ " , Age: "+newPerson.getAge());
	}

}
