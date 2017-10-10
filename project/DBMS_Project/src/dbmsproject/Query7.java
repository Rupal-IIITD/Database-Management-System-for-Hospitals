package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query7 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query7(ResultSetTableModelFactory f) {
	super("Query7");  

	
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
			JOptionPane.showMessageDialog(null, "Names of all the departments which have more than 2 surgeons, head \nof department "
					+ "with more than 4 years of tenure till date, having \nat least 2 tests and percentage of successful surgeries "
					+ "exceeding 60%.", "Query 7 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT d.department, d.hod FROM department as d JOIN surgeon as s WHERE  d.department = s.department and "
		    		+ "datediff( Now(), s.joining_date) >1460 and d.no_of_test>=2 and d.success_rate>60 GROUP BY d.department HAVING count(*)>2;");
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
			JOptionPane.showMessageDialog(Query7.this,
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

	Query7 qf = new Query7(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
