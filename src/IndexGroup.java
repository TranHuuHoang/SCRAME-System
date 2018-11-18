/**
Represent all the information about a group
For example: a tutorial group, a laboratory group
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
* The Class indexgroup .
*/
public class IndexGroup implements Serializable {
	
	/** The course ID. */
	private String courseID;
	
	/** The group capacity. */
	private int capacity;
	
	/** The group vacancy. */
	private int vacancy;
	
	/** The index number */
	private int indexNo;
	
	/** The students. */
	ArrayList<Student> students = new ArrayList<Student>();
	
	
	/**
	 * Instantiates a new index group.
	 */
	public IndexGroup() {
	}

	/**
	 * Gets the course ID.
	 *
	 * @return the course ID
	 */
	public String getCourseID() {
		return this.courseID;
	}
	
	/**
	 * Sets the course ID.
	 *
	 * @param courseID the new course ID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * Sets the capacity.
	 *
	 * @param capacity the new capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		this.vacancy = capacity;
	}
	
	/**
	 * Gets the vacancy.
	 *
	 * @return the vacancy
	 */
	public int getVacancy() {
		return this.vacancy;
	}
	
	/**
	 * Update vacancy.
	 */
	public void updateVacancy() {
		this.vacancy--;
	}
	
	/**
	 * Gets the index number.
	 *
	 * @return the index number
	 */
	public int getIndexNo() {
		return this.indexNo;
	}
	
	/**
	 * Sets the index number.
	 *
	 * @param indexNo the index number of the group
	 */
	public void setIndexNo(int indexNo)
	{
		this.indexNo = indexNo;
	}
		
	/**
	 * Adds a student to the group.
	 *
	 * @param student student object
	 */
	public void addStudent(Student student) {
		students.add(student);
	}

}


