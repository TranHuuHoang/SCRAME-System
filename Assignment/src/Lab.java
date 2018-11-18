/**

@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/
import java.util.ArrayList;

/**
* The Class Lab.
*/
public class Lab extends IndexGroup{
	
	/** The student list. */
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	/**
	 * Instantiates a new lab.
	 */
	public Lab() {}
	
	/* (non-Javadoc)
	 * @see indexgroup#addStudent(Student)
	 */
	public void addStudent (Student student) {
		studentList.add(student);
	}
	
	/**
	 * Prints the student.
	 */
	public void printStudent () {
		for (Student s : studentList) {
			System.out.print(s.getName() +", ID:"+s.getStudentID()+" ; ");
		}
	}
	
}

