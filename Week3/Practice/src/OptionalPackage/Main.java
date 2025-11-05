package OptionalPackage;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		//getting mail
		User user1 = new User(1, "John Doe",null );
		User user2 = new User(2,"Asritha","asritha@gmail.com");
		//method to get the email
		Optional <String> email1 = Optional.ofNullable(user1.getEmail());
		email1.ifPresentOrElse(System.out::println, () -> System.out.println("Email not provided"));
		

	}

}
