package day14;

class Name {
	String firstName;
	String lastName;

	Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return "[" + firstName + lastName + "]";
	}
}
