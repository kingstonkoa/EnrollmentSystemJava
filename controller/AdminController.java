/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enrollmentsystem.Course;
import enrollmentsystem.Student;
import static enrollmentsystem.WriteToFile.WriteCourseToFile;
import static enrollmentsystem.WriteToFile.WriteStudentListToFile;
import static enrollmentsystem.WriteToFile.WriteStudentToFile;
import java.io.File;
import java.util.ArrayList;
import model.Model;
import view.AdminMenuView;
import view.EditStudentView;
import view.MainFrame;
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

    
}
