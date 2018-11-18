/**
Represent a course in the school.
One course can be taken  by many students and one student can enroll in many courses
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/

import java.io.Serializable;
import java.util.ArrayList;

//Assume that a course has only 1 lecture, and 1 index correspond to ONLY 1 tut and lab (index for tut = index for lab) 

/**
* The Class Courses.
*/
public class Courses implements Serializable {
	
	/** The course ID. */
	private String courseID;
	
	/** The course name. */
	private String name;
	
	/** The course vacancy. */
	private int vacancy;
	
	/** The course 's total capacity. */
	private int totalCapacity;
	
	/** Check whether a student has registered for this course yet. */
	boolean register;
	
	/** The professor in charged of this course . */
	Professor prof;
	
	/** Storing list of every students registered for this course */
	ArrayList <Student> student = new ArrayList<Student>();
	
	/** The exam weightage. */
	private int examWeightage;
	
	/** The coursework weightage. */
	private int courseworkWeightage;
	
	/** The assignment weightage. */
	private int assignmentWeightage;
	
	/** The class participation weightage. */
	private int classParticipationWeightage;
	
	/** The coursework type.
	 * if course has only exam and 1 coursework component, set this to 0
	 * if course has exam and 2 sub-component coursework, set this to 1
   */
	private int courseworkType = -1 ;	//Keep track of whether a course has subcomponents or not
								//0: exam and coursework only
								//1: subcomponents: Class participation and Assignment
	
	/** The lecture of this course. */
	Lecture lec= new Lecture();   //1 course has only ONE lecture
	
	/** The list of tutorials in this course. */
	//Course index will be the index of the ArrayList (same for both tut and lab)
	ArrayList<Tutorial> tuts= new ArrayList<Tutorial>();
	
	/** The list of laboratory in this course. */
	ArrayList<Lab> labs = new ArrayList<Lab>();
	
	/** The course structure.
	 *  Set to 1 if course only has lecture 
	 *  Set to 2 if course has lecture and tutorial 
	 *  Set to 3 if course has lecture, tutorial and lab
	 */
	int courseStructure ;
	
	/** The number of indices in this courses. */
	int noOfIndex ;
	
