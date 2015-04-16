package Transcript;

public class Course {
	String name, code, grade, season, type;
	double creditsEarned, gradeNum;
	int year;
	
	public Course(String name, String code, String grade, Double creditsEarned, String season, int year, String type) {
		this.name = name;
		this.code = code;
		this.grade = grade;
		this.creditsEarned = creditsEarned;
		this.season = season;
		this.year = year;
		this.type = type;
		
		double gradeNum = 0;
		if (this.grade.equalsIgnoreCase("A")) {
			gradeNum = 4.0;
		} else if (this.grade.equalsIgnoreCase("AB")) {
			gradeNum = 3.5;
		} else if (this.grade.equalsIgnoreCase("B")) {
			gradeNum = 3;
		} else if (this.grade.equalsIgnoreCase("BC")) {
			gradeNum = 2.5;
		} else if (this.grade.equalsIgnoreCase("C")) {
			gradeNum = 2;
		} else if (this.grade.equalsIgnoreCase("CD")) {
			gradeNum = 1.5;
		}  else if (this.grade.equalsIgnoreCase("D")) {
			gradeNum = 1;
		}  else {
			gradeNum = 0;
		} 
		
		this.gradeNum = gradeNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getCreditsEarned() {
		return creditsEarned;
	}

	public void setCreditsEarned(double creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public double getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(double GradeNum) {
		this.gradeNum = GradeNum;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "\n" + season + ", " + year + "\n\t"
				+ code + " "+ name + " - Grade: " + grade + " - Credits: " + gradeNum;
	}
	
}
