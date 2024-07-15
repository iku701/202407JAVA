package Practice01;

import java.util.Vector;

public class Student {
	private String name;
	private Vector<Student> students;
	private int numOfStudents;
	public Student(String name, Vector<Student> students, int numOfStudents) {
		super();
		this.name = name;
		this.students = students;
		this.numOfStudents = numOfStudents;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", students=" + students + ", numOfStudents=" + numOfStudents + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector<Student> getStudents() {
		return students;
	}
	public void setStudents(Vector<Student> students) {
		this.students = students;
	}
	public int getNumOfStudents() {
		return numOfStudents;
	}
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		++numOfStudents;
	}
	
	public void deleteStudent(Student student) {
		if (students.contains(student)) {
			students.remove(student);
			--numOfStudents;
		}
	}
	
	
	
	
}	
