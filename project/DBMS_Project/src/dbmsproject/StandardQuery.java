package dbmsproject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StandardQuery extends JFrame {

	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StandardQuery frame = new StandardQuery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StandardQuery() {
		setTitle("STANDARD QUERIES");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JRadioButton rdbtnQuery = new JRadioButton("QUERY 1");
		rdbtnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	             try {
					Query1.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	             rdbtnQuery.setSelected(false);
			}
		} );
		
		rdbtnQuery.setBounds(44, 36, 141, 23);
		
		JRadioButton rdbtnQuery_1 = new JRadioButton("QUERY 2");
		rdbtnQuery_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query2.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_1.setSelected(false);
			}
		});
		rdbtnQuery_1.setBounds(44, 68, 141, 23);
		
		JRadioButton rdbtnQuery_2 = new JRadioButton("QUERY 3");
		rdbtnQuery_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query3.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_2.setSelected(false);
			}
		});
		rdbtnQuery_2.setBounds(44, 103, 141, 23);
		
		JRadioButton rdbtnQuery_3 = new JRadioButton("QUERY 4");
		rdbtnQuery_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query4.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_3.setSelected(false);
			}
		});
		rdbtnQuery_3.setBounds(44, 138, 141, 23);
		
		JRadioButton rdbtnQuery_4 = new JRadioButton("QUERY 5");
		rdbtnQuery_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query5.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_4.setSelected(false);
			}
		});
		rdbtnQuery_4.setBounds(44, 173, 141, 23);
		
		JRadioButton rdbtnQuery_6 = new JRadioButton("QUERY 7");
		rdbtnQuery_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query7.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_6.setSelected(false);
			}
		});
		rdbtnQuery_6.setBounds(223, 36, 141, 23);
		
		JRadioButton rdbtnQuery_7 = new JRadioButton("QUERY 8");
		rdbtnQuery_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query8.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_7.setSelected(false);
			}
		});
		rdbtnQuery_7.setBounds(223, 68, 141, 23);
		
		JRadioButton rdbtnQuery_8 = new JRadioButton("QUERY 9");
		rdbtnQuery_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query9.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_8.setSelected(false);
			}
		});
		rdbtnQuery_8.setBounds(223, 103, 141, 23);
		
		JRadioButton rdbtnQuery_9 = new JRadioButton("QUERY 10");
		rdbtnQuery_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query10.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_9.setSelected(false);
			}
		});
		rdbtnQuery_9.setBounds(223, 138, 141, 23);
		
		JRadioButton rdbtnQuery_10 = new JRadioButton("QUERY 11");
		rdbtnQuery_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query11.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_10.setSelected(false);
			}
		});
		rdbtnQuery_10.setBounds(223, 173, 141, 23);
		
		JRadioButton rdbtnQuery_5 = new JRadioButton("QUERY 6");
		rdbtnQuery_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query6.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_5.setSelected(false);
			}
		});
		rdbtnQuery_5.setBounds(44, 208, 141, 23);
		
		JRadioButton rdbtnQuery_11 = new JRadioButton("QUERY 12");
		rdbtnQuery_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argss = {};
	              try {
					Query12.main(argss);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	              rdbtnQuery_11.setSelected(false);
			}
		});
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		getContentPane().add(rdbtnQuery);
		getContentPane().add(rdbtnQuery_1);
		getContentPane().add(rdbtnQuery_2);
		getContentPane().add(rdbtnQuery_3);
		getContentPane().add(rdbtnQuery_4);
		getContentPane().add(rdbtnQuery_6);
		getContentPane().add(rdbtnQuery_7);
		getContentPane().add(rdbtnQuery_8);
		getContentPane().add(rdbtnQuery_9);
		getContentPane().add(rdbtnQuery_10);
		getContentPane().add(rdbtnQuery_5);
		getContentPane().add(rdbtnQuery_11);
	}
}
