package Practice01;

import java.awt.Container;
import java.util.Vector;

public class Course {
	private String courseId;
	private String courseName;
	private Vector<Course> courses;
	
	public Course(String courseId, String courseName, Vector<Course> courses) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courses=" + courses + "]";
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void dropCourse(Course course) {
		
	}
	
}
