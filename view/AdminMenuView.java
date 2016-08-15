package view;

import controller.AdminController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class AdminMenuView extends JPanel implements EnrollmentSystemView
{
        private JButton btnRegister;
        private JButton btnEditAccount;
        private JButton btnAddCourse;
        private JButton btnOpenSection;
        private JLabel lblWelcome;
	private Font fntPlainText, fntHeaderText;
        private final AdminController controller;
        

	public AdminMenuView(AdminController controller)
	{
                this.controller = controller;
		setBounds(0, 0, 1000, 620);
		setLayout(null);
		setBorder(new BevelBorder(BevelBorder.RAISED));

		fntPlainText = new Font("Arial", Font.PLAIN, 21);
		fntHeaderText = new Font("Arial", Font.BOLD, 40);

		btnRegister = new JButton ("Register Account");
                btnRegister.setFont(fntPlainText);
                btnEditAccount = new JButton ("Edit Student Account");
                btnEditAccount.setFont(fntPlainText);
                btnAddCourse = new JButton ("Add Course");
                btnAddCourse.setFont(fntPlainText);
                btnOpenSection = new JButton ("Open Section");
                btnOpenSection.setFont(fntPlainText);
                lblWelcome = new JLabel ("Welcome Admin");
                lblWelcome.setFont(fntHeaderText);

                //adjust size and set layout
                setPreferredSize (new Dimension (908, 537));
                setLayout (null);

                //add components
                add (btnRegister);
                add (btnEditAccount);
                add (btnAddCourse);
                add (btnOpenSection);
                add (lblWelcome);

                //set component bounds (only needed by Absolute Positioning)
                btnRegister.setBounds (390, 110, 230, 55);
                btnEditAccount.setBounds (390, 190, 230, 55);
                btnAddCourse.setBounds (390, 280, 230, 55);
                btnOpenSection.setBounds (390, 365, 230, 55);
                lblWelcome.setBounds (350, 40, 350, 50);
                
                btnRegister.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    controller.loadRegisterView();
                } 
              } );
                btnEditAccount.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(controller.getAllStudents() != null)
                    controller.loadEditStudentView();
                    else
                        JOptionPane.showMessageDialog(null,"No Student Record exist");
                } 
              } );                
                btnAddCourse.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    controller.loadAddCourseView();
                } 
              } );
                btnOpenSection.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    controller.loadOpenSectionView();
                } 
              } );                
	}
        
}
