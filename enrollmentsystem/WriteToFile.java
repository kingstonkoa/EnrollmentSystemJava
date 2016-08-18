package enrollmentsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author John
 * 
 */
public class WriteToFile {

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");
	
	//CSV file header
	private static final String FILE_HEADER_STUDENT = "studentID,password,lastName,firstName,minUnits,maxUnits";
        private static final String FILE_HEADER_COURSE = "code,name,units";
        private static final String FILE_HEADER_SECTION = "code,section,capacity,day,startH,startM,endH,endM,enrollCount";
	public static void WriteStudentToFile(String fileName, Student student) {
		
		FileWriter fileWriter = null;
                
                File f = new File(fileName);
                if(f.exists() && !f.isDirectory()) {
                                        try {
                            fileWriter = new FileWriter(fileName, true);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(String.valueOf(student.getIdNumber()));
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(student.getPassword());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(student.getLastName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(student.getFirstName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(String.valueOf(student.getMinUnits()));
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(String.valueOf(student.getMaxUnits()));
                                    fileWriter.append(NEW_LINE_SEPARATOR);




                            JOptionPane.showMessageDialog(null,
							"Student Registration Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in registering studnet");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
                    
                }
                else
                {
				
                    try {
                            fileWriter = new FileWriter(fileName);

                            //Write the CSV file header
                            fileWriter.append(FILE_HEADER_STUDENT);

                            //Add a new line separator after the header
                            fileWriter.append(NEW_LINE_SEPARATOR);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(String.valueOf(student.getIdNumber()));
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(student.getPassword());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(student.getLastName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(student.getFirstName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(String.valueOf(student.getMinUnits()));
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(String.valueOf(student.getMaxUnits()));
                                    fileWriter.append(NEW_LINE_SEPARATOR);




                            JOptionPane.showMessageDialog(null,
							"Student Registered Successfully");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in registering student");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
            }
	}

	public static void WriteStudentListToFile(String fileName, ArrayList<Student> studentList) {
		
		FileWriter fileWriter = null;
                
                File f = new File(fileName);
				
                    try {
                            fileWriter = new FileWriter(fileName);

                            //Write the CSV file header
                            fileWriter.append(FILE_HEADER_STUDENT);

                            //Add a new line separator after the header
                            fileWriter.append(NEW_LINE_SEPARATOR);

                            //Write a new student object list to the CSV file

                           for(int i = 0; i < studentList.size(); i++)
                            {
                                    fileWriter.append(String.valueOf(studentList.get(i).getIdNumber()));
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(studentList.get(i).getPassword());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(studentList.get(i).getLastName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(studentList.get(i).getFirstName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(String.valueOf(studentList.get(i).getMinUnits()));
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(String.valueOf(studentList.get(i).getMaxUnits()));
                                    fileWriter.append(NEW_LINE_SEPARATOR);

                            }


                            JOptionPane.showMessageDialog(null,
							"Student Edit Successfully");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in editing student");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
            
	}

	public static void WriteCourseToFile(String fileName, Course course) {
		
		FileWriter fileWriter = null;
                
                File f = new File(fileName);
                if(f.exists() && !f.isDirectory()) {
                                        try {
                            fileWriter = new FileWriter(fileName, true);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(course.getCode());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(course.getName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(course.getUnits());
                                    fileWriter.append(NEW_LINE_SEPARATOR);




                            JOptionPane.showMessageDialog(null,
							"Add Course Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in adding course");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
                    
                }
                else
                {
				
                    try {
                            fileWriter = new FileWriter(fileName);

                            //Write the CSV file header
                            fileWriter.append(FILE_HEADER_COURSE);

                            //Add a new line separator after the header
                            fileWriter.append(NEW_LINE_SEPARATOR);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(course.getCode());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(course.getName());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(course.getUnits());
                                    fileWriter.append(NEW_LINE_SEPARATOR);




                            JOptionPane.showMessageDialog(null,
							"Add Course Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in adding course");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
            }
	}

	public static void WriteSectionToFile(String fileName, Section section) {
		
		FileWriter fileWriter = null;
                
                File f = new File(fileName);
                if(f.exists() && !f.isDirectory()) {
                                        try {
                            fileWriter = new FileWriter(fileName, true);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(section.getCode());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getSection());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getCapacity());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getDay());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEnrolledCount());
                                    fileWriter.append(NEW_LINE_SEPARATOR);
                                    




                            JOptionPane.showMessageDialog(null,
							"Open Section Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in Opening section");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
                    
                }
                else
                {
				
                    try {
                            fileWriter = new FileWriter(fileName);

                            //Write the CSV file header
                            fileWriter.append(FILE_HEADER_SECTION);

                            //Add a new line separator after the header
                            fileWriter.append(NEW_LINE_SEPARATOR);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(section.getCode());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getSection());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getCapacity());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getDay());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEnrolledCount());
                                    fileWriter.append(NEW_LINE_SEPARATOR);




                            JOptionPane.showMessageDialog(null,
							"Open Section Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in opening section");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
            }
	}
        public static void WriteStudentEnlistToFile(String fileName, Section section) {
		
		FileWriter fileWriter = null;
                
                File f = new File(fileName);
                if(f.exists() && !f.isDirectory()) {
                                        try {
                            fileWriter = new FileWriter(fileName, true);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(section.getCode());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getSection());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getCapacity());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getDay());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEnrolledCount());
                                    fileWriter.append(NEW_LINE_SEPARATOR);
                                    




                            JOptionPane.showMessageDialog(null,
							"Enlisted Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in enlisting section");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
                    
                }
                else
                {
				
                    try {
                            fileWriter = new FileWriter(fileName);

                            //Write the CSV file header
                            fileWriter.append(FILE_HEADER_SECTION);

                            //Add a new line separator after the header
                            fileWriter.append(NEW_LINE_SEPARATOR);

                            //Write a new student object list to the CSV file

                                    fileWriter.append(section.getCode());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getSection());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getCapacity());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getDay());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getStartMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndHour());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEndMinute());
                                    fileWriter.append(COMMA_DELIMITER);
                                    fileWriter.append(section.getEnrolledCount());
                                    fileWriter.append(NEW_LINE_SEPARATOR);




                            JOptionPane.showMessageDialog(null,
							"Enlisted Successfull!");

                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
							"Error in enlisting section");
                            e.printStackTrace();
                    } finally {

                            try {
                                    fileWriter.flush();
                                    fileWriter.close();
                            } catch (IOException e) {
                                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                            }

                    }
            }
	}
}


