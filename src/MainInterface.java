/**
 
 @author SS2 Group 5
 @version 1.0
 @since 2018-11-14

 */
import java.util.*;


/**
 * The Class MainInterface.
 */
public class MainInterface {

	/**
	 * The main method.
	 *
	 *@param args
	 */
	public static void main(String[] args) {
		String dataFile = "database.dat";
		StoreDatabase data = SerializeDB.readSerializedStoreDatabaseObject(dataFile);
		StudentApp student = data.getStudentData();  //Student App object, hold the Arraylist of Students as its attribute
		CourseApp course = data.getCourseData();		//Course App object, hold the ArrayList of Courses as its attribute
		
		//Get the list of Professor in 'professor.dat'
		List<Professor>profList = SerializeDB.readSerializedObject("professor.dat");
		int index;
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.print("\n");
		System.out.println("Enter your choice:");
		System.out.println("1: Add a student");
		System.out.println("2: Add a course");
		System.out.println("3: Register a course for a student");
		System.out.println("4: Check available vacancy");
		System.out.println("5: Print student list by lecture, tutorial or laboratory");
		System.out.println("6: Enter course assessment components weightage");
		System.out.println("7: Enter coursework mark");
		System.out.println("8: Enter exam mark");
		System.out.println("9: Print course statistics");
		System.out.println("10: Print student transcript");
		System.out.println("11: Exit");
		choice = 0;
		boolean valid = false;
		//Check if number entered is integer
	    do{
	        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
	            choice = sc.nextInt();
	            valid = true;
	        }
	        else{
	            System.out.println("Not a valid choice! Enter again:");
	            sc.next();
	        }
	    }
	    while(valid == false);
		switch (choice){
			case 1: 
				System.out.println("Enter student name: ");
				sc.nextLine();
				String sn = sc.nextLine();
				System.out.println("Enter student ID: ");
				String sID = sc.nextLine();
			    if(student.containsID(sID)) {
			    	System.out.println("Student already exists!");
			    	break;
			    }
			    System.out.println("Enter Program/Major: ");
			    String program = sc.nextLine();
			    
				System.out.println("Enter Year of Study: ");
				int year = 0 ;
				valid = false;
				//Check if number entered is integer
			    do{
			        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
			            year = sc.nextInt();
			            if(year<1 || year > 6)
			            	System.out.println("Year not valid!");
			            else
			            	valid = true;
			        }
			        else{
			            System.out.println("Not a valid year! Enter again:");
			            sc.next();
			        }
			    }
			    while(valid == false);
			    //Add the student to the list of Students
				student.addStudent(sn,sID, year,program);
			
				break;
			
			case 2:
				System.out.println("Enter course ID: ");
				sc.nextLine();
				String cID = sc.nextLine();
				while(course.containsID(cID)) {
					System.out.println("CourseID already exists, enter another ID: ");
					 cID = sc.nextLine();
				}
				System.out.println("Enter course name: ");
				String cn = sc.nextLine();
				
				Professor prof = new Professor();
				boolean exist = false;
				String profName = "";
				while (profName.isEmpty())
				{
					System.out.println("Enter course professor (coordinator) name: ");
					profName = sc.nextLine();
				}
				
				for(Professor i : profList) {
					if(i.getName().equals(profName)) {
						prof = i;
						exist = true;
						break; }
					}
				if (!exist) {
				prof.setName(profName);
				System.out.println("The professor is not in the data; please enter email: ");
				String email = sc.nextLine();
				prof.setEmail(email);
				System.out.println("Enter contact number: ");
				int contact = sc.nextInt();
				prof.setContact(contact);
				profList.add(prof);
				}
				do {
				System.out.println("Choose the course structure:");
				System.out.println("1: Lectures only");
				System.out.println("2: Lectures and Tutorials only");
				System.out.println("3: Lectures, Tutorial and Lab");
								
				int structure = 0;
				valid = false;
				//Check if number entered is integer
			    do{
			        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
			            structure = sc.nextInt();
			            valid = true;
			        }
			        else{
			            System.out.println("Not a valid choice! Enter again:");
			            sc.next();
			        }
			    }
			    while(valid == false);
				
