/**
This class is used to create tutorial group objects.
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/

import java.util.ArrayList;

/**
* The Class Tutorial.
*/
public class Tutorial extends IndexGroup{
	
	/** The student list for that index group. */
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	/**
	 * Instantiates a new tutorial object.
	 */
	public Tutorial() {}
	
	
	public void addStudent (Student student) {
		studentList.add(student);
	}
	
	/**
	 * Prints all the students in that tutorial group.
	 */
	public void printStudent () {
		for (Student s : studentList) {
			System.out.print(s.getName() +", ID:"+s.getStudentID()+" ; ");
		}
	}
	
}
