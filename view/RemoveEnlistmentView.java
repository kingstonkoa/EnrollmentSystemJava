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
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class RemoveEnlistmentView extends JPanel implements EnrollmentSystemView
{
        private JButton btnRemove;
        private JButton backBtn;
        private JList jlEnlisted;
	private Font fntPlainText, fntHeaderText;
        private final StudentController controller;
        private DefaultListModel listModel;
        

	public RemoveEnlistmentView(StudentController controller)
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
        btnRemove = new JButton ("Remove ");
        btnRemove.setFont(fntPlainText);
        jlEnlisted = new JList (listModel);
        backBtn = new JButton ("Back");
        backBtn.setFont(fntPlainText);

        //adjust size and set layout
        setPreferredSize (new Dimension (684, 566));
        setLayout (null);

        //add components
        add (btnRemove);
        add (jlEnlisted);
        add (backBtn);

        //set component bounds (only needed by Absolute Positioning)
        btnRemove.setBounds (365, 490, 210, 30);
        jlEnlisted.setBounds (365, 20, 210, 435);
        backBtn.setBounds (5, 5, 100, 25);
        
        backBtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            controller.loadStudentMenuView();
        } 
      } ); 
                
        btnRemove.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            String sectionRemoved = jlEnlisted.getSelectedValue().toString();
            listModel.remove(jlEnlisted.getSelectedIndex());
            String[] splited = sectionRemoved.split("\\s+");
            controller.removeEnlisted(splited[0], splited[1]);
        } 
      } );

}
        
}
