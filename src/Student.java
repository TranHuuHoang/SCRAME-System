/**
This class is used to instantiate Student objects.
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/


import java.io.Serializable;
import java.util.ArrayList;

/**
* The Class Student.
*/
public class Student implements Serializable {
	
	/** The student ID. */
	private String studentID;
	
	/** The student name. */
	private String name;
	
	/** The student's major. */
	private String program;
	
	/** The year of study. */
	private int year;
	
	/** The courses taken by the student. */
	ArrayList <Courses> course = new ArrayList<Courses>();
	
	/** The grades for each course taken by the student. */
	ArrayList <Grades> grade = new ArrayList<Grades>();
	
	/**
	 * Instantiates a new Student object.
	 *
	 * @param StudentID the student ID
	 */
	//Course with index i is refered to grade with index i
	public Student(String StudentID) {
		this.studentID = StudentID;
	}
	
	/**
	 * Instantiates a new Student object without instantiating any attributes.
	 */
	public Student() {}
	
	/**
	 * Gets the student ID.
	 *
	 * @return the student ID
	 */
	public String getStudentID() {
		return this.studentID;
	}
	
	/**
	 * Sets the student ID.
	 *
	 * @param studentID the student ID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * Gets the student name.
	 *
	 * @return the student name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the student name.
	 *
	 * @param name the student name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Register a course for the student if course has tutorial/lab.
	 * Add the course to the array list course.
	 * Creates a new Grades object to hold information about the grade obtained by the student for that course. 
	 * Adds the Grades object to the grade array list. 
	 *
	 * @param crs the course to register to the student 
	 * @param index the index
	 */
	//Student register for a course if course has tut/lab (hence, have index groups)
	public void registerCourse(Courses crs, int index) {
		this.course.add(crs);
	
		crs.registerIndex(this, index);
		System.out.println("Successfully register " + this.getName() + " for course " + crs.getName()+", index "+ index);
		Grades g = new Grades(crs);
		this.grade.add(g);		
		
	}
	
	/**
	 * Register a course for the student if course has only lecture.
	 * Add the course to the array list course.
	 * Creates a new Grades object to hold information about the grade obtained by the student for that course.
	 * Adds the Grades object to the grade array list. 
	 *
	 * @param crs the course to register to the student
	 */
	//Student register for a course when course has only lec
	public void registerCourse(Courses crs) {
		this.course.add(crs);
		crs.registerIndex(this);
		System.out.println("Successfully register " + this.getName() + " for course " + crs.getName()+" !");
		Grades g = new Grades(crs);
		this.grade.add(g);		
				
	}

	
	/**
	 * Gets the study year.
	 *
	 * @return the study year
	 */
	public int getStudyYear() {
		return this.year;
	}	
	
	/**
	 * Sets the study year.
	 *
	 * @param year A new study year
	 */
	public void setStudyYear(int year) {
		this.year = year;
	}

	/**
	 * Sets the student's major.
	 *
	 * @param program A program
	 */
	public void setProgram(String program) {
		this.program = program;
	}
	
	/**
	 * Gets the student's major.
	 *
	 * @return the major/program of the student
	 */
	public String getProgram() {
		return this.program;
	}
	
}
