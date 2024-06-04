package reflactionApi;

import java.util.function.*;

public class Task5 {
    public static void main(String[] args) {
        Person person = new Person("John", 30);
        Predicate<Person> isAdult = new Predicate<Person>() {
			public boolean test(Person p) {
				return p.getAge() >= 18;
			}
		};
        final Function<Person, String> personToString = new Function<Person, String>() {
			public String apply(Person p) {
				return "Name: " + p.getName() + ", Age: " + p.getAge();
			}
		};
        Consumer<Person> printPersonDetails = new Consumer<Person>() {
			public void accept(Person p) {
				System.out.println("Person Details: " + personToString.apply(p));
			}
		};
        Supplier<Person> createPerson = new Supplier<Person>() {
			public Person get() {
				return new Person("Alice", 25);
			}
		};
        operateOnPerson(person, isAdult, printPersonDetails, createPerson);
    }
    public static void operateOnPerson(Person person,
                                       Predicate<Person> predicate,
                                       Consumer<Person> consumer,
                                       Supplier<Person> supplier) {
        if (predicate.test(person)) {
            System.out.println("The person is an adult.");
        } else {
            System.out.println("The person is not an adult.");
        }
        consumer.accept(person);
        Person newPerson = supplier.get();
        System.out.println("New person created: " + newPerson.getName() + ", " + newPerson.getAge());
    }
}



