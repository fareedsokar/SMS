package Entities;

public class Course {

	private int Course_ID;
	private String Course_Name;
	private int TeachUnit_ID;
	private int CourseStudyHours;
	private int PreCourses[];
	public int getCourse_ID() {
		return Course_ID;
	}
	public void setCourse_ID(int course_ID) {
		Course_ID = course_ID;
	}
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}
	public int getTeachUnit_ID() {
		return TeachUnit_ID;
	}
	public void setTeachUnit_ID(int teachUnit_ID) {
		TeachUnit_ID = teachUnit_ID;
	}
	public int getCourseStudyHours() {
		return CourseStudyHours;
	}
	public void setCourseStudyHours(int courseStudyHours) {
		CourseStudyHours = courseStudyHours;
	}
	public int[] getPreCourses() {
		return PreCourses;
	}
	public void setPreCourses(int preCourses[]) {
		PreCourses = preCourses;
	}
}
