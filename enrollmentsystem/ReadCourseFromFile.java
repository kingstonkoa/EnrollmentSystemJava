/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author John
 */

public class ReadCourseFromFile {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Student attributes index
	private static final int COURSE_CODE_IDX = 0;
	private static final int COURSE_NAME_IDX = 1;
	private static final int COURSE_UNITS_IDX = 2;
        private ArrayList<Course> courses;
	
	public void readFile(String fileName) {

		BufferedReader fileReader = null;
     
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	courses = new ArrayList();
        	
            String line = "";
            
            if(new File(fileName).exists())
            {
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
					Course course = new Course(tokens[COURSE_CODE_IDX], tokens[COURSE_NAME_IDX], tokens[COURSE_UNITS_IDX]);
					courses.add(course);
				}
            }
        }
           
        } 
        catch (Exception e) {
        	System.out.println("Error in EeadFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null)
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

	}
        
        public ArrayList<Course> getRegisteredCourses()
        {
            return this.courses;
        }

}


