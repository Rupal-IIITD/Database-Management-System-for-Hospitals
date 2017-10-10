package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query5 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query5(ResultSetTableModelFactory f) {
	super("Query5");  

	
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
			JOptionPane.showMessageDialog(null, "Patient id and name of all patients who were bought for surgery, with the \nsurgery "
					+ "lasting for more than 6h, age of patients more 60 than who \ncouldn’t"
					+ " survive the surgery with surgery performed by a surgeon who is also an opd consultant.", "Query 5 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT p.patID, p.pat_name  FROM patient as p JOIN operation as o JOIN surgeon as s WHERE p.opID = o.opID and p.category='surgery' and "
		    		+ "p.age>60 and p.status='deceased' and o.duration>6 and p.surgID = s.surgID and s.opd_consultant = 'Yes';");
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
			JOptionPane.showMessageDialog(Query5.this,
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

	Query5 qf = new Query5(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
