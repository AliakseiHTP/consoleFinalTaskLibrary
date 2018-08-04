package by.htp.entity;

import by.htp.entity.Person;

public class Person {
	private int id_librarycard;
	private int accessLevel;
	private String name;
	private String surname;
	private String phoneNumber;

	public Person() {
		super();
	}

	public Person(String name, String surname, String phoneNumber, int accessLevel) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.accessLevel = accessLevel;
	}

	public int getIdlybrarycard() {
		return id_librarycard;
	}

	public void setIdlibrarycard(int id_librarycard) {
		this.id_librarycard = id_librarycard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Person [accessLevel=" + accessLevel + ", name=" + name + ", surname=" + surname + ", phoneNumber="
				+ phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_librarycard;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id_librarycard != other.id_librarycard)
			return false;
		return true;
	}
}
