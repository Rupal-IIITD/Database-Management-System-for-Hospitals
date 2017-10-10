package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query2 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query2(ResultSetTableModelFactory f) {
	super("Query2");  

	
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
			JOptionPane.showMessageDialog(null, "Names of head of departments who are surgeons as well as consultant in OPD with duration \nin hospital of "
					+ "more than 10 years, having performed at least 60% successful \nsurgeries who have operated on patients "
					+ "over 30 years.", "Query 2 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT DISTINCT surgeon.surg_name FROM surgeon INNER JOIN department JOIN patient  as p ON p.surgID = surgeon.surgID and  "
		    		+ "surgeon.surg_name = department.HOD WHERE surgeon.OPD_consultant = 'yes' and surgeon.success_rate>=60 and "
		    		+ "datediff( Now(), surgeon.joining_date) >3650 and p.age>30;");
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
			JOptionPane.showMessageDialog(Query2.this,
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

	Query2 qf = new Query2(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
