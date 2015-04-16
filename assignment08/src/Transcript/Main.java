package Transcript;

public class Main {
	
	private static StudentInfo studentInfo = null;
	private static Courses courses = null;
	
	public static void main(String[] args) {
		dataSetup();
		
		TranscriptCreator tC = new TranscriptCreator(studentInfo, courses);
		
		tC.build();
		tC.display();
	}
	
	private static void dataSetup() {
		Course MAT101 = new Course("Intermediate Algebra", "MAT101", "S", 0.0, "N/A", 0, "Transfer");
		Course CSC351 = new Course("Database Design and Implementation", "CSC351", "BC", 4.0, "Fall", 2013, "Residential");
		Course CSC111 = new Course("Introduction to JAVA", "CSC111", "D", 4.0, "Spring", 2014, "Residential");
		Course CSC211 = new Course("Database Web Creation and Networks", "CSC211", "A", 4.0, "Spring", 2014, "Residential");
		Course ENG170 = new Course("Writing Seminar", "ENG170", "B", 4.0, "Spring", 2014, "Residential");
		Course MAT140 = new Course("Calculus and Its Applications", "MAT140", "C", 4.0, "Spring", 2014, "Residential");
		Course ART209 = new Course("Photography I", "ART209", "B", 4.0, "Summer 1", 2014, "Residential");
		Course ART310 = new Course("Photography II ­ Commercia", "ART310", "AB", 4.0, "Fall", 2014, "Residential");
		Course COM101 = new Course("Principles of Communication", "COM101", "AB", 4.0, "Fall", 2014, "Residential");
		Course CSC226 = new Course("Data Structures using JAVA", "CSC226", "D", 4.0, "Fall", 2014, "Residential");
		Course CSC319 = new Course("World Wide Web Programming", "CSC319", "B", 4.0, "Fall", 2014, "Residential");
		Course BUS101 = new Course("Introduction to Business", "BUS101 - WW", "C", 4.0, "Winter", 2015, "Residential");
		Course BUS260 = new Course("Ethics in Business, Govt, and Society", "BUS260 - WW", "BC", 4.0, "Winter", 2015, "Residential");
		
		Course[] _courses = new Course[]{MAT101, CSC351, CSC111, CSC211, ENG170, MAT140, ART209, ART310, COM101, CSC226, CSC319, BUS101, BUS260};
		
		studentInfo = new StudentInfo("Henry Snopek", "Computer Science", "Business Management", "Marie Schwerm", "Bacholers", "Full");
		courses = new Courses(_courses);
	}
}
