import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ValidEmail {
    String message() default "Invalid Email Address";
}

class User {

    @ValidEmail
    String email;

    User(String email) {
        this.email = email;
    }
}

class EmailValidator {

    public static void validate(Object obj) {

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(ValidEmail.class)) {

                field.setAccessible(true);

                try {
                    String email = (String) field.get(obj);

                    if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        System.out.println("Valid Email: " + email);
                    } else {
                        ValidEmail annotation = field.getAnnotation(ValidEmail.class);
                        System.out.println(annotation.message());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String emailInput = sc.nextLine();

        User user = new User(emailInput);

        EmailValidator.validate(user);
    }
}