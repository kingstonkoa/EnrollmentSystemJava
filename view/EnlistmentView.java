/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminController;
import controller.StudentController;
import enrollmentsystem.Course;
import enrollmentsystem.Section;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
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
public class EnlistmentView extends JPanel implements EnrollmentSystemView
{
    private final StudentController controller;
    private Font fntPlainText, fntHeaderText;
    private JLabel openCourselbl;
    private JLabel codeLbl;
    private JLabel sectionlbl;
    private JLabel capacitylbl;
    private JComboBox sectionCBox;
    private JTextField capacitytf;
    private JButton enlistBtn;
    private JButton backBtn;
    private JComboBox courseCBox;
    private JLabel daylbl;
    private JTextField daytf;
    private JLabel startlbl;
    private JTextField startMtf;
    private JLabel colonSlbl;
    private JTextField startHtf;
    private JLabel jcomp16;
    private JTextField endHtf;
    private JTextField endMtf;
    private JLabel colonElbl;
    private String[] sectionCBoxItems = {};
    public EnlistmentView(StudentController controller)
    {
        this.controller = controller;
        setBounds(0, 0, 1000, 620);
        setLayout(null);
        setBorder(new BevelBorder(BevelBorder.RAISED));

        fntPlainText = new Font("Arial", Font.PLAIN, 21);
        fntHeaderText = new Font("Arial", Font.BOLD, 40);
        
        //construct preComponents
        String[] courseCBoxItems = controller.getOpenedCourses();

        //construct components
        openCourselbl = new JLabel ("Enlist Course");
        openCourselbl.setFont(fntHeaderText);
        codeLbl = new JLabel ("Course Code");
        codeLbl.setFont(fntPlainText);
        sectionlbl = new JLabel ("Section");
        sectionlbl.setFont(fntPlainText);
        capacitylbl = new JLabel ("Capacity");
        capacitylbl.setFont(fntPlainText);
        
        sectionCBox = new JComboBox (sectionCBoxItems);
        sectionCBox.setSelectedIndex(-1);
        sectionCBox.addActionListener (new ActionListener () {
        public void actionPerformed(ActionEvent e) {
            if(sectionCBox.getSelectedIndex()!=-1)
            capdayTime(courseCBox.getSelectedItem().toString(), sectionCBox.getSelectedItem().toString());
        }

            private void capdayTime(String courseCode, String section)
            {
               capacitytf.setText(controller.getCapacity(courseCode, section));
               daytf.setText(controller.getDay(courseCode, section));
               startHtf.setText(controller.getStartH(courseCode, section));
               startMtf.setText(controller.getStartM(courseCode, section));
               endHtf.setText(controller.getEndH(courseCode, section));
               endMtf.setText(controller.getEndM(courseCode, section));
            }
    });
        capacitytf = new JTextField (5);
        capacitytf.setEditable(false);
        enlistBtn = new JButton ("Enlist");
        enlistBtn.setFont(fntPlainText);
        backBtn = new JButton ("Back");
        backBtn.setFont(fntPlainText);
        
        courseCBox = new JComboBox (courseCBoxItems);
        courseCBox.setSelectedIndex(-1);
        courseCBox.addActionListener (new ActionListener () {
        public void actionPerformed(ActionEvent e) {
            populateSection(courseCBox.getSelectedItem().toString());
        }

            private void populateSection(String courseCode)
            {
            sectionCBoxItems = controller.getOpenedSections(courseCode);
            sectionCBox.setModel(new DefaultComboBoxModel(sectionCBoxItems));
            sectionCBox.setSelectedIndex(-1);
            
            capacitytf.setText("");
            daytf.setText("");
            startHtf.setText("");
            startMtf.setText("");
            endHtf.setText("");
            endMtf.setText("");
          
            }
    });
        
        daylbl = new JLabel ("Day Schedule");
        daylbl.setFont(fntPlainText);
        daytf = new JTextField (20);
        daytf.setEditable(false);
        startlbl = new JLabel ("Start Time");
        startlbl.setFont(fntPlainText);
        startMtf = new JTextField (5);
        startMtf.setEditable(false);
        colonSlbl = new JLabel (":");
        startHtf = new JTextField (5);
        startHtf.setEditable(false);
        jcomp16 = new JLabel ("End Time");
        jcomp16.setFont(fntPlainText);
        endHtf = new JTextField (5);
        endHtf.setEditable(false);
        endMtf = new JTextField (5);
        endMtf.setEditable(false);
        colonElbl = new JLabel (":");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 563));
        setLayout (null);

        //add components
        add (openCourselbl);
        add (codeLbl);
        add (sectionlbl);
        add (capacitylbl);
        add (sectionCBox);
        add (capacitytf);
        add (enlistBtn);
        add (backBtn);
        add (courseCBox);
        add (daylbl);
        add (daytf);
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
        sectionCBox.setBounds (505, 170, 100, 25);
        capacitytf.setBounds (505, 215, 100, 25);
        enlistBtn.setBounds (435, 440, 100, 25);
        courseCBox.setBounds (505, 125, 100, 25);
        daylbl.setBounds (370, 260, 140, 25);
        daytf.setBounds (505, 260, 165, 30);
        startlbl.setBounds (370, 305, 140, 25);
        startMtf.setBounds (560, 305, 45, 30);
        colonSlbl.setBounds (552, 305, 15, 30);
        startHtf.setBounds (505, 305, 45, 30);
        jcomp16.setBounds (370, 350, 140, 25);
        endHtf.setBounds (505, 350, 45, 30);
        endMtf.setBounds (560, 350, 45, 30);
        colonElbl.setBounds (552, 350, 20, 25);
        backBtn.setBounds (5, 5, 100, 25);
        
        backBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            controller.loadStudentMenuView();
        } 
      } ); 
        enlistBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(courseCBox.getSelectedIndex() != -1 && sectionCBox.getSelectedIndex() != -1)
            {
                String[] parts = capacitytf.getText().split("/");
                String count = parts[0]; 
                String capacity = parts[1]; 
                if(Integer.parseInt(count) < Integer.parseInt(capacity))
                {
                    if(controller.courseNotYetEnlisted(courseCBox.getSelectedItem().toString()))
                    {
                        if(controller.noTimeConflict(daytf.getText(), startHtf.getText(), startMtf.getText(), endHtf.getText(), endMtf.getText()))
                        {
                        controller.addEnlistment(controller.getSection(courseCBox.getSelectedItem().toString(), sectionCBox.getSelectedItem().toString()));
                        } else
                            {
                              JOptionPane.showMessageDialog(null,
                        "There is conflict in class time");  
                            }
                    } else
                        {
                           JOptionPane.showMessageDialog(null,
                        "Course with the same name has already been enlisted"); 
                        }
                    
                } else
                    {
                        JOptionPane.showMessageDialog(null,
                        "Maximum capacity has been reached");
                    }
                
            } else
                {
                    JOptionPane.showMessageDialog(null,
                        "Please selection a section first");
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
