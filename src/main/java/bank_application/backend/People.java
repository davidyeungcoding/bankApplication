package bank_application.backend;

public class People {

	abstract class Person{
		String firstName, lastName;
	
		Person (String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			
		}
	}
	
	class Customer extends Person {
		String email, address;
		byte age;
		int phoneNumber;
		private transient String username, password;
		private transient int saveAccNumber, checkAccNumber, routingNumber;
		private boolean fullAccount = false;		
		
		Customer (String firstName, String lastName, String email, String address, byte age, int phoneNumber, String username, String password) {
			super(firstName, lastName);
			this.email = email;
			this.address = address;
			this.age = age;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
		}
	}
	
	class Employee extends Person {
		byte id;
		private transient String username, password;
		
		Employee(String firstName, String lastName, byte id, String username, String password) {
			super(firstName, lastName);
			this.id = id;
			this.username = username;
			this.password = password;
		}
	}
}
