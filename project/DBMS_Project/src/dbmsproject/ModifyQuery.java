package dbmsproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ModifyQuery extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	JTable table;
	ResultSetTableModelFactory2 factory;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultSetTableModelFactory2 factory = new ResultSetTableModelFactory2();
					ModifyQuery frame = new ModifyQuery(factory);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifyQuery(ResultSetTableModelFactory2 f) {
		super("MODIFICATION QUERY");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  }
		    });
		
		this.factory = f;
		table = new JTable(); 
		///setTitle("MODIFICATION QUERY");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//String s = textField.getText();
				if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wrong Entry");
                }
				else
				{
					try {
						String s = textField.getText();
						int x = factory.getResultSetTableModel2(s);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Incorrect Query");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				String[] argss = {};
	            try {
					QueryFrame.main(argss);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	           // frame.dispose();
	           // contentPane.setVisible(false);
			}
		});
		
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		textField.setColumns(10);
		contentPane.add(textField);
		
		label = new JLabel("");
		contentPane.add(label);
		contentPane.add(btnNewButton);
	}
	
}
