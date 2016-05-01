package collection.list;

public class Person implements Comparable<Person> {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person pers) {
		return name.compareTo(pers.name);
	}

	public String toString() {
		return name;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
