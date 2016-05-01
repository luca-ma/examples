package ocp_6_exam.collection;

import java.util.HashSet;



class Student{
	public Student(int r) {
		rollNo = r;
	}
	int rollNo;
	@Override
	public int hashCode() {
		
		return rollNo;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}
	
	
}
class SetEx {
	public static void main(String[] args){
		HashSet<Student> students = new HashSet<>();
		students.add(new Student(5));
		Student s10 = new Student(10);
		students.add(s10);
		System.out.println(students.contains(new Student(10)));
		System.out.println(students.contains(s10));
	}
}
