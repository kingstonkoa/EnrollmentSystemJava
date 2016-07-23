package enrollmentsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author John
 * 
 */
public class WriteStudentToFile {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");
	
	//CSV file header
	private static final String FILE_HEADER = "studentID,password,lastName,firstName,minUnits,maxUnits";

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
                            fileWriter.append(FILE_HEADER);

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
}


