package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query8 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query8(ResultSetTableModelFactory f) {
	super("Query8");  

	
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
			JOptionPane.showMessageDialog(null, "Names of all the patients and id with age more than 35 who haven’t been discharged yet, have been admitted in the hospital for \nmore than"
					+ "15 days till date and whose surgery has been performed by doctors \nwith at least 8 years of experience "
					+ "and age less than 55 and duration of operation more than 4h.", "Query 8 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT p.patID, p.pat_name FROM patient as p JOIN surgeon as s JOIN operation as o WHERE p.surgID = s.surgID and p.age>35 and p.status = 'alive' and "
		    		+ "datediff( Now(), p.date_admitted) >15 and s.age<55 and datediff( Now(), s.joining_date) >2920 and p.opID = o.opID and o.duration>4;");
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
			JOptionPane.showMessageDialog(Query8.this,
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

	Query8 qf = new Query8(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
