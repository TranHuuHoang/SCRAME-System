
/**
 A class use to manage courses.
 Hold an array list of every courses in the data.
 Many courses can be taken by 1 student.
 @author SS2 Group 5
 @version 1.0
 @since 2018-11-14

 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class CourseApp.
 */
public class CourseApp implements Serializable{
	
	/** The array list of every courses in the data */
	ArrayList <Courses> c;
	
	/**
	 * Instantiates a new courses control object. 
	 */
	public CourseApp() {
		c = new ArrayList<Courses>();
		for (Courses i : c ) {
            i = new Courses(); 
        }
	}
	
	/**
	 * Adds a course with tut/lab to the array list of courses.
	 *
	 * @param Cname the cname
	 * @param ID the id
	 * @param prof the prof
	 * @param NoOfIndex the no of index
	 * @param IndexCapacity the index capacity
	 * @param structure the structure
	 */
	//Add course to the ArrayList of Courses (course with tut/lab - have index groups)
	public void addCourse(String Cname,String ID, Professor prof, int NoOfIndex, int IndexCapacity, int structure) {
		Courses crs = new Courses();
		crs.setCourseStructure(structure);
		crs.setName(Cname);
		crs.setCourseID(ID);
		crs.setProf(prof);
		crs.createIndex(NoOfIndex, IndexCapacity);
		c.add(crs);
		System.out.println("Successfully add course: "+crs.getName()+", course ID: "+crs.getCourseID());
		System.out.println("List of all courses:");
		for (Courses course : c) {
			System.out.println("Course "+course.getName()+", ID: "+course.getCourseID()+"; Professor in charge: "+course.getProf());
		}
	}
	
	/**
	 * Adds a course with lecture only to the array list of courses.
	 *
	 * @param Cname the cname
	 * @param ID the id
	 * @param prof the prof
	 * @param capacity the capacity
	 * @param structure the structure
	 */
	//Add course to the ArrayList of Courses (course with lec only - no index group)
	public void addCourse(String Cname, String ID, Professor prof, int capacity, int structure) {
		Courses crs = new Courses();
		crs.setCourseStructure(structure);
		crs.setName(Cname);
		crs.setCourseID(ID);
		crs.setProf(prof);
		crs.setCapacity(capacity);
		crs.lec = new Lecture();
		crs.lec.setCapacity(capacity);
		c.add(crs);
		System.out.println("Successfully add course: "+crs.getName()+", course ID: "+crs.getCourseID());
		System.out.println("List of all courses:");
		for (Courses course : c) {
			System.out.println("Course "+course.getName()+", ID: "+course.getCourseID()+"; Professor in charge: "+course.getProf());
		}
	}
	
	/**
	 * Gets the name of a course at a specific index.
	 *
	 * @param index The index of the course
	 */
	// Print the course information at index in the list of course
	public void getName(int index) {
		System.out.println(c.get(index).getName());

	}
	
	/**
	 * Gets the id of a course at a specific index.
	 *
	 * @param index The index of the course
	 */
	public void getID(int index) {
		System.out.println(c.get(index).getCourseID());

	}

	/**
	 * Gets the vacancy of a course at a specific index.
	 *
	 * @param index The index of the course
	 */
	public void getVacancy(int index) {
		System.out.println(c.get(index).getVacancy());

	}
	
	/**
	 * Check whether the course already exists.
	 *
	 * @param ID The id of the course
	 * @return true, if course already exist; else false
	 */
	public boolean containsID(String ID) {
		for (Courses crs : c) {
			if (crs.getCourseID().equals(ID))
				return true;
		}
		return false;
	}
}