				//When course have tut/lab
				if(structure > 1 && structure <= 3) {				
					System.out.println("Enter number of indices: ");
					valid = false;
					int noOfIndex = 0 ;
					//Check if number entered is integer
				    do{
				        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
				            noOfIndex = sc.nextInt();
				            valid = true;
				        }
				        else{
				            System.out.println("Not a valid integer! Enter again:");
				            sc.next();
				        }
				    }
				    while(valid == false);
					System.out.println("Enter index capacity: ");
					valid = false;
					int indexCapacity = 0 ;
					//Check if number entered integer
				    do{
				        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
				            indexCapacity = sc.nextInt();
				            valid = true;
				        }
				        else{
				            System.out.println("Not a valid integer! Enter again:");
				            sc.next();
				        }
				    }
				    while(valid == false);
					course.addCourse(cn,cID,prof,noOfIndex, indexCapacity,structure);
					break;
				}
				
				//When course have lecture only
				else if (structure==1){
					System.out.println("Enter total capacity:");
					int capacity = 0 ;
					valid = false;
					//Check if number entered is integer
				    do{
				        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
				            capacity = sc.nextInt();
				            valid = true;
				        }
				        else{
				            System.out.println("Not a valid integer! Enter again:");
				            sc.next();
				        }
				    }
				    while(valid == false);
					
					course.addCourse(cn, cID, prof, capacity,structure);
					break;
				}
				System.out.println("Input Error, please choose again");
				} while(true);
				
				break;
				
			case 3:
				if(student.s.size()==0) {
					System.out.println("There are currently no student; add a student first!");
					break;
				}
				
				if(course.c.size()==0) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
				
				System.out.println("Enter student ID:");
				sc.nextLine();
				String SID = sc.nextLine();
				while(!student.containsID(SID)) {
					System.out.println("Student not found in the data, please enter another ID: ");
					SID = sc.nextLine();
				}
				Student s=null;
				
				
				//Get the student with the ID entered
				for(Student i : student.s) {
					if(i.getStudentID().equals(SID)) {
						s = i;
						break;
					}
				}
				System.out.println("Enter course ID: ");
				String CID = sc.nextLine();
				while(!course.containsID(CID)) {
					System.out.println("Course not found in the data, please enter another ID: ");
					CID = sc.nextLine();
				}
				Courses crs=null;
				
				//Find the course with the ID entered
				for(Courses i : course.c) { 
					if(i.getCourseID().equals(CID)) {
						crs = i;
						break;
					}
				}
				
				boolean registered = false;
				//Check whether the student has already registered for this course
				for (Student stu : crs.student ) {
					if(stu == s) {
						System.out.println("Student already registered for this course!");
						registered = true;
						break;
					}
				}
				if(registered) {
					break;
				}
				
				valid = false;
				//Check vacancy of course with Lec only
				if(crs.getCourseStructure()==1) {
					if (crs.lec.getVacancy()==0) {
						System.out.println("No more vacancy!");
						break;
					}
					s.registerCourse(crs);
				}
				else {
				//Check with course having tut/lab
					for(Tutorial i: crs.tuts) {		//Check throughout all index 
						if (i.getVacancy()>0) {		//Check if an index have vacancy
							valid = true;
							break;
						}
					}
					if(!valid) {		//All indices have vacancy = 0
						System.out.println("No more vancancy for this course");
						break;
					}
					System.out.println("Enter the course index (from 0 to "+ (crs.noOfIndex - 1) +" ):");

					index = sc.nextInt();
					//Index out of bound
					while(index < 0 || index > crs.noOfIndex - 1) {
						System.out.println("There is no such index in this course, enter again: ");
						index = sc.nextInt();
					}

					while(crs.tuts.get(index).getVacancy() == 0) { //An index has no more vacancy
						System.out.println("No more vacancy in this index, enter another index:");
						index = sc.nextInt();
						
					}
						s.registerCourse(crs,index);
				}
				break;
				
			case 4: 
				if(course.c.size()==0) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
				
				sc.nextLine();
				boolean present = false;
				crs = null;
				while (present==false)
				{
					System.out.println("Enter a valid Course ID: ");
					cID = sc.nextLine();
					
					while(!course.containsID(cID)) {
						System.out.println("Course not found in the data, please enter another ID: ");
						cID = sc.nextLine();
					}
					
					for(Courses i : course.c) {
						if(i.getCourseID().equals(cID)) {
							crs = i;
							present = true;
							break;
						}
					}
				}

				//input vacancy from user
				if(crs.getCourseStructure()==1) { //If course have lec only
					System.out.println("Total vacancy: " + crs.lec.getVacancy()+"/"+crs.lec.getCapacity());
				}
				else { //Course have tut/lab
					System.out.println("Enter course index (from 0 to "+ (crs.noOfIndex - 1) +" ): ");
					index = sc.nextInt();
					while(index < 0 || index > crs.noOfIndex - 1) {
						System.out.println("There is no such index in this course, enter again: ");
						index = sc.nextInt();
					}
					
					System.out.println("Vacancy for this index: " + crs.tuts.get(index).getVacancy()+"/"+crs.tuts.get(index).getCapacity());
				}
				break;
			
			case 5:
				if(course.c.size()==0) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
				
				System.out.println("Enter course ID:");
				sc.nextLine();
				cID = sc.nextLine();
				
				//Check if course list contains course ID
				while(!course.containsID(cID)) {
					System.out.println("Course not found in the data, please enter another ID: ");
					cID = sc.nextLine();
				}
				crs = null;
				
				//Get course with the entered ID in course list
				for(Courses i : course.c) {
					if(i.getCourseID().equals(cID)) {
						crs = i;
						break;
					}
				}
				if(crs.getCourseStructure() == 1) {
					System.out.println("Print student list by lecture:");
					crs.lec.printStudent();
				}
				else if(crs.getCourseStructure() == 2) {
					System.out.println("Choose one of the following:");
					System.out.println("1: Print by lecture");
					System.out.println("2: Print by tutorial");
					while(true) {
						int c = 0;
						valid = false;
						//Check if number entered is integer
					    do{
					        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
					            c = sc.nextInt();
					            valid = true;
					        }
					        else{
					            System.out.println("Not a valid integer! Enter again:");
					            sc.next();
					        }
					    }
					    while(valid == false);
						if(c == 1) {
							System.out.println("Print student list by lecture:");
							crs.lec.printStudent();
							break;
						}
						else if(c == 2 ) {
							System.out.println("Print student list by tutorial:");
							for (index = 0; index < crs.noOfIndex; index++) {
								System.out.print("Index "+index+": ");
								crs.tuts.get(index).printStudent();
								System.out.print("\n");
							}
							break;
						}
						System.out.println("Wrong input, please enter again: ");
					}
					
				}
				else if(crs.getCourseStructure() == 3) {
					System.out.println("Choose one of the following:");
					System.out.println("1: Print by lecture");
					System.out.println("2: Print by tutorial");
					System.out.println("3: Print by laboratory");
					while(true) {
						int c = 0;
						valid = false;
						//Check if number entered is integer
					    do{
					        if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
					            c = sc.nextInt();
					            valid = true;
					        }
					        else{
					            System.out.println("Not a valid integer! Enter again:");
					            sc.next();
					        }
					    }
					    while(valid == false);
						if(c == 1) {
							System.out.println("Print student list by lecture:");
							crs.lec.printStudent();
							break;
						}
						else if(c == 2 ) {
							System.out.println("Print student list by tutorial:");
							for (index = 0; index < crs.noOfIndex; index++) {
								System.out.print("Index "+index+": ");
								crs.tuts.get(index).printStudent();
								System.out.print("\n");

							}
							break;
						}
						else if(c == 3) {
							System.out.println("Print student list by lab:");
							for (index = 0; index < crs.noOfIndex; index++) {
								System.out.print("Index "+index+": ");
								crs.labs.get(index).printStudent();
								System.out.print("\n");

							}
							break;
						}
						System.out.println("Wrong input, please enter again: ");
					}
					
				}
				break;
			case 6: 
				if(course.c.size()==0) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
				
				System.out.println("Enter course ID: ");
				sc.nextLine();
				cID = sc.nextLine();
			 
				//Check if course list contains course ID
				while(!course.containsID(cID)) {
					System.out.println("Course not found in the data, please enter another ID: ");
					cID = sc.nextLine();
				}
				crs = null;
				
				//Get course with the entered ID in course list
				for(Courses i : course.c) {
					if(i.getCourseID().equals(cID)) {
						crs = i;
						break;
					}
				}
				
				//When course has already been set up with weightage
				if(crs.getCourseworkType()!=-1) {
					System.out.println("Course's weightage has already been set up!");
					do {
					System.out.println("1: Reset the component's weightage");
					System.out.println("2: Exit this option");
					int c = 0;
					valid = false;
					//check if choice entered is an integer
					do	{
					    if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
					        c = sc.nextInt();
					        valid = true;
					    }
					    else{
					        System.out.println("Not a valid integer! Enter again:");
					        sc.next();
					    }
						} while(valid == false);
					if(c == 1) {
						crs.setCourseworkType(-1);
						break;
					}
					else if(c == 2) {
						break;
					}
					
					System.out.println("Invalid choice, enter again!");
					} while(true);
				}
				if(crs.getCourseworkType()==-1) {  //when course weightage has not been set up 
					int c;
					do {
					System.out.println("Choose the type of coursework:");
					System.out.println("1: Course with only exam and 1 main coursework");
					System.out.println("2: Course with exam and coursework has subcomponents: Class participation and Assignment");
					c = 0;
					valid = false;
					//check if choice entered is an integer
					do{
					    if(sc.hasNextInt()){ // This checks to see if the next input is a valid **int**
					        c = sc.nextInt();
					        valid = true;
					    }
					    else{
					        System.out.println("Not a valid integer! Enter again:");
					        sc.next();
					    }
					} while(valid == false);
					if(c!=1 && c!= 2)
						System.out.println("Not a valid choice. Enter again!");
					}  while(c!= 1 && c != 2);
					
					//Enter exam weightage ( always have exam weightage )
					System.out.println("Enter exam weightage between 0 and 100 (%): ");
					int examWeightage = 0 ;
					valid = false;
					//Check if entered weightage is an integer between 0 and 100
					do{
						if(sc.hasNextInt()){ // This checks to see if the next input is a valid 0<int<10
							examWeightage = sc.nextInt();
										
							if(examWeightage >= 100 || examWeightage <= 0 ) {
								System.out.println("Exam weightage must be between 0 and 100 (%)! Enter again:");
							}
							else
								valid = true;
						}
						else {
							System.out.println("Not a valid weightage! Enter again:");
							sc.next();
						}
					} while(valid == false );
					
					crs.setExamWeightage(examWeightage);
					System.out.println("Successfully set exam weightage to be " + crs.getExamWeightage()+" %");
					
					//Set coursework weightage for course type(0)
					if(c == 1) {
						crs.setCourseworkType(0);	
						crs.setCourseworkWeightage(100 - examWeightage);	
						System.out.println("The Coursework weightage is set to be "+crs.getCourseworkWeightage()+" %");
					}
					//Set sub-component weightage for course type(1)
					else if(c==2) {
						crs.setCourseworkWeightage(100 - examWeightage);	
						System.out.println("The Coursework weightage is set to be "+crs.getCourseworkWeightage()+" %");
						crs.setCourseworkType(1);	
						System.out.println("Enter Assignment weightage between 0 and 100 (%): ");
						int assignmentWeightage = 0 ;
						valid = false;
						//Check if entered weightage is an integer between 0 and 100
						do{
						    if(sc.hasNextInt()){ // This checks to see if the next input is a valid 0<int<100
						        assignmentWeightage = sc.nextInt();
						        if(assignmentWeightage >= 100 || assignmentWeightage <= 0 ) {
									System.out.println("Assignment weightage must be between 0 and 100 (%)! Enter again:");
								}
								else
									valid = true;
						    }
						    else{
						        System.out.println("Not a valid weightage! Enter again:");
						        sc.next();
						    }
						} while(valid == false);
						crs.setAssignmentWeightage(assignmentWeightage);
						System.out.println("Successfully set Assignment weightage to be "+crs.getAssignmentWeightage()+" %");
						//Set assignment weightage by 100 - classParticipation
						crs.setClassParticipationWeightage(100 - assignmentWeightage);
						System.out.println("Class participation weightage is set to be "+crs.getClassParticipationWeightage()+" %");
						
					}
				}
				break;
			
			case 7:
				//Check if there are currently no student
				if(student.s.size()==0) {
					System.out.println("There are currently no student; add a student first!");
					break;
				}
				//Check if there are currently no course
				if(course.c.size()==0) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
				
				System.out.println("Enter student ID:");
				sc.nextLine();
				SID = sc.nextLine();
				while(!student.containsID(SID)) {
					System.out.println("Student not found in the data, please enter another ID: ");
					SID = sc.nextLine();
				}
				
				s = null;
								
				//Get the student with the ID entered
				for(Student i : student.s) {
					if(i.getStudentID().equals(SID)) {
						s = i;
						break;
					}
				}
				if (s.course.size() == 0) {
					System.out.println("This student has not registerd for any course, please register course for this student first");
					break;
				}
				System.out.println("Enter course ID: ");
				cID = sc.nextLine();
			 
				//Check if course list contains course ID entered
				while(!course.containsID(cID)) {
					System.out.println("Course not found in the data, please enter another ID: ");
					cID = sc.nextLine();
				}

				crs = null;
				//Get course with the entered ID in course list
				for(Courses i : course.c) {
					if(i.getCourseID().equals(cID)) {
						crs = i;
						break;
					}
				}
				
		
				
				//Get the index of the course in the list of courses registered by the
				//student with ID entered by the user
				index = -1;				
				for(int i = 0; i < s.course.size() ; i++) {
					if (s.course.get(i).getCourseID().equals(cID))
					{	index = i;
						break; }
				}
				
				if (index == -1) {
					System.out.println("Student has not registered for this course yet!");
					break;
				}
				
				if(crs.getCourseworkType()==-1) {
					System.out.println("This course has coursework structure undefined!");
					System.out.println("Define the coursework weightages first!");
					break;
				}
				else if(crs.getCourseworkType()==0) {
					//Enter coursework
					System.out.println("Enter Coursework mark (from 0 to 100): ");
					double coursework = 0 ;
					valid = false;
					//Check if entered weightage is an integer between 0 and 100
					do{
					    if(sc.hasNextDouble()){ // This checks to see if the next input is a valid 0<int<100
					        coursework = sc.nextDouble();
					        if(coursework >= 100 || coursework <= 0 ) {
								System.out.println("Coursework mark must be between 0 and 100! Enter again:");
							}
							else
								valid = true;
					    }
					    else{
					        System.out.println("Not a valid Coursework mark! Enter again:");
					        sc.next();
					    }
					} while(valid == false);
					s.grade.get(index).setCoursework(coursework);
					
				}
				
				else if(crs.getCourseworkType()==1) {
					//Enter Assignment
					System.out.println("Enter Assignment mark (from 0 to 100): ");
					double assignment = 0 ;
					valid = false;
					//Check if entered weightage is an integer between 0 and 100
					do{
					    if(sc.hasNextDouble()){ // This checks to see if the next input is a valid 0<int<100
					        assignment = sc.nextDouble();
					        if(assignment > 100 || assignment < 0 ) {
								System.out.println("Assignment mark must be between 0 and 100! Enter again:");
							}
							else
								valid = true;
					    }
					    else{
					        System.out.println("Not a valid Assignment mark! Enter again:");
					        sc.next();
					    }
					} while(valid == false);
					s.grade.get(index).setAssignment(assignment);
					
					//Enter Class participation
					System.out.println("Enter Class Participation mark (from 0 to 100): ");
					double classParticipation = 0 ;
					valid = false;
					//Check if entered weightage is an integer between 0 and 100
					do{
					    if(sc.hasNextDouble()){ // This checks to see if the next input is a valid 0<int<100
					        classParticipation = sc.nextDouble();
					        if(classParticipation > 100 || classParticipation < 0 ) {
								System.out.println("Class Participation mark must be between 0 and 100! Enter again:");
							}
							else
								valid = true;
					    }
					    else{
					        System.out.println("Not a valid Class Participation mark! Enter again:");
					        sc.next();
					    }
					} while(valid == false);
					s.grade.get(index).setClassParticipation(classParticipation);
				}
				
				break;
				
			case 8:
				sc.nextLine();
				//Check if there are currently no student
				if(student.s.size()==0) {
					System.out.println("There are currently no student; add a student first!");
					break;
				}
				//Check if there are currently no course
				if(course.c.size()==0) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
					
				System.out.println("Enter student ID:");
				SID = sc.nextLine();
				while(!student.containsID(SID)) {
					System.out.println("Student not found in the data, please enter another ID: ");
					SID = sc.nextLine();
				}
				s=null;
				
				
				//Get the student with the ID entered
				for(Student i : student.s) {
					if(i.getStudentID().equals(SID)) {
						s = i;
						break;
					}
				}
				
				if (s.course.size() == 0) {
					System.out.println("This student has not registered for any course, please register course for this student first");
					break;
				}
				System.out.println("Enter course ID: ");
				CID = sc.nextLine();
				while(!course.containsID(CID)) {
					System.out.println("Course not found in the data, please enter another ID: ");
					CID = sc.nextLine();
				}
				crs=null;
				
				//Find the course with the ID entered
				for(Courses i : course.c) { 
					if(i.getCourseID().equals(CID)) {
						crs = i;
						break;
					}
				}
				index = -1;				
				for(int i = 0; i < s.course.size() ; i++) {
					if (s.course.get(i).getCourseID().equals(CID))
						{index = i;
						break; }
				}
				if (index == -1) {
					System.out.println("This student has not registered for this course before");
					break;
				}
				//Enter exam mark
				System.out.println("Enter exam mark (from 0 to 100): ");
				double exam = 0 ;
				valid = false;
				//Check if entered mark is an double between 0 and 100
				do{
				    if(sc.hasNextDouble()){ // This checks to see if the next input is a valid 0<int<100
				        exam = sc.nextDouble();
				        if(exam > 100 || exam < 0 ) {
							System.out.println("Exam mark must be between 0 and 100! Enter again:");
						}
						else
							valid = true;
				    }
				    else{
				        System.out.println("Not a valid Class Participation mark! Enter again:");
				        sc.next();
				    }
				} while(valid == false);
				s.grade.get(index).setExam(exam);
				break;
			case 9: 
				sc.nextLine();
				if (course.c.isEmpty()) {
					System.out.println("There are currently no course; add a course first!");
					break;
				}
				
				System.out.println("Enter course ID: ");
				CID = sc.nextLine();
				while(!course.containsID(CID)) {
					System.out.println("Course not found in the data, please enter another ID: ");
					CID = sc.nextLine();
				}
				crs=null;
				
				//Find the course with the ID entered
				for(Courses i : course.c) { 
					if(i.getCourseID().equals(CID)) {
						crs = i;
						break;
					}
				}
				System.out.println("Name: "+crs.getName()+"    CourseCode: "+crs.getCourseID()+"    Coordinator: Prof "+crs.getProf());
				System.out.println("Total number of students registered this course: "+crs.student.size());
				
				if (crs.getCourseStructure() == 1) {
					System.out.println("This course only has lecture");
					System.out.printf("Lecture capacity: %d\n",crs.lec.getCapacity());
					System.out.println("Lecture vacancy: "+crs.lec.getVacancy());
				}
				else if (crs.getCourseStructure() == 2){
					System.out.println("This course only has lecture and tutorial classes");
					System.out.println("Total course capacity: "+crs.getTotalCapacity());
					System.out.println("Total vacancies: "+(crs.getTotalCapacity()-crs.student.size()));
				}
				else {
					System.out.println("This course has lecture, tutorials and labs");
					System.out.println("Total course capacity: "+crs.getTotalCapacity());
					System.out.println("Total vacancies: "+(crs.getTotalCapacity()-crs.student.size()));
				}
				
				if (crs.student.isEmpty()) {
					System.out.println("No grade statistics available (No student has registered for this course)");
					break;
				}
				
				double D=0;
				double C=0;
				double B=0;
				double A=0;
				double unknown=0;
				double groupA=0;
				double groupB=0;
				double groupC=0;
				double groupD=0;
				double groupUnknown=0;
				valid = false;
				int opt=0;
				while (valid==false)
				{
					System.out.println("Please enter your option (1, 2, 3): ");
					System.out.println("1. Coursework statistics\n"
							+ "2. Exam statistics\n"
							+ "3. Overall grade statistics");
					if (sc.hasNextInt())
					{
						opt = sc.nextInt();
						if ((opt>=1)&&(opt<=3))
						{
							valid = true;
						}
					}
					else 
					{
						System.out.println("Invalid choice, please enter again");
						sc.next();
					}
				}
				
				if (opt==1)
				{
					if (crs.getCourseworkType() == -1) {
						unknown = crs.student.size();
					} else {
						for (Student i: crs.student) {
							if (crs.getCourseworkType() == 0) {
								index = -1;
								for (int j=0; j<i.course.size(); j++) {
									if (i.course.get(j).getCourseID().equals(CID)) {
										index = j;
										break;
									}
								}
								Grades grade = i.grade.get(index);
								if (grade.getCoursework() != -1) {
									if (grade.getCoursework()>=75)
										A++;
									else if (grade.getCoursework()>=51)
										B++;
									else if (grade.getCoursework()>=26)
										C++;
									else D++;
								} else unknown++;
										
							} else {
								index = -1;
								for (int j=0; j<i.course.size(); j++) {
									if (i.course.get(j).getCourseID().equals(CID)) {
										index = j;
										break;
									}
								}
								Grades grade = i.grade.get(index);
								if (grade.getAssignment() != -1) {
									grade.calCoursework();
									if (grade.getCoursework()>=75)
										A++;
									else if (grade.getCoursework()>=51)
										B++;
									else if (grade.getCoursework()>=26)
										C++;
									else D++;
								} else unknown++;
							}
						}
					}
					groupA = A/crs.student.size() * 100.0;
					groupB = B/crs.student.size() * 100.0;
					groupC = C/crs.student.size() * 100.0;
					groupD = D/crs.student.size() * 100.0;
					groupUnknown = unknown/crs.student.size() * 100.0;
					System.out.println("The below table shows grade percentage of this course");
					System.out.printf("GradeGroup %6s 0-25 %3s 26-50 %3s 51-74 %2s 75-100 %3s unknown \n", " ", " ", " ", " ", " ");
					System.out.printf("Coursework   %8.2f%% %8.2f%% %8.2f%% %8.2f%% %8.2f%% \n", groupD, groupC, groupB, groupA, groupUnknown);
				}
					
				else if (opt==2)
				{
					if (crs.getCourseworkType() == -1) {
						unknown = crs.student.size();
					} else {
						for (Student i: crs.student) {
							index = -1;
							for (int j=0; j<i.course.size(); j++) {
								if (i.course.get(j).getCourseID().equals(CID)) {
									index = j;
									break;
								}
							}
							Grades grade = i.grade.get(index);
							if (grade.getExam() != -1) {
								if (grade.getExam()>=75)
									A++;
								else if (grade.getExam()>=51)
									B++;
								else if (grade.getExam()>=26)
									C++;
								else D++;
							} else unknown++;
								
						}
					}
					groupA = A/crs.student.size() * 100.0;
					groupB = B/crs.student.size() * 100.0;
					groupC = C/crs.student.size() * 100.0;
					groupD = D/crs.student.size() * 100.0;
					groupUnknown = unknown/crs.student.size() * 100.0;
					System.out.println("The below table shows grade percentage of this course");
					System.out.printf("GradeGroup %6s 0-25 %3s 26-50 %3s 51-74 %2s 75-100 %3s unknown \n", " ", " ", " ", " ", " ");
					System.out.printf("Exam         %8.2f%% %8.2f%% %8.2f%% %8.2f%% %8.2f%% \n", groupD, groupC, groupB, groupA, groupUnknown);
				}
					
				else
				{
					if (crs.getCourseworkType() == -1) {
						unknown = crs.student.size();
					} else {
						for (Student i: crs.student) { 
							index = -1;
							for (int j=0; j<i.course.size(); j++) {
								if (i.course.get(j).getCourseID().equals(CID)) {
									index = j;
									break;
								}
							}
							Grades grade = i.grade.get(index);
							if (crs.getCourseworkType() == 0) {
								if (grade.getExam() != -1 && grade.getCoursework() != -1) {
									grade.calOverallGrade();
									if (grade.getOverallGrade()>=75)
										A++;
									else if (grade.getOverallGrade()>=51)
										B++;
									else if (grade.getOverallGrade()>=26)
										C++;
									else D++;
								} else unknown++;
							} else {
								if (grade.getExam() != -1 && grade.getAssignment() != -1) {
									grade.calCoursework();
									grade.calOverallGrade();
									if (grade.getOverallGrade()>=75)
										A++;
									else if (grade.getOverallGrade()>=51)
										B++;
									else if (grade.getOverallGrade()>=26)
										C++;
									else D++;
								} else unknown++;
							}
						}
							
					}
					groupA = A/crs.student.size() * 100.0;
					groupB = B/crs.student.size() * 100.0;
					groupC = C/crs.student.size() * 100.0;
					groupD = D/crs.student.size() * 100.0;
					groupUnknown = unknown/crs.student.size() * 100.0;
					System.out.println("The below table shows grade percentage of this course");
					System.out.printf("GradeGroup %6s 0-25 %3s 26-50 %3s 51-74 %2s 75-100 %3s unknown \n", " ", " ", " ", " ", " ");
					System.out.printf("OverallGrade %8.2f%% %8.2f%% %8.2f%% %8.2f%% %8.2f%% \n", groupD, groupC, groupB, groupA, groupUnknown);
				}
			break;
				
			case 10:
				sc.nextLine();
				//Check if there are currently no student
				if(student.s.size()==0) {
					System.out.println("There are currently no student; add a student first!");
					break;
				}
				
				System.out.println("Enter student ID:");
				SID = sc.nextLine();
				while(!student.containsID(SID)) {
					System.out.println("Student not found in the data, please enter another ID: ");
					SID = sc.nextLine();
				}
				s=null;
				
				
				//Get the student with the ID entered
				for(Student i : student.s) {
					if(i.getStudentID().equals(SID)) {
						s = i;
						break;
					}
				}
				
				if (s.grade.size() == 0) {
					System.out.println("This student has not registerd any course yet");
					break;
				}
				
				for (Grades i: s.grade) {
					System.out.print(i.course.getName()+"("+i.course.getCourseID()+"): ");
					if (i.course.getCourseworkType() == -1)
						System.out.println("Cannot compute grade for this course, please enter assessment components weightage first");
					else if (i.course.getCourseworkType() == 0) {
						if (i.getCoursework() == -1 ) {
							System.out.println("Cannot compute grade for this course, please enter coursework mark for this student first");
						} else if (i.getExam() == -1) {
							System.out.println("Cannot compute grade for this course, please enter exam mark for this student first");
						} else {
							i.calOverallGrade();
							System.out.printf("Coursework(%d%% overall): %.1f/100    Exam(%d%% overall): %.1f/100    Overall: %.1f/100(%s)\n", 
									i.course.getCourseworkWeightage(),i.getCoursework(),i.course.getExamWeightage(), i.getExam(), i.getOverallGrade(),i.convertOverall(i.getOverallGrade()));
						}
					} else {
						if (i.getAssignment() == -1) {
							System.out.println("Cannot compute grade for this course, please enter assignment and class participation mark for this student first");
						} else if (i.getExam() == -1) {
							System.out.println("Cannot compute grade for this course, please enter exam mark for this student first");
						}
						else {
							i.calCoursework();
							i.calOverallGrade();
							System.out.printf("Assignment(%d%% of Coursework): %.1f  ClassParticipation(%d%% of Coursework): %.1f   Coursework(%d%% overall): %.1f/100   Exam(%d%% overall): %.1f/100   Overall: %.1f/100(%s)\n",
								i.course.getAssignmentWeightage(),i.getAssignment(),i.course.getClassParticipationWeightage(), i.getClassParticipation(),i.course.getCourseworkWeightage(), i.getCoursework(),i.course.getExamWeightage(),i.getExam(), i.getOverallGrade(),i.convertOverall(i.getOverallGrade()));
						}
					}
					
				}
				break;

				
			}
		} while (choice < 11 && choice > 0) ;
		
		if (choice==11)
		{
			System.out.println("Terminated");
			SerializeDB.writeSerializedStoreDatabaseObject(dataFile, data);
			SerializeDB.writeSerializedObject("professor.dat", profList);
		}
	}
}