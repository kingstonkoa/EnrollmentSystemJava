/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import controller.LoginController;
import model.Model;
import view.MainFrame;

/**
 *
 * @author John
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Model model = new Model();
        LoginController lc = new LoginController(model);
         MainFrame mf = new MainFrame();
         mf.setLoginController(lc);
         mf.renderMainView();
         lc.setMainFrame(mf);
         
         
         
    }
    
}
