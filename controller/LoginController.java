/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enrollmentsystem.Student;
import java.util.ArrayList;
import model.Model;
import view.AdminMenuView;
import view.MainFrame;
import view.StudentMenuView;

/**
 *
 * @author John
 */
public class LoginController
{
    private MainFrame mf;
    private Model model;
    private Student currentStudent;

    public LoginController(Model model)
    {
        this.model = model;
    }

    
    public void loadAdminAccount()
    {
        mf.switchView(new AdminMenuView(new AdminController(mf, model)));
    }

    public void loadStudentAccount(Student loginedStudent)
    {
        mf.switchView(new StudentMenuView(new StudentController(mf, model, loginedStudent)));
    }

    public void setMainFrame(MainFrame mf)
    {
        this.mf = mf;
    }

    public boolean getCheckIfStudentAccountExist(String studentUsername, String studentPassword)
    {
        model.readRegisteredStudents();
        ArrayList<Student> registeredStudents = model.getRegisteredStudents();
        boolean status = false;
        for(int i = 0; i < registeredStudents.size(); i++ )
        {
            if(registeredStudents.get(i).getIdNumber().equals(studentUsername) && registeredStudents.get(i).getPassword().equals(studentPassword))
            {
                status = true;
                this.currentStudent = registeredStudents.get(i);
            }
        }
        return status;
    }
    
    public Student getCurrentStudent()
    {
        return this.currentStudent;
    }
    
}
