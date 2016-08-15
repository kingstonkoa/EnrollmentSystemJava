/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import controller.AdminController;
import enrollmentsystem.Student;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John
 */
public class EditStudentView extends JPanel implements EnrollmentSystemView
{
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private final AdminController controller;
    private ArrayList<Student> studentList;
    private JButton btnBack;
    private JButton btnSave;
    private Font fntPlainText, fntHeaderText;
    
	public EditStudentView(AdminController controller)
	{
            this.controller = controller;
            studentList = controller.getAllStudents();
            setLayout(null);
        // Create columns names
		String columnNames[] = { "ID Number", "Last Name", "First Name" };

                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0)
                {
                            boolean[] canEdit = new boolean[]{
                    false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
                };

		table = new JTable( tableModel );

                for(int i = 0; i < studentList.size(); i++)
                {
                    String id = studentList.get(i).getIdNumber();
                    String last = studentList.get(i).getLastName();
                    String first = studentList.get(i).getFirstName();
                    
                    Object[] data = {id, last, first};
                    
                    tableModel.addRow(data);
                }

		fntPlainText = new Font("Arial", Font.PLAIN, 21);
		fntHeaderText = new Font("Arial", Font.BOLD, 40);
                btnBack = new JButton ("Back");
                btnBack.setFont(fntPlainText);
                btnSave = new JButton ("Save");
                btnSave.setFont(fntPlainText);
		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		add(scrollPane, BorderLayout.CENTER );
                add (btnBack);
                add (btnSave);
                
                scrollPane.setBounds (80, 50, 800, 500);
                btnBack.setBounds (5, 5, 100, 25);
                btnSave.setBounds (850, 550, 100, 25);
                
                btnSave.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    table.getSelectionModel().clearSelection();
                    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
                    Object[][] tableData = new Object[nRow][nCol];
                    for (int i = 0 ; i < nRow ; i++)
                        for (int j = 0 ; j < nCol ; j++)
                            tableData[i][j] = dtm.getValueAt(i,j);
                    
                    for(int k = 0; k < studentList.size(); k++)
                    {
                        if(tableData[k][0].equals(studentList.get(k).getIdNumber()))
                        {
                            studentList.get(k).setLastName((String) tableData[k][1]);
                            studentList.get(k).setFirstName((String) tableData[k][2]);
                        }
                    }
                    
                    controller.reWriteStudentFile(studentList);

                } 
              } ); 
                
                btnBack.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) { 
                    controller.loadAdminMenuView();
                } 
              } ); 

        }
    
}
