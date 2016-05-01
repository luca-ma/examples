package collection.list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TestComparableVsComparator {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return (p1.getAge() - p2.getAge());
			}
		});
		Person p1 = new Person("Shreya", 12);
		Person p2 = new Person("Harry", 40);
		Person p3 = new Person("Paul", 30);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		Iterator<Person> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ":");
		}

	}
}
