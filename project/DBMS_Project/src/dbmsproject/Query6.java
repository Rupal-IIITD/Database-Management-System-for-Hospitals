package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query6 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query6(ResultSetTableModelFactory f) {
	super("Query6");  

	
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
			JOptionPane.showMessageDialog(null, "Names and average cost of all the tests of the cardiology department \nwhich are needed before a surgery "
					+ "costing more than 3000 rupees.", "Query 6 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT testName FROM tests WHERE department = 'heart' and cost > 3000 UNION SELECT avg(cost) AS average_cost FROM tests"
		    		+ " WHERE department = 'heart' and cost > 3000;");
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
			JOptionPane.showMessageDialog(Query6.this,
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

	Query6 qf = new Query6(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
