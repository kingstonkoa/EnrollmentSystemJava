package view;

import controller.AdminController;
import controller.StudentController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StudentMenuView extends JPanel implements EnrollmentSystemView
{
        private JButton btnEnlist;
        private JButton btnRemoveEnlist;
        private JButton btnEnroll;
        private JButton btnViewEAF;
        private JLabel lblWelcome;
	private Font fntPlainText, fntHeaderText;
        private final StudentController controller;
        

	public StudentMenuView(StudentController controller)
	{
                this.controller = controller;
		setBounds(0, 0, 1000, 620);
		setLayout(null);
		setBorder(new BevelBorder(BevelBorder.RAISED));

		fntPlainText = new Font("Arial", Font.PLAIN, 21);
		fntHeaderText = new Font("Arial", Font.BOLD, 40);

		btnEnlist = new JButton ("Enlist in Section");
                btnEnlist.setFont(fntPlainText);
                btnRemoveEnlist = new JButton ("Remove Enlistment");
                btnRemoveEnlist.setFont(fntPlainText);
                btnEnroll = new JButton ("Enroll");
                btnEnroll.setFont(fntPlainText);
                btnViewEAF = new JButton ("View EAF");
                btnViewEAF.setFont(fntPlainText);
                lblWelcome = new JLabel ("Welcome Student");
                lblWelcome.setFont(fntHeaderText);

                //adjust size and set layout
                setPreferredSize (new Dimension (908, 537));
                setLayout (null);

                //add components
                add (btnEnlist);
                add (btnRemoveEnlist);
                add (btnEnroll);
                add (btnViewEAF);
                add (lblWelcome);

                //set component bounds (only needed by Absolute Positioning)
                btnEnlist.setBounds (390, 110, 230, 55);
                btnRemoveEnlist.setBounds (390, 190, 230, 55);
                btnEnroll.setBounds (390, 280, 230, 55);
                btnViewEAF.setBounds (390, 365, 230, 55);
                lblWelcome.setBounds (350, 40, 350, 50);
                
                btnEnlist.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    if(controller.isNotEnrolled())
                    {
                        controller.loadEnlistmentView();
                    
                    }
                } 
              } );
                btnRemoveEnlist.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                      controller.removeEnlistmentView(); 
                } 
              } );                
                btnEnroll.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    
                } 
              } );
                btnViewEAF.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    
                } 
              } );                
	}
        
}
