/**
This class is a control class relating to Student
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/


import java.io.Serializable;
import java.util.*;

/**
* The Class StudentApp.
*/
public class StudentApp implements Serializable {
	
	/** The array list of all students */
	ArrayList <Student> s;
	
	/** The position of a student in the array list s. */
	static int index = 0;
	
	/**
	 * Instantiates a new StudentApp object.
	 */
	public StudentApp() {
		s = new ArrayList<Student>();
		for (Student i : s ) {
           i = new Student(); 
       }
	}
	
	/**
	 * Creates student objects.
	 * Adds newly created student objects to the array list s.
	 *
	 * @param Sname the student name
	 * @param ID the student ID
	 * @param year the year of study
	 * @param program the student's major
	 */
	//Add a student to a list of students
	public void addStudent(String Sname, String ID, int year, String program) {
		Student stu = new Student();
		stu.setName(Sname);
		stu.setStudentID(ID);
		stu.setStudyYear(year);
		stu.setProgram(program);
		s.add(stu);
		System.out.println("Successfully add student with ID: "+ stu.getStudentID());
		System.out.println("List of all students:");
		for (Student student : s) {
			System.out.println("Student: "+student.getName()+", ID: "+student.getStudentID());
		}
		}
	
	/**
	 * Gets the student name.
	 *
	 * @param index the student index
	 */
	// Get info of student in specific index of List of Students
	public void getName(int index) {
		System.out.println(s.get(index).getName());

	}
	
	/**
	 * Gets the student id.
	 *
	 * @param index the student index
	 */
	public void getID(int index) {
		System.out.println(s.get(index).getStudentID());

	}
	
	/**
	 * Gets the year of study.
	 *
	 * @param index the student index in the list of students
	 */
	public void getYear(int index) {
		System.out.println(s.get(index).getStudyYear());

	}
	
	/**
	 * To check if a specific student object has been created, ie that student exists. 
	 *
	 * @param ID the student id
	 * @return true, if student already exists; false if student not exists
	 */
	//check whether the list of student already have a student
	public boolean containsID(String ID) {
		for (Student stu : s) {
			if (stu.getStudentID().equals(ID))
				return true;
		}
		return false;
	}
	
}
