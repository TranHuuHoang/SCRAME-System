
/**
This class interacts with CourseApp and StudentApp
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/
import java.io.Serializable;

/**
* The Class StoreDatabase.
*/
public class StoreDatabase implements Serializable{
	
	

	/** The CourseApp reference. */
	private CourseApp courseDatabase;
	
	/** The StudentApp reference. */
	private StudentApp studentDatabase;
	
	/**
	 * Instantiates a new StoreDatabase object.
	 */
	public StoreDatabase() {
		courseDatabase = new CourseApp();
		studentDatabase = new StudentApp();
	}
	
	/**
	 * Gets the CourseApp object
	 *
	 * @return the CourseApp object
	 */
	public CourseApp getCourseData() {
		return courseDatabase;
	}
	
	/**
	 * Gets the StudentApp object.
	 *
	 * @return the StudentApp object
	 */
	public StudentApp getStudentData() {
		return studentDatabase;
	}
}
