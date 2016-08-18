/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enrollmentsystem.Course;
import enrollmentsystem.Section;
import enrollmentsystem.Student;
import static enrollmentsystem.WriteToFile.WriteStudentEnlistToFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Model;
import view.EnlistmentView;
import view.MainFrame;
import view.StudentMenuView;

/**
 *
 * @author John
 */
public class StudentController 
{
    private MainFrame mf;
    private Model model;
    private final Student loginedStudent;

    public StudentController(MainFrame mf, Model model, Student loginedStudent)
    {
        this.mf = mf;
        this.model = model;
        this.loginedStudent = loginedStudent;
        model.readRegisteredStudents();
    }

    public boolean isNotEnrolled()
    {
        //TODO
        return true;
    }

    public void loadEnlistmentView()
    {
        mf.switchView(new EnlistmentView(this));
    }

    public void loadStudentMenuView()
    {
        mf.switchView(new StudentMenuView(this));
    }

    public String[] getOpenedCourses()
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

    public String[] getOpenedSections(String courseCode)
    {
        ArrayList<String> sectionList = new ArrayList<>();
        model.readSections();
        ArrayList<Section> openedSections = model.getOpenedSections();
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode))
                sectionList.add(openedSections.get(i).getSection());
        }
        
        String[] sectionCodeArray = new String[sectionList.size()];
        sectionCodeArray = sectionList.toArray(sectionCodeArray);

        return sectionCodeArray;
    }

    public String getCapacity(String courseCode, String section)
    {
        model.readSections();
        ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return openedSections.get(i).getEnrolledCount() + "/" + openedSections.get(i).getCapacity();
        
        }
        return null;
        
    }

    public String getDay(String courseCode, String section)
    {
        ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return openedSections.get(i).getDay();
        
        }
        return null;
    }

    public String getStartH(String courseCode, String section)
    {
        ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return openedSections.get(i).getStartHour();
        
        }
        return null;
    }

    public String getStartM(String courseCode, String section)
    {
      ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return openedSections.get(i).getStartMinute();
        
        }
        return null;
    }

    public String getEndH(String courseCode, String section)
    {
        ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return openedSections.get(i).getEndHour();
        
        }
        return null;
    }

    public String getEndM(String courseCode, String section)
    {
       ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return openedSections.get(i).getEndMinute();
        
        }
        return null;
    }

    public Section getSection(String courseCode, String section)
    {
       ArrayList<Section> openedSections = model.getOpenedSections();
        
        for(int i = 0; i < openedSections.size(); i++)
        {
            if(openedSections.get(i).getCode().equals(courseCode) && openedSections.get(i).getSection().equals(section))
                return 
                        openedSections.get(i);
        
        }
        return null;
    }

    public void addEnlistment(Section section)
    {
        WriteStudentEnlistToFile(loginedStudent.getIdNumber()+"enlistment.txt", section);
        model.readEnlisted(loginedStudent.getIdNumber()+"enlistment.txt");
    }

    public boolean courseNotYetEnlisted(String courseCode)
    {
        boolean status = true;
        model.readEnlisted(loginedStudent.getIdNumber()+"enlistment.txt");
        ArrayList<Section> enlistedSections = model.getEnlistedSections();
        
        for(int i = 0; i < enlistedSections.size(); i++)
        {
            if(enlistedSections.get(i).getCode().equals(courseCode))
                status = false;
        }
        return status;
        
    }

    public boolean noTimeConflict(String day, String sH, String sM, String eH, String eM)
    {
        boolean status = true;
        model.readEnlisted(loginedStudent.getIdNumber()+"enlistment.txt");
        ArrayList<Section> enlistedSections = model.getEnlistedSections();
        
        for(int i = 0; i < enlistedSections.size(); i++)
        {
            if(enlistedSections.get(i).getDay().equals(day))
            {
                Date start1 = convertToDate(sH, sM);
                Date end1 = convertToDate(eH, eM);
                Date start2 = convertToDate(enlistedSections.get(i).getStartHour(), enlistedSections.get(i).getStartMinute());
                Date end2 = convertToDate(enlistedSections.get(i).getEndHour(), enlistedSections.get(i).getEndMinute());
                
                boolean overLaped = isOverLaped(start1, end1, start2, end2);
                if(overLaped == true)
                    status = false;
            }
        }
        return status;
    }

    private Date convertToDate(String H, String M)
    {
        SimpleDateFormat dateformat2 = new SimpleDateFormat("hh:mm:ss");
		String strdate2 = H+":"+M+":00";
		try {
			Date newdate = dateformat2.parse(strdate2);
			return newdate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public boolean isOverLaped(Date start1,Date end1,Date start2,Date end2) throws NullPointerException{
    if ((start1.before(start2) && end1.after(start2)) || 
        (start1.before(end2) && end1.after(end2)) || 
        (start1.before(start2) && end1.after(end2))) {
        return true;
    } else {
        return false;
    }
}
    
}
