package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class QueryFrame extends JFrame {
   
	private static final long serialVersionUID = 1L;
	ResultSetTableModelFactory factory;   
    JTextField query;                     
    JTable table;                         
    JLabel msgline;                      

    
    public QueryFrame(ResultSetTableModelFactory f) {
	super("QueryFrame");  

	
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {  }
	    });

	
	this.factory = f;

	
	query = new JTextField();     
	table = new JTable();         
	msgline = new JLabel();      

	
	Container contentPane = getContentPane();
	contentPane.add(query, BorderLayout.NORTH);
	contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
	contentPane.add(msgline, BorderLayout.SOUTH);

	query.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    displayQueryResults(query.getText());
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
			JOptionPane.showMessageDialog(null, "Incorrect Query");
		    }
		}
	    });
    }

  
    public static void main(String args[]) throws Exception {

	ResultSetTableModelFactory factory = 
	    new ResultSetTableModelFactory();

	QueryFrame qf = new QueryFrame(factory);

	qf.setSize(500, 600);
	qf.setVisible(true);
    }
}
