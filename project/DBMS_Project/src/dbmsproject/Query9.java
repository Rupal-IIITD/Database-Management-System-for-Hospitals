package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Query9 extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JButton query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public Query9(ResultSetTableModelFactory f) {
	super("Query9");  

	
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
			JOptionPane.showMessageDialog(null, "Names of consulting doctors and id in ascending order(names) who are surgeons too, having "
					+ "performed at \nleast 30 surgeries since their date of joining with percentage of successful surgeries "
					+ "exceeding 70%.", "Query 9 Statement", JOptionPane.INFORMATION_MESSAGE);
		    displayQueryResults("SELECT surgID, surg_name, department FROM surgeon WHERE no_of_surgeries >=30 and OPD_consultant= 'Yes' "
		    		+ "and success_rate>70 ORDER BY surg_name asc;");
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
			JOptionPane.showMessageDialog(Query9.this,
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

	Query9 qf = new Query9(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
