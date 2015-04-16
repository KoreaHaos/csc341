package Transcript;

import java.util.Iterator;

public class Courses implements Iterator<Course> {
	private Course[] courses;
	private int length;

	public Courses(Course[] courses) {
		 this.courses = courses;
		 this.length = courses.length;
	}

	public Iterator<Course> iterator() {
		return new Iterator<Course>() {
			private int count = 0;
			public boolean hasNext() {
				return count < courses.length;
			}
			
			public Course next() {
				return courses[count++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public int getLength() {
		return length;
	}
	
}
