/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enrollmentsystem.Course;
import enrollmentsystem.Section;
import enrollmentsystem.Student;
import static enrollmentsystem.WriteToFile.WriteSectionListToFile;
import static enrollmentsystem.WriteToFile.WriteStudentEnlistListToFile;
import static enrollmentsystem.WriteToFile.WriteStudentEnlistToFile;
import static enrollmentsystem.WriteToFile.WriteStudentEnrollListToFile;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Model;
import view.EnlistmentView;
import view.EnrollStudentView;
import view.MainFrame;
import view.RemoveEnlistmentView;
import view.StudentMenuView;
import view.ViewEAFView;

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
        File f = new File(loginedStudent.getIdNumber()+"enrollment.txt");
        if(f.exists() && !f.isDirectory())
            return false;
        else 
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

    public void removeEnlistmentView()
    {
         mf.switchView(new RemoveEnlistmentView(this));
    }

    public ArrayList<Section> getEnlistSections()
    {
        model.readEnlisted(loginedStudent.getIdNumber()+"enlistment.txt");
        return model.getEnlistedSections();
    }

    public String[] populateEnlisted(ArrayList<Section> enlistSections)
    {
        ArrayList<String> enlistedToList = new ArrayList<String>();
        for(int i = 0; i < enlistSections.size(); i++)
        {
            String row = enlistSections.get(i).getCode() + " " + enlistSections.get(i).getSection();
            enlistedToList.add(row);
            
        }
        
        String[] enlistedArray = new String[enlistedToList.size()];
        enlistedArray = enlistedToList.toArray(enlistedArray);

        return enlistedArray;   
    }

    public void removeEnlisted(String courseCode, String section)
    {
        ArrayList<Section> currentEnlisted = new ArrayList<Section>();
        currentEnlisted = getEnlistSections();
        
        for(int i = 0; i < currentEnlisted.size(); i++)
        {
            if(currentEnlisted.get(i).getCode().equals(courseCode) && currentEnlisted.get(i).getSection().equals(section))
                currentEnlisted.remove(i);
        }
        reWriteEnlistFile(currentEnlisted);
    }
    
    public void reWriteEnlistFile(ArrayList<Section> updatedEnlistList)
    {
         File f = null;
         f = new File(loginedStudent.getIdNumber()+"enlistment.txt");
         f.delete();
         
        WriteStudentEnlistListToFile(loginedStudent.getIdNumber()+"enlistment.txt", updatedEnlistList);
        model.readEnlisted(loginedStudent.getIdNumber()+"enlistment.txt");


    }

    public void enrollView()
    {
        mf.switchView(new EnrollStudentView(this));
    }

    public void enrollStudent()
    {
        ArrayList<Section> currentEnlisted = new ArrayList<Section>();
        currentEnlisted = getEnlistSections();
        
        enrollToFile(currentEnlisted);
    }

    public void enrollToFile(ArrayList<Section> currentEnlisted)
    {
        File f = null;
        f = new File(loginedStudent.getIdNumber()+"enlistment.txt");
        f.delete();
        
        WriteStudentEnrollListToFile(loginedStudent.getIdNumber()+"enrollment.txt", currentEnlisted);
        model.readEnrolled(loginedStudent.getIdNumber()+"enrollment.txt");
        
    }

    public boolean isValidUnits()
    {
        int count = 0;
        int minUnits = loginedStudent.getMinUnits();
        int maxUnits = loginedStudent.getMaxUnits();
        ArrayList<Section> enlistSections = getEnlistSections();
        model.readCourses();
        ArrayList<Course> registeredCourses = model.getRegisteredCourses();
        
        for(int i = 0; i < enlistSections.size(); i++)
        {
            for(int j = 0; j < registeredCourses.size(); j++)
            {
                if(enlistSections.get(i).getCode().equals(registeredCourses.get(j).getCode()))
                    count += Integer.parseInt(registeredCourses.get(j).getUnits());
            }
        }
        if(count >= minUnits && count <= maxUnits)
            return true;
        else
            return false;
    }

    public void updateSectionEnrollCount()
    {
        int current;
        model.readSections();
        ArrayList<Section> openedSections = model.getOpenedSections();
        model.readEnrolled(loginedStudent.getIdNumber()+"enrollment.txt");
        ArrayList<Section> enrolledSections = model.getEnrolledSections();
        
        for(int i  = 0; i < enrolledSections.size(); i++)
        {
            for(int j = 0; j < openedSections.size(); j++)
            {
                if(enrolledSections.get(i).getCode().equals(openedSections.get(j).getCode()) && enrolledSections.get(i).getSection().equals(openedSections.get(j).getSection()))
                {
                    current = Integer.parseInt(openedSections.get(j).getEnrolledCount());
                    openedSections.get(j).setEnrolledCount(String.valueOf(current++));
                }
            }
        }
        
        reWriteSectionDatabase(openedSections);
    }

    public void reWriteSectionDatabase(ArrayList<Section> openedSections)
    {
        File f = null;
        f = new File("sectionsDatabase.txt");
        f.delete();
         
        WriteSectionListToFile("sectionsDatabase.txt", openedSections);
        model.readSections();
    }

    public ArrayList<Section> getAllEnrolled()
    {
       model.readEnrolled(loginedStudent.getIdNumber()+"enrollment.txt");
       ArrayList<Section> enrolledSections = model.getEnrolledSections();
       return  enrolledSections;
    }

    public String getCourseName(String code)
    {
        model.readCourses();
        ArrayList<Course> registeredCourses = model.getRegisteredCourses();
        
        for(int i = 0; i < registeredCourses.size(); i++)
        {
            if(registeredCourses.get(i).getCode().equals(code))
              return  registeredCourses.get(i).getName();
        }
        return null;
        
    }

    public String getUnits(String code)
    {
        model.readCourses();
        ArrayList<Course> registeredCourses = model.getRegisteredCourses();
        
        for(int i = 0; i < registeredCourses.size(); i++)
        {
            if(registeredCourses.get(i).getCode().equals(code))
              return  registeredCourses.get(i).getUnits();
        }
        return null;
    }

    public Student getLogInStudent()
    {
        return this.loginedStudent;
    }

    public void viewEafView()
    {
        mf.switchView(new ViewEAFView(this));
    }

    public String convertDayToShortcut(String day)
    {
        if(day.equals("Monday - Wednesday"))
            return "MW";
        else
            return "TH";
    }
    
}
