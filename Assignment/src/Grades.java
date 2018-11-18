/**
Represent every grades of a student in a specific course
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/
import java.io.Serializable;

/**
* The Class Grades.
*/
public class Grades implements Serializable {
	
	/** The exam mark. */
	private double exam=-1;
	
	/** The coursework mark. */
	private double coursework=-1;
	
	/** The assignment mark. */
	private double assignment=-1;
	
	/** The class participation mark. */
	private double classParticipation=-1;
	
	/** The course related to this grade. */
	public Courses course;
	
	/** The overall grade. */
	private double overallGrade=-1;
		
	/**
	 * Instantiates a new grades.
	 * Relate to a course
	 * @param crs The course related to this grade
	 */
	public Grades(Courses crs) {
		this.course = crs;
	}
	
	/**
	 * Gets the exam mark.
	 *
	 * @return the exam mark
	 */
	public double getExam() {
		return this.exam;
	}
	
	/**
	 * Sets the exam mark.
	 *
	 * @param Exam the exam mark
	 */
	public void setExam(double Exam) {
		this.exam = Exam;
	}
	
	/**
	 * Calculate coursework mark.
	 */
	public void calCoursework() {
		
		//If course has assignment and class participation
		this.coursework = (this.course.getAssignmentWeightage() * this.assignment + this.course.getClassParticipationWeightage() * this.classParticipation)/100 ;
	}
	
	/**
	 * Calculate overall grade.
	 */
	public void calOverallGrade() {
		this.overallGrade = this.course.getExamWeightage() * this.exam / 100 + this.coursework * this.course.getCourseworkWeightage()/100;
	}
	
	/**
	 * Sets the coursework mark.
	 *
	 * @param coursework mark.
	 */
	public void setCoursework(double coursework) {
		this.coursework = coursework;
	}
	
	/**
	 * Gets the coursework mark.
	 *
	 * @return the coursework mark
	 */
	public double getCoursework() {
		return this.coursework;
	}
	
	/**
	 * Gets the assignment mark.
	 *
	 * @return the assignment mark
	 */
	public double getAssignment() {
		return this.assignment;
	}
	
	/**
	 * Sets the assignment mark.
	 *
	 * @param Assignment mark
	 */
	public void setAssignment(double Assignment) {
		this.assignment = Assignment;
	}
	
	/**
	 * Gets the class participation mark.
	 *
	 * @return the class participation mark
	 */
	public double getClassParticipation() {
		return this.classParticipation;
	}
	
	/**
	 * Sets the class participation mark.
	 *
	 * @param ClassParticipation make
	 */
	public void setClassParticipation(double ClassParticipation) {
		this.classParticipation = ClassParticipation;
	}
	
	/**
	 * Gets the overall grade.
	 *
	 * @return the overall grade
	 */
	public double getOverallGrade() {
		return this.overallGrade;
	}
	
	/**
	 * Convert overall grade to letter.
	 *
	 * @param grade to convert
	 * @return the letter
	 */
	public String convertOverall(double grade) {
		if(grade>80 && grade <= 100)
			return "A";
		else if(grade >70 && grade <= 80)
			return "B";
		else if(grade >60 && grade <= 70)
			return "C";
		else if(grade >50 && grade <= 60)
			return "D";
		else if (grade <= 50)
			return "F";
		else
			return "Invalid grade!";
	}
}

