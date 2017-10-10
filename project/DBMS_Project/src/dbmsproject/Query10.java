package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query10 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query10(ResultSetTableModelFactory f) {
	super("Query10");  

	
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
			JOptionPane.showMessageDialog(null, "Count of all the operations with cost exceeding 1,00,000 performed by \nmore than 2 surgeons, time "
					+ "duration greater than 7h, performed on patients \nwith age more than 30 years, with success rate of more than"
					+ "50%.", "Query 10 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT count(*) FROM operation as o JOIN patient as p JOIN surgeon as s WHERE o.opID = p.opID and "
		    		+ "s.surgID = p.surgID and o.cost>100000 and o.total_surgeons>2 and o.duration>7 and p.age>30 and s.success_rate>50;");
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
			JOptionPane.showMessageDialog(Query10.this,
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

	Query10 qf = new Query10(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
