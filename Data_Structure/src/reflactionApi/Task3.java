package reflactionApi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class Task3 {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = MyClass.class;
        System.out.println("Methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("\nFields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        Field privateField = clazz.getDeclaredField("privateField");
        privateField.setAccessible(true); // Override access control
        MyClass instance = new MyClass();
        privateField.set(instance, "New value");
        System.out.println("\nModified private field value: " + instance.getPrivateField());
    }
}

class MyClass {
    private String privateField;

    public MyClass() {
        this.privateField = "Initial value";
    }

    public String getPrivateField() {
        return privateField;
    }
}

