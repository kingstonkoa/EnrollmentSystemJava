/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminController;
import enrollmentsystem.Course;
import enrollmentsystem.Section;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import static view.AddCourseView.isUpper;
import view.EnrollmentSystemView;

/**
 *
 * @author Kingston
 */
public class OpenSectionView extends JPanel implements EnrollmentSystemView
{
    private final AdminController controller;
    private Font fntPlainText, fntHeaderText;
    private JLabel openCourselbl;
    private JLabel codeLbl;
    private JLabel sectionlbl;
    private JLabel capacitylbl;
    private JLabel facultylbl;
    private JTextField sectiontf;
    private JTextField capacitytf;
    private JTextField facultytf;
    private JButton openBtn;
    private JButton backBtn;
    private JComboBox courseCBox;
    private JLabel daylbl;
    private JComboBox dayCBox;
    private JLabel startlbl;
    private JTextField startMtf;
    private JLabel colonSlbl;
    private JTextField startHtf;
    private JLabel jcomp16;
    private JTextField endHtf;
    private JTextField endMtf;
    private JLabel colonElbl;
    public OpenSectionView(AdminController controller)
    {
        this.controller = controller;
        setBounds(0, 0, 1000, 620);
        setLayout(null);
        setBorder(new BevelBorder(BevelBorder.RAISED));

        fntPlainText = new Font("Arial", Font.PLAIN, 21);
        fntHeaderText = new Font("Arial", Font.BOLD, 40);
        
        //construct preComponents
        String[] courseCBoxItems = controller.getAddedCourses();
        String[] dayCBoxItems = {"Monday - Wednesday", "Tuesday - Thursday"};

        //construct components
        openCourselbl = new JLabel ("Open Course");
        openCourselbl.setFont(fntHeaderText);
        codeLbl = new JLabel ("Course Code");
        codeLbl.setFont(fntPlainText);
        sectionlbl = new JLabel ("Section");
        sectionlbl.setFont(fntPlainText);
        capacitylbl = new JLabel ("Capacity");
        capacitylbl.setFont(fntPlainText);
        facultylbl = new JLabel("Faculty");
        facultylbl.setFont(fntPlainText);
        sectiontf = new JTextField (3);
        capacitytf = new JTextField (5);
        openBtn = new JButton ("Open");
        openBtn.setFont(fntPlainText);
        backBtn = new JButton ("Back");
        backBtn.setFont(fntPlainText);
        courseCBox = new JComboBox (courseCBoxItems);
        daylbl = new JLabel ("Day Schedule");
        daylbl.setFont(fntPlainText);
        dayCBox = new JComboBox (dayCBoxItems);
        startlbl = new JLabel ("Start Time");
        startlbl.setFont(fntPlainText);
        facultytf = new JTextField (50);
        startMtf = new JTextField (5);
        colonSlbl = new JLabel (":");
        startHtf = new JTextField (5);
        jcomp16 = new JLabel ("End Time");
        jcomp16.setFont(fntPlainText);
        endHtf = new JTextField (5);
        endMtf = new JTextField (5);
        colonElbl = new JLabel (":");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 563));
        setLayout (null);

        //add components
        add (openCourselbl);
        add (codeLbl);
        add (sectionlbl);
        add (facultylbl);
        add (capacitylbl);
        add (sectiontf);
        add (capacitytf);
        add (facultytf);
        add (openBtn);
        add (backBtn);
        add (courseCBox);
        add (daylbl);
        add (dayCBox);
        add (startlbl);
        add (startMtf);
        add (colonSlbl);
        add (startHtf);
        add (jcomp16);
        add (endHtf);
        add (endMtf);
        add (colonElbl);

        //set component bounds (only needed by Absolute Positioning)
        openCourselbl.setBounds (360, 40, 350, 50);
        codeLbl.setBounds (370, 125, 140, 25);
        sectionlbl.setBounds (370, 170, 140, 25);
        capacitylbl.setBounds (370, 215, 140, 25);
        facultylbl.setBounds (370, 260, 140, 25);
        sectiontf.setBounds (505, 170, 100, 25);
        facultytf.setBounds (505, 260, 100, 25);
        capacitytf.setBounds (505, 215, 100, 25);
        openBtn.setBounds (435, 440, 100, 25);
        courseCBox.setBounds (505, 125, 100, 25);
        daylbl.setBounds (370, 305, 140, 25);
        dayCBox.setBounds (505, 305, 165, 30);
        startlbl.setBounds (370, 350, 140, 25);
        startMtf.setBounds (560, 350, 45, 30);
        colonSlbl.setBounds (552, 350, 15, 30);
        startHtf.setBounds (505, 350, 45, 30);
        jcomp16.setBounds (370, 395, 140, 25);
        endHtf.setBounds (505, 395, 45, 30);
        endMtf.setBounds (560, 395, 45, 30);
        colonElbl.setBounds (552, 395, 20, 25);
        backBtn.setBounds (5, 5, 100, 25);
        
        backBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            controller.loadAdminMenuView();
        } 
      } ); 
        openBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!courseCBox.getSelectedItem().toString().equals("") && !sectiontf.getText().equals("") && !capacitytf.getText().equals("") && !startHtf.getText().equals("")
                    && !startMtf.getText().equals("") && !endHtf.getText().equals("") && !endMtf.getText().equals("") && !facultytf.getText().equals(""))
            {
                if(sectiontf.getText().length() == 3)
                {
                    if(isUpper(sectiontf.getText()))
                    {
                    if(isInteger(capacitytf.getText()))
                    {
                        if(isInteger(startHtf.getText()) && isInteger(startMtf.getText()) && isInteger(endHtf.getText()) && isInteger(endMtf.getText()))
                        {
                            if(Integer.parseInt(startHtf.getText()) <= 24 && Integer.parseInt(endHtf.getText()) <= 24 && Integer.parseInt(startHtf.getText()) >= 0 && Integer.parseInt(endHtf.getText()) >= 0
                                    && Integer.parseInt(startMtf.getText()) <= 59 && Integer.parseInt(endMtf.getText()) <= 59 && Integer.parseInt(startMtf.getText()) >= 0 && Integer.parseInt(endMtf.getText()) >=0)
                            {
                                if(controller.SectionNotExist(courseCBox.getSelectedItem().toString(),sectiontf.getText()))
                                {
                                    controller.openSection(new Section(courseCBox.getSelectedItem().toString(), sectiontf.getText(), capacitytf.getText(), dayCBox.getSelectedItem().toString(), startHtf.getText(), startMtf.getText(), endHtf.getText(), endMtf.getText(), "0", facultytf.getText()));
                                } else
                                    {
                                      JOptionPane.showMessageDialog(null,"Section already exist for this course");  
                                    }
                            } else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid time");
                                }
                        } else
                            {
                                JOptionPane.showMessageDialog(null,"Time should be a number");
                        
                            }
                    
                    } else
                        {
                            JOptionPane.showMessageDialog(null,"Capacity should be a number");
                        }
                    } else
                    {
                      JOptionPane.showMessageDialog(null,"Characters should be uppercase");  
                    }
                
                } else
                    {
                      JOptionPane.showMessageDialog(null,"Section should be 3 characters");  
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
