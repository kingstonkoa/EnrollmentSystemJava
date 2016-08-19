package view;

import controller.StudentController;
import enrollmentsystem.Section;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class EnrollStudentView extends JPanel implements EnrollmentSystemView
{
        private JButton btnEnroll;
        private JButton backBtn;
        private JList jlEnlisted;
	private Font fntPlainText, fntHeaderText;
        private final StudentController controller;
        private DefaultListModel listModel;
        

	public EnrollStudentView(StudentController controller)
	{
                this.controller = controller;
		setBounds(0, 0, 1000, 620);
		setLayout(null);
		setBorder(new BevelBorder(BevelBorder.RAISED));

		fntPlainText = new Font("Arial", Font.PLAIN, 21);
		fntHeaderText = new Font("Arial", Font.BOLD, 40);
                ArrayList<Section> enlistSections = controller.getEnlistSections();

		//construct preComponents
        String[] jlEnlistedItems = controller.populateEnlisted(enlistSections);
        listModel = new DefaultListModel();
        
        //convert array to JListModel
        for(int i = 0; i < jlEnlistedItems.length; i++)
        {
            listModel.addElement(jlEnlistedItems[i]);
        }

        //construct components
        btnEnroll = new JButton ("Enroll ");
        btnEnroll.setFont(fntPlainText);
        jlEnlisted = new JList (listModel);
        jlEnlisted.setEnabled(false);
        backBtn = new JButton ("Back");
        backBtn.setFont(fntPlainText);

        //adjust size and set layout
        setPreferredSize (new Dimension (684, 566));
        setLayout (null);

        //add components
        add (btnEnroll);
        add (jlEnlisted);
        add (backBtn);

        //set component bounds (only needed by Absolute Positioning)
        btnEnroll.setBounds (365, 490, 210, 30);
        jlEnlisted.setBounds (365, 20, 210, 435);
        backBtn.setBounds (5, 5, 100, 25);
        
        backBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            controller.loadStudentMenuView();
        } 
      } ); 
                
        btnEnroll.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(controller.isValidUnits())
            {
                controller.enrollStudent();
                controller.updateSectionEnrollCount();
            }
            else
                {
                    JOptionPane.showMessageDialog(null,
                    "Minimum or Maximum units is not valid");
                }
        } 
      } );

}
        
}
