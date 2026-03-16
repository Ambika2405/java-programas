//Create a Java program that validates Employee details using custom annotations and Regular Expressions.

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ValidEmployeeEmail {
    String message() default "Invalid Email Format";
}

class Employee {
    private String employeeId;

    @ValidEmployeeEmail(message = "Email must be @company.com")
    private String email;

    public Employee(String employeeId, String email) {
        this.employeeId = employeeId;
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getEmployeeId() { return employeeId; }
}


class EmployeeValidator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ValidEmployeeEmail.class)) {
                ValidEmployeeEmail annotation = field.getAnnotation(ValidEmployeeEmail.class);
                field.setAccessible(true);
                String value = (String) field.get(obj);
                String regex = "^[\\w-\\.]+@company\\.com$";
                if (!Pattern.matches(regex, value)) {
                    System.out.println("Validation Failed: " + annotation.message() + " for value: " + value);
                } else {
                    System.out.println("Validation Passed for: " + value);
                }
            }
        }
    }
}
public class ValidationDemo {
    public static void main(String[] args) throws IllegalAccessException {
        Employee emp1 = new Employee("E001", "john.doe@company.com");
        Employee emp2 = new Employee("E002", "jane.doe@gmail.com");

        System.out.println("Validating Employee 1:");
        EmployeeValidator.validate(emp1);

        System.out.println("\nValidating Employee 2:");
        EmployeeValidator.validate(emp2);
    }
}
