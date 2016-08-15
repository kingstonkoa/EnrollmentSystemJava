/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.AddCourseView;
import enrollmentsystem.Course;
import enrollmentsystem.Section;
import enrollmentsystem.Student;
import static enrollmentsystem.WriteToFile.WriteCourseToFile;
import static enrollmentsystem.WriteToFile.WriteSectionToFile;
import static enrollmentsystem.WriteToFile.WriteStudentListToFile;
import static enrollmentsystem.WriteToFile.WriteStudentToFile;
import java.io.File;
import java.util.ArrayList;
import model.Model;
import view.AdminMenuView;
import view.EditStudentView;
import view.MainFrame;
import view.OpenSectionView;
import view.RegisterStudentView;

/**
 *
 * @author John
 */
public class AdminController 
{
    private MainFrame mf;
    private Model model;

    public AdminController(MainFrame mf, Model model)
    {
        this.mf = mf;
        this.model = model;
        model.readRegisteredStudents();
    }


    public void loadRegisterView()
    {
        mf.switchView(new RegisterStudentView(this));
    }
    
    public void loadEditStudentView()
    {
        mf.switchView(new EditStudentView(this));
    }

    public void loadAdminMenuView()
    {
        mf.switchView(new AdminMenuView(this));
    }

    public boolean IDNotExist(String idNumber)
    {
        ArrayList<Student> studentList = model.getRegisteredStudents();
        
        if(studentList == null)
            return true;
        
        ArrayList<String> idList = getIDNumbers(studentList);
        
        if(idList.contains(idNumber))
            return false;
        else
            return true;
    }

    public void registerStudent(Student student)
    {
        WriteStudentToFile("studentsDatabase.txt", student);
        model.readRegisteredStudents();
    }

    public ArrayList<String> getIDNumbers(ArrayList<Student> studentList)
    {
        ArrayList<String> idList = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i++)
        {
            idList.add(studentList.get(i).getIdNumber());
        }
        
        return idList;
    }

    public ArrayList<Student> getAllStudents()
    {
        return model.getRegisteredStudents();
    }

    public void reWriteStudentFile(ArrayList<Student> studentList)
    {
         File f = null;
         f = new File("studentsDatabase.txt");
         f.delete();
         
        WriteStudentListToFile("studentsDatabase.txt", studentList);
        model.readRegisteredStudents();


    }

    public void loadAddCourseView()
    {
        mf.switchView(new AddCourseView(this));
    }

   public boolean CourseCodeNotExist(String courseCode)
    {
        ArrayList<Course> courseList = model.getRegisteredCourses();
        
        if(courseList == null)
            return true;
        
        ArrayList<String> codeList = getCourseCodes(courseList);
        
        if(codeList.contains(courseCode))
            return false;
        else
            return true;
    }

    public void addCourse(Course course)
    {
        WriteCourseToFile("coursesDatabase.txt", course);
        model.readCourses();
    }

    public ArrayList<String> getCourseCodes(ArrayList<Course> courseList)
    {
         ArrayList<String> courseCodes = new ArrayList<>();
        for(int i = 0; i < courseList.size(); i++)
        {
            courseCodes.add(courseList.get(i).getCode());
        }
        
        return courseCodes;
    }

    public void loadOpenSectionView()
    {
        mf.switchView(new OpenSectionView(this));
    }

    public String[] getAddedCourses()
    {
        ArrayList<String> courseCodesList = new ArrayList<>();
        model.readCourses();
        ArrayList<Course> registeredCourses = model.getRegisteredCourses();
        for(int i = 0; i < registeredCourses.size(); i++)
        {
            courseCodesList.add(registeredCourses.get(i).getCode());
        }
        
        String[] courseCodeArray = new String[courseCodesList.size()];
        courseCodeArray = courseCodesList.toArray(courseCodeArray);

        return courseCodeArray;
    }

    public void openSection(Section section)
    {
        WriteSectionToFile("sectionsDatabase.txt", section);
        model.readSections();
    }

    public boolean SectionNotExist(String courseCode, String section)
    {
        ArrayList<Section> openedSectionList = model.getOpenedSections();
        
        if(openedSectionList == null)
            return true;
        
        ArrayList<String> sections = getSections(courseCode, openedSectionList);
        
        if(sections.contains(section))
            return false;
        else
            return true;
    }

    public ArrayList<String> getSections(String courseCode, ArrayList<Section> openedSectionList)
    {
        ArrayList<String> alreadySection = new ArrayList<>();
        for(int i = 0; i < openedSectionList.size(); i++)
        {
            if(openedSectionList.get(i).getCode().equals(courseCode))
            {
                alreadySection.add(openedSectionList.get(i).getSection());
            }
        
        }
       
        return alreadySection;
    }

    
}
