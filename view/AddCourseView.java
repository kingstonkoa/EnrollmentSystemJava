/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminController;
import enrollmentsystem.Course;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import view.EnrollmentSystemView;

/**
 *
 * @author Kingston
 */
public class AddCourseView extends JPanel implements EnrollmentSystemView
{
    private final AdminController controller;
    private Font fntPlainText, fntHeaderText;
    private JLabel addCourselbl;
    private JLabel codeLbl;
    private JLabel nameLbl;
    private JLabel unitsLbl;
    private JTextField codetf;
    private JTextField nametf;
    private JTextField unitstf;
    private JButton addBtn;
    private JButton backBtn;

    public AddCourseView(AdminController controller)
    {
        this.controller = controller;
        setBounds(0, 0, 1000, 620);
        setLayout(null);
        setBorder(new BevelBorder(BevelBorder.RAISED));

        fntPlainText = new Font("Arial", Font.PLAIN, 21);
        fntHeaderText = new Font("Arial", Font.BOLD, 40);
        
        addCourselbl = new JLabel ("Add Course");
        addCourselbl.setFont(fntHeaderText);
        codeLbl = new JLabel ("Course Code");
        codeLbl.setFont(fntPlainText);
        nameLbl = new JLabel ("Course Name");
        nameLbl.setFont(fntPlainText);
        unitsLbl = new JLabel ("Units");
        unitsLbl.setFont(fntPlainText);
        codetf = new JTextField (7);
        nametf = new JTextField (20);
        unitstf = new JTextField (5);
        addBtn = new JButton ("Add");
        backBtn = new JButton ("Back");
        
        //adjust size and set layout
        setPreferredSize (new Dimension (944, 563));
        setLayout (null);

        //add components
        add (addCourselbl);
        add (codeLbl);
        add (nameLbl);
        add (unitsLbl);
        add (codetf);
        add (nametf);
        add (unitstf);
        add (addBtn);
        add (backBtn);

        //set component bounds (only needed by Absolute Positioning)
        addCourselbl.setBounds (360, 40, 350, 50);
        codeLbl.setBounds (370, 125, 140, 25);
        nameLbl.setBounds (370, 170, 140, 25);
        unitsLbl.setBounds (370, 215, 140, 25);
        codetf.setBounds (500, 125, 140, 25);
        nametf.setBounds (500, 170, 140, 25);
        unitstf.setBounds (500, 215, 140, 25);
        addBtn.setBounds (500, 300, 100, 25);
        backBtn.setBounds (5, 5, 100, 25);
        
        backBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            controller.loadAdminMenuView();
        } 
      } ); 
        addBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!codetf.getText().equals("") && !nametf.getText().equals("") && !unitstf.getText().equals(""))
                {
                    if(codetf.getText().length() == 7)
                    {
                        if(isUpper(codetf.getText()))
                        {
                            if(isInteger(unitstf.getText()))
                            {
                                if(controller.CourseCodeNotExist(codetf.getText()))
                                {
                                    controller.addCourse(new Course(codetf.getText(), nametf.getText(), unitstf.getText()));
                                } else
                                    {
                                      JOptionPane.showMessageDialog(null,"Course Code already exist");
                                    }
                                
                            } else
                                {
                                  JOptionPane.showMessageDialog(null,"Units should be a number");  
                                }
                            
                        } else
                            {
                              JOptionPane.showMessageDialog(null,"Course Code should be all Uppercase");  
                            }
                    } else
                        {
                          JOptionPane.showMessageDialog(null,"Course Code should be 7 characters");  
                        }

                } else
                    {
                        JOptionPane.showMessageDialog(null,"Please fill up all fields.");
                    }
            
            
        } 
      } ); 
    }
    public boolean isInteger( String input )
    {
       try
       {
          Integer.parseInt( input );
          return true;
       }
         catch( Exception ex)
       {
          return false;
       }
    }
    public static boolean isUpper(String s)
    {
        for(char c : s.toCharArray())
        {
            if(Character.isLowerCase(c))
                return false;
        }

        return true;
    }
    
}
