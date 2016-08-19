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

public class ReadSectionFromFile {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Student attributes index
	private static final int COURSE_CODE_IDX = 0;
	private static final int COURSE_SECTION_IDX = 1;
	private static final int COURSE_CAPACITY_IDX = 2;
        private static final int COURSE_DAY_IDX = 3;
        private static final int COURSE_STARTH_IDX = 4;
        private static final int COURSE_STARTM_IDX = 5;
        private static final int COURSE_ENDH_IDX = 6;
        private static final int COURSE_ENDM_IDX = 7;
        private static final int COURSE_ECNT_IDX = 8;
        private static final int COURSE_FACULTY_IDX = 9;
        private ArrayList<Section> sections;
	
	public void readFile(String fileName) {

		BufferedReader fileReader = null;
     
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	sections = new ArrayList();
        	
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
					Section section = new Section(tokens[COURSE_CODE_IDX], tokens[COURSE_SECTION_IDX], tokens[COURSE_CAPACITY_IDX], tokens[COURSE_DAY_IDX], tokens[COURSE_STARTH_IDX], tokens[COURSE_STARTM_IDX], tokens[COURSE_ENDH_IDX], tokens[COURSE_ENDM_IDX], tokens[COURSE_ECNT_IDX], tokens[COURSE_FACULTY_IDX]);
					sections.add(section);
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
        
        public ArrayList<Section> getRegisteredSections()
        {
            return this.sections;
        }

}


