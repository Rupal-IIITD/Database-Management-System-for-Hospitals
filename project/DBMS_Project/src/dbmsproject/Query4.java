package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query4 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query4(ResultSetTableModelFactory f) {
	super("Query4");  

	
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {  }
	    });

	
	this.factory = f;

	
	query = new JButton("Display Query Result and Statement");     
	table = new JTable();         
	msgline = new JLabel();      

	
	Container contentPane = getContentPane();
	contentPane.add(query, BorderLayout.NORTH);
	contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
	contentPane.add(msgline, BorderLayout.SOUTH);

	query.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Age of surgeons who are head of departments, have performed more than 100 surgeries \nand are "
					+ "in the hospital for more than 5 years till date and the patient is still alive.", "Query 4 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT surgeon.surg_name, surgeon.age FROM surgeon INNER JOIN department JOIN patient as p ON surgeon.surg_name = department.HOD WHERE surgeon.no_of_surgeries>100 and"
		    		+ " datediff( Now(), surgeon.joining_date) > 1825 and p.surgID = surgeon.surgID and p.status = 'alive';");
		}
	    });
    }

    
    public void displayQueryResults(final String q) {
	
	msgline.setText("Contacting database...");
	
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
		    try {
			
			table.setModel(factory.getResultSetTableModel(q));
			msgline.setText(" ");  
		    }
		    catch (SQLException ex) {
			msgline.setText(" ");
			JOptionPane.showMessageDialog(Query4.this,
			          new String[] {  
				      ex.getClass().getName() + ": ",
				      ex.getMessage()
				  });
		    }
		}
	    });
    }

  
    public static void main(String args[]) throws Exception {

	ResultSetTableModelFactory factory = 
	    new ResultSetTableModelFactory();

	Query4 qf = new Query4(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
