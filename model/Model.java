/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enrollmentsystem.Course;
import enrollmentsystem.ReadCourseFromFile;
import enrollmentsystem.ReadEnlistmentFromFile;
import enrollmentsystem.ReadSectionFromFile;
import enrollmentsystem.ReadStudentFromFile;
import enrollmentsystem.Section;
import enrollmentsystem.Student;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public class Model
{
    private ArrayList<Student> registeredStudentsList;
    private ArrayList<Course> registeredCoursesList;
    private ArrayList<Section> openedSectionList;
    private ArrayList<Section> enlistedSectionList;
    private ArrayList<Section> enrolledSectionList;
    private ReadStudentFromFile r;
    private ReadCourseFromFile c;
    private ReadSectionFromFile s;
    private ReadEnlistmentFromFile e;
    private final String studentRecordFileName = "studentsDatabase.txt";
    private final String courseRecordFileName = "coursesDatabase.txt";
    private final String sectionRecordFileName = "sectionsDatabase.txt";
    public Model()
    {
        r = new ReadStudentFromFile();
        c = new ReadCourseFromFile();
        s = new ReadSectionFromFile();
        e = new ReadEnlistmentFromFile();
    }
    
    public void readRegisteredStudents()
    {
        r.readFile(studentRecordFileName);
        registeredStudentsList = r.getRegisteredStudents();
    }
    public ArrayList<Student> getRegisteredStudents()
   {
       return this.registeredStudentsList;
   }

    public void readCourses()
    {
        c.readFile(courseRecordFileName);
        registeredCoursesList = c.getRegisteredCourses();
        
    }

   public ArrayList<Course> getRegisteredCourses()
   {
       return this.registeredCoursesList;
   }

    public void readSections()
    {
       s.readFile(sectionRecordFileName);
       openedSectionList = s.getRegisteredSections();
    }

   public ArrayList<Section> getOpenedSections()
   {
       return this.openedSectionList;
   }

    public void readEnlisted(String filename)
    {
        e.readFile(filename);
        enlistedSectionList = e.getEnlistedSections();
    }
    
   public ArrayList<Section> getEnlistedSections()
   {
       return this.enlistedSectionList;
   }

    public void readEnrolled(String filename)
    {
        e.readFile(filename);
        enrolledSectionList = e.getEnlistedSections();
    }
    
    public ArrayList<Section> getEnrolledSections()
   {
       return this.enrolledSectionList;
   }
    
}