	/**
	 * Instantiates a new courses.
	 *
	 * @param courseID The id of the course 
	 */
	public Courses(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Instantiates a new courses without any parameter.
	 */
	public Courses() {}
	
	/**
	 * Register a course for a student.
	 *
	 * @param courseID The id of the course 
	 */
	public void registerCourse (String courseID) {
	this.courseID = courseID;
	this.register = true;
	}
	
	/**
	 * Sets the name of the course.
	 *
	 * @param name The name of the course
	 */
	public void setName(String name) {
		this.name = name;
		
	}
	
	/**
	 * Sets the course structure.
	 *
	 * @param structure The course structure
	 */
	public void setCourseStructure(int structure) {
		this.courseStructure = structure;
	}
	
	/**
	 * Gets the course structure.
	 *
	 * @return the course structure
	 */
	public int getCourseStructure() {
		return this.courseStructure;
	}
	
	/**
	 * Gets the name of the course.
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the course ID.
	 *
	 * @param ID The course ID
	 */
	public void setCourseID(String ID) {
		this.courseID = ID;
	}
	
	/**
	 * Gets the course ID.
	 *
	 * @return courseID
	 */
	public String getCourseID() {
		return this.courseID;
	}
	
	/**
	 * Sets the professor in charged of this course.
	 *
	 * @param prof The professor
	 */
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	/**
	 * Gets the professor name.
	 *
	 * @return the professor name
	 */
	public String getProf() {
		return this.prof.getName();
	}
	
	/**
	 * Sets the vacancy of the course.
	 *
	 * @param vacancy vacancy of the course
	 */
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	
	/**
	 * Gets the vacancy of the course.
	 *
	 * @return the vacancy
	 */
	public int getVacancy() {
		return this.vacancy;
	}
	
	/**
	 * Adds the student.
	 *
	 * @param stu the stu
	 */
	public void addStudent(Student stu) {
		this.student.add(stu);
	}
	
	/**
	 * Sets the capacity of the course.
	 *
	 * @param capacity the capacity of the course
	 */
	public void setCapacity(int capacity) {
		this.totalCapacity = capacity;
	}
	
	/**
	 * Gets the total capacity of the course.
	 *
	 * @return the total capacity of the course
	 */
	public int getTotalCapacity() {
		return this.totalCapacity;
	}
	
	/**
	 * Sets the coursework type for the course.
	 *
	 * @param type the new coursework type for the course
	 */
	public void setCourseworkType(int type) {
		this.courseworkType = type;
	}
	
	/**
	 * Gets the coursework type for the course.
	 *
	 * @return the coursework type for the course
	 */
	public int getCourseworkType() {
		return this.courseworkType;
	}
	
	/**
	 * Creates the index groups for the course. 
	 * For each index group, create one tutorial and one lab object, and add to their respective array lists.
	 *
	 * @param noOfIndex the no of index groups
	 * @param indexCapacity the capacity of each index group.
	 */
	//Create the details of index groups for course have tut/lab
	public void createIndex (int noOfIndex, int indexCapacity) {
		this.totalCapacity = noOfIndex * indexCapacity;
		this.noOfIndex = noOfIndex;
		if (this.courseStructure >= 2) {
			for (int i = 0 ; i < noOfIndex; i++) {
				Tutorial tut = new Tutorial();
				tut.setCapacity(indexCapacity);
				tut.setCourseID(this.courseID);
				tuts.add(tut);
			}
		}
		if (this.courseStructure == 3) {
			for (int i = 0 ; i < noOfIndex; i++) {
				Lab lab = new Lab();
				lab.setCapacity(indexCapacity);
				lab.setCourseID(this.courseID);
				labs.add(lab);
			}
		}
	}
	
	/**
	 * Register a student for an index group.
	 *
	 * @param student the student
	 * @param index the index group number
	 */
	//Course register for a student if course has tut/lab
	public void registerIndex(Student student, int index) {
		
		if(tuts.get(index).getVacancy() > 0) {
			this.addStudent(student);
			tuts.get(index).addStudent(student);	//add in to tut group
			tuts.get(index).updateVacancy();
			if(this.courseStructure == 3) {
				labs.get(index).addStudent(student);   //add into lag group
				labs.get(index).updateVacancy();
			}
		}
		lec.updateVacancy();	//add into lec
		lec.addStudent(student);
		
		
	}
	
	/**
	 * Register a student for a lecture group.
	 *
	 * @param student the student
	 */
	//Course register for a student if course has lec only
	public void registerIndex(Student student) {
		if(this.lec.getVacancy() > 0) {
			this.addStudent(student);
			lec.updateVacancy();
			lec.addStudent(student);
		}
	}
	
	/**
	 * Gets the exam weightage.
	 *
	 * @return the exam weightage
	 */
	public int getExamWeightage() {
		return this.examWeightage;
	}
	
	/**
	 * Sets the exam weightage.
	 *
	 * @param examWeightage the new exam weightage
	 */
	public void setExamWeightage(int examWeightage ) {
		this.examWeightage = examWeightage;
	}
	
	/**
	 * Gets the coursework weightage.
	 *
	 * @return the coursework weightage
	 */
	public int getCourseworkWeightage() {
		return this.courseworkWeightage;
	}
	
	/**
	 * Sets the coursework weightage.
	 *
	 * @param courseworkWeightage the new coursework weightage
	 */
	public void setCourseworkWeightage(int courseworkWeightage) {
		this.courseworkWeightage = courseworkWeightage;
	}
	
	/**
	 * Gets the assignment weightage.
	 *
	 * @return the assignment weightage
	 */
	public int getAssignmentWeightage() {
		return this.assignmentWeightage;
	}
	
	/**
	 * Sets the assignment weightage.
	 *
	 * @param assignmentWeightage the new assignment weightage
	 */
	public void setAssignmentWeightage(int assignmentWeightage) {
		this.assignmentWeightage = assignmentWeightage;
	}
	
	/**
	 * Gets the class participation weightage.
	 *
	 * @return the class participation weightage
	 */
	public int getClassParticipationWeightage() {
		return this.classParticipationWeightage;
	}
	
	/**
	 * Sets the class participation weightage.
	 *
	 * @param classParticipationWeightage the new class participation weightage
	 */
	public void setClassParticipationWeightage(int classParticipationWeightage) {
		this.classParticipationWeightage = classParticipationWeightage;
	}
	
	
}