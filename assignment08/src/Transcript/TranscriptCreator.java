package Transcript;

import java.text.DecimalFormat;
import java.util.Iterator;

public class TranscriptCreator {
	private StudentInfo student = null;
	private Courses courses = null;
	private String transcript = "";
	private String linebreak = "\n----------------------------------------";
	
	public TranscriptCreator(StudentInfo student, Courses courses) {
		this.student = student;
		this.courses = courses;
	}
	
	public void build() {
		buildHeader();
		buildBody();
		buildFooter();
	}
	
	public void display() {
		System.out.print(transcript);
	}
	
	private void buildHeader() {
		String schoolInfo = "\nCarroll University\n100 North East Avenue\nWaukesha, WI 53188\n\nTranscript of " + student.getName();
		
		String studentInfo = "\n\nStudent Information" + linebreak
				+ "\nAdvisor:\t" + student.getAdvisor()
				+ "\nDegree:\t\t" + student.getDegree()
				+ "\nMajor:\t\t" + student.getMajor()
				+ "\nMinor:\t\t" + student.getMinor()
				+ "\n\n";
		
		transcript += schoolInfo + studentInfo;
	}
	
	private void buildBody() {
		String transferCourses = "", residentialCourses= "";
		Iterator<Course> courseIterator = courses.iterator(); 
		
		while (courseIterator.hasNext()) {
			Course course = courseIterator.next();
			
			if (course.getType().equalsIgnoreCase("transfer")) {
				transferCourses += "\n" + course.toString();
			} else {
				residentialCourses += "\n" + course.toString();
			}
		}
		
		transcript += "Transfer Courses" + linebreak
				+ transferCourses + "\n\n"
				+ "Residential Courses" + linebreak
				+ residentialCourses;
	}
	
	private void buildFooter() {
		Iterator<Course> courseIterator = courses.iterator(); 
		double creditTotal = 0, gpa = 0;
		
		while (courseIterator.hasNext()) {
			Course course = courseIterator.next();
			
			creditTotal += course.getCreditsEarned();
			if (!course.getType().equalsIgnoreCase("transfer")) gpa += course.getGradeNum();
		}
		
		double GPA = (gpa / (double) courses.getLength()); 
		
		transcript += "\n\nCredits:" + linebreak
				+ "\nCredits Earned:\t\t" + new DecimalFormat("#").format(creditTotal)
				+ "\nGPA:\t\t\t" + new DecimalFormat("#.##").format(GPA);
	}
	
}
