/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author John
 */
import com.sun.xml.internal.ws.util.StringUtils;
import controller.AdminController;
import enrollmentsystem.Student;
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

public class RegisterStudentView extends JPanel implements EnrollmentSystemView
{
        private JLabel lblRegisterStudent;
        private JLabel lblIDNumber;
        private JLabel lblPassword;
        private JLabel lblLastName;
        private JLabel lblFirstName;
        private JLabel lblMinUnitis;
        private JLabel lblMaxUnits;
        private JTextField tfIDNumber;
        private JTextField tfPassword;
        private JTextField tfLastName;
        private JTextField tfFirstName;
        private JTextField tfMinUnits;
        private JTextField tfMaxUnits;
        private JButton btnBack;
        private JButton btnSave;
	private Font fntPlainText, fntHeaderText;
        private final AdminController controller;
        
        

	public RegisterStudentView(AdminController controller)
	{
                this.controller = controller;
		setBounds(0, 0, 1000, 620);
		setLayout(null);
		setBorder(new BevelBorder(BevelBorder.RAISED));

		fntPlainText = new Font("Arial", Font.PLAIN, 21);
		fntHeaderText = new Font("Arial", Font.BOLD, 40);

                //construct components
                lblRegisterStudent = new JLabel ("Register Student");
                lblRegisterStudent.setFont(fntHeaderText);
                lblIDNumber = new JLabel ("ID Number");
                lblIDNumber.setFont(fntPlainText);
                lblPassword = new JLabel ("Password");
                lblPassword.setFont(fntPlainText);
                lblLastName = new JLabel ("Last Name");
                lblLastName.setFont(fntPlainText);
                lblFirstName = new JLabel ("First Name");
                lblFirstName.setFont(fntPlainText);
                lblMinUnitis = new JLabel ("Minimum Units");
                lblMinUnitis.setFont(fntPlainText);
                lblMaxUnits = new JLabel ("Maximum Units");
                lblMaxUnits.setFont(fntPlainText);
                btnBack = new JButton ("Back");
                btnBack.setFont(fntPlainText);
                btnSave = new JButton ("Save");
                btnSave.setFont(fntPlainText);
                tfIDNumber = new JTextField (10);
                tfPassword = new JTextField (20);
                tfLastName = new JTextField (20);
                tfFirstName = new JTextField (20);
                tfMinUnits = new JTextField (3);
                tfMaxUnits = new JTextField (3);

                //adjust size and set layout
                setPreferredSize (new Dimension (861, 508));
                setLayout (null);

                //add components
                add (lblRegisterStudent);
                add (lblIDNumber);
                add (lblPassword);
                add (lblLastName);
                add (lblFirstName);
                add (lblMinUnitis);
                add (lblMaxUnits);
                add (tfIDNumber);
                add (tfPassword);
                add (tfLastName);
                add (tfFirstName);
                add (tfMinUnits);
                add (tfMaxUnits);
                add (btnBack);
                add (btnSave);

                //set component bounds (only needed by Absolute Positioning)
                lblRegisterStudent.setBounds (360, 40, 350, 50);
                lblIDNumber.setBounds (390, 125, 140, 25);
                lblPassword.setBounds (390, 170, 140, 25);
                lblLastName.setBounds (390, 215, 140, 25);
                lblFirstName.setBounds (390, 260, 140, 25);
                lblMinUnitis.setBounds (390, 305, 140, 25);
                lblMaxUnits.setBounds (390, 350, 140, 25);
                tfIDNumber.setBounds (540, 125, 140, 25);
                tfPassword.setBounds (540, 170, 140, 25);
                tfLastName.setBounds (540, 215, 140, 25);
                tfFirstName.setBounds (540, 260, 140, 25);
                tfMinUnits.setBounds (540, 305, 140, 25);
                tfMaxUnits.setBounds (540, 350, 140, 25);
                btnBack.setBounds (5, 5, 100, 25);
                btnSave.setBounds (580, 400, 100, 25);
                
                btnSave.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!tfIDNumber.getText().equals("") && !tfPassword.getText().equals("") && !tfLastName.getText().equals("") 
                        && !tfFirstName.getText().equals("") && !tfMinUnits.getText().equals("") && !tfMaxUnits.getText().equals(""))
                    {
                        if(controller.IDNotExist(tfIDNumber.getText()))
                        {
                            if(isInteger(tfMinUnits.getText()) && isInteger(tfMaxUnits.getText()))
                            {
                                if(Integer.parseInt(tfMinUnits.getText()) <=  Integer.parseInt(tfMaxUnits.getText()))
                                    controller.registerStudent(new Student(tfIDNumber.getText(), tfPassword.getText(), tfLastName.getText(), tfFirstName.getText(), Integer.parseInt(tfMinUnits.getText()), Integer.parseInt(tfMaxUnits.getText())));
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Mnimum Units cannot be greater than Maximum Units");
                                }
                            } else 
                            {
                                JOptionPane.showMessageDialog(null,"units should be a number");
                            }
                        } else
                            {
                                JOptionPane.showMessageDialog(null,"Student ID Number already exists");
                            }
                    } else
                            {
                                JOptionPane.showMessageDialog(null,"Please fill up all fields.");
                            }
                } 
              } );
                btnBack.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    controller.loadAdminMenuView();
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


        
}
