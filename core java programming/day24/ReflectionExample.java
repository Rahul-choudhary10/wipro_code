package day24;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
	private String privateField="Initial Value";
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ReflectionExample obj=new ReflectionExample();
		Method[] methods=ReflectionExample.class.getDeclaredMethods();
		System.out.println("Methods: ");
		for(Method method : methods) {
			System.out.println(method.getName());
		}
		
		Field[] fields=ReflectionExample.class.getDeclaredFields();
		System.out.println("\nFields: ");
		for(Field field : fields) {
			System.out.println(field.getName());
		}
		
		Field privateField=ReflectionExample.class.getDeclaredField("privateField");
		privateField.setAccessible(true);
		System.out.println("\nOriginal private field value: "+privateField.get(obj));
		privateField.set(obj, "Modified Value");
		System.out.println("Modified private field value: "+ privateField.get(obj));
	}

}
