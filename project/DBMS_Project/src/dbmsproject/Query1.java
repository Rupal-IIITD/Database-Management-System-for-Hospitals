package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query1 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query1(ResultSetTableModelFactory f) {
	super("Query1");  

	
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
			JOptionPane.showMessageDialog(null, "Name and age of all the patients who came for a minor ailment but were later \ntaken into "
					+ "surgery performed by multiple surgeons who have performed more than 50 operations \nand age less than 55, with more "
					+ "than 2 tests performed and were admitted \nfor more than 20 days post-surgery and cost of operation greater than 1,00,000.", "Query 1 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("Select p.age, p.pat_name from patient as p JOIN operation as o JOIN surgeon as s WHERE p.surgID = s.surgID "
		    		+ "and p.opID =  o.opID and tests>2 and datediff(p.date_discharged, p.date_admitted)>20 and p.category =  'surgery' "
		    		+ "and s.age<55 and s.no_of_surgeries > 50 and o.cost > 100000;");
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
			JOptionPane.showMessageDialog(Query1.this,
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

	Query1 qf = new Query1(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
