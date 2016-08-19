/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentController;
import enrollmentsystem.Section;
import enrollmentsystem.Student;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John
 */
public class ViewEAFView extends JPanel implements EnrollmentSystemView
{
    private JLabel namelbl;
    private JLabel idNumberlbl;
    private JTextField nametf;
    private JTextField idNumbertf;
    private JLabel totalUnitslbl;
    private JTextField totalUnitstf;
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private final StudentController controller;
    private JButton btnBack;
    private Font fntPlainText, fntHeaderText;
    private ArrayList<Section> sectionList = new ArrayList<Section>();
    private Student loginedStudent;
    private int totalUnits;
    
	public ViewEAFView(StudentController controller)
	{
            this.controller = controller;
            sectionList = controller.getAllEnrolled();
            loginedStudent = controller.getLogInStudent();
            setLayout(null);
            totalUnits = 0;
        // Create columns names
		String columnNames[] = { "CODE", "COURSE NAME", "SECTION", "TEACHER", "SCHEDULE", "UNITS" };

                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0)
                {
                            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
                };

		table = new JTable( tableModel );

                for(int i = 0; i < sectionList.size(); i++)
                {
                    String code = sectionList.get(i).getCode();
                    String name = controller.getCourseName(code);
                    String section = sectionList.get(i).getSection();
                    String teacher = sectionList.get(i).getFaculty();
                    String schedule = controller.convertDayToShortcut(sectionList.get(i).getDay()) + " " + sectionList.get(i).getStartHour() + ":" +  sectionList.get(i).getStartMinute() + "-" + sectionList.get(i).getEndHour() + ":" +  sectionList.get(i).getEndMinute();
                    String units = controller.getUnits(code);                 
                    totalUnits += Integer.parseInt(units);
                    Object[] data = {code, name, section, teacher, schedule, units};
                    
                    tableModel.addRow(data);
                }

		fntPlainText = new Font("Arial", Font.PLAIN, 21);
		fntHeaderText = new Font("Arial", Font.BOLD, 40);
                btnBack = new JButton ("Back");
                btnBack.setFont(fntPlainText);
                namelbl = new JLabel ("Name");
                namelbl.setFont(fntPlainText);
                idNumberlbl = new JLabel ("ID Number");
                idNumberlbl.setFont(fntPlainText);
                nametf = new JTextField (50);
                nametf.setEditable(false);
                idNumbertf = new JTextField (15);
                idNumbertf.setEditable(false);
                totalUnitslbl = new JLabel ("Total Units");
                totalUnitslbl.setFont(fntPlainText);
                totalUnitstf = new JTextField (5);
                totalUnitstf.setEditable(false);
                
		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		add(scrollPane, BorderLayout.CENTER );
                add (btnBack);
                
                
//                //adjust size and set layout
//                setPreferredSize (new Dimension (944, 563));
//                setLayout (null);

                //add components
                add (namelbl);
                add (idNumberlbl);
                add (nametf);
                add (idNumbertf);
                add (totalUnitslbl);
                add (totalUnitstf);

                //set component bounds (only needed by Absolute Positioning)
                namelbl.setBounds (150, 5, 100, 25);
                idNumberlbl.setBounds (350, 5, 100, 25);
                nametf.setBounds (220, 5, 115, 25);
                idNumbertf.setBounds (460, 5, 115, 25);
                totalUnitslbl.setBounds (685, 555, 100, 25);
                totalUnitstf.setBounds (785, 555, 100, 25);

                scrollPane.setBounds (80, 50, 800, 500);
                btnBack.setBounds (5, 5, 100, 25);
                
                nametf.setText(loginedStudent.getLastName()+", "+ loginedStudent.getFirstName());
                idNumbertf.setText(loginedStudent.getIdNumber());
                totalUnitstf.setText(String.valueOf(totalUnits));
                

                
                btnBack.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    controller.loadStudentMenuView();
                } 
              } ); 

        }
    
}
