/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Model;
import view.AdminMenuView;
import view.MainFrame;

/**
 *
 * @author John
 */
public class LoginController
{
    private MainFrame mf;
    private Model model;

    public LoginController(Model model)
    {
        this.model = model;
    }

    
    public void loadAdminAccount()
    {
        mf.switchView(new AdminMenuView(new AdminController(mf, model)));
    }

    public void loadStudentAccount(String studentUsername)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMainFrame(MainFrame mf)
    {
        this.mf = mf;
    }
    
}
