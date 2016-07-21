/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enrollmentsystem.Student;
import static enrollmentsystem.WriteStudentToFile.WriteStudentToFile;
import view.AdminMenuView;
import view.MainFrame;
import view.RegisterStudentView;

/**
 *
 * @author John
 */
public class AdminController 
{
    private MainFrame mf;

    public AdminController(MainFrame mf)
    {
        this.mf = mf;
    }


    public void loadRegisterView()
    {
        mf.switchView(new RegisterStudentView(this));
    }

    public void loadAdminMenuView()
    {
        mf.switchView(new AdminMenuView(this));
    }

    public boolean IDNotExist(String idNumber)
    {
        //TODO
        //check if ID is existing
        return true;
    }

    public void registerStudent(Student student)
    {
        WriteStudentToFile("studentsDatabase.txt", student);
    }
    
}
