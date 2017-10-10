package dbmsproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyDatabase extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String value, values;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyDatabase frame = new ModifyDatabase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModifyDatabase() {
		setTitle("MODIFY DATABASE");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 125, 5, 125));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"    ADD TO A TABLE","SURGEON", "CONSULTING DOCTOR", 
				"DEPARTMENT", "PATIENT", "TESTS", "OPERATION"}));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				value = comboBox_1.getSelectedItem().toString();
				if(value.equals("    ADD TO A TABLE"))
					JOptionPane.showMessageDialog(null, "Choose option properly");
				else
				{
					if (value.equals("TESTS")){
						JOptionPane.showMessageDialog(null,"The fields are:\n testID(int; primary)\n testName(varchar)\n "
								+ "category(varchar)\n cost(int)\n department(varchar)", "TESTS DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("CONSULTING DOCTOR")){
						JOptionPane.showMessageDialog(null, "The fields are:\n docID(int; primary)\n doc_firstname(varchar)\n "
								+ "doc_lastname(varchar)\n department(varchar)\n surgeon(varchar)\n no_patients_for_surgery(int)\n joining_date(int)\n "
								+ "joining_month(varchar)\n joining_year(int)","CONSULTING DOCTOR DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("DEPARTMENT")){
						JOptionPane.showMessageDialog(null, "The fields are:\n department(varchar; primary)\n hod(varchar)\n "
								+ "phone(int)\n location(varchar)\n success_rate(int)\n no_of_test(int)","DEPARTMENT DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("PATIENT")){
						JOptionPane.showMessageDialog(null, "The fields are:\n patID(int; primary)\n pat_name(varchar)\n "
								+ "address_street(int)\n address_city(varchar)\n address_zip(int)\n age(int)\n date_admitted(date)\n date_discharged(date)\n "
								+ "category(varchar)\n status(varchar)"
								+ "\n tests(int)\n surgID(int)\n opID(int)","PATIENT DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("SURGEON")){
						JOptionPane.showMessageDialog(null, "The fields are:\n surgID(int; primary)\n surg_name(varchar)\n "
								+ "age(int)\n no_of_surgeries(int)\n department(varchar)\n phone(int)\n joining_date(date)\n"
								+ " success_rate(int)\n "
								+ "opd_consultant(varchar)\n","SURGEON DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("OPERATION")){
						JOptionPane.showMessageDialog(null, "The fields are:\n opID(int; primary)\n opName(varchar)\n "
								+ "description(varchar)\n lead_surgeon(int)\n total_surgeons(int)\n duration(int)\n cost(int)\n"
								+ " no_of_test(int)\n " ,"OPERATION DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					
					String[] argss = {};
		            try {
						ModifyQuery.main(argss);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				comboBox_1.setSelectedIndex(0);
			}
		});
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"      UPDATE TABLE","SURGEON", "CONSULTING DOCTOR", 
				"DEPARTMENT", "PATIENT", "TESTS", "OPERATION"}));
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = comboBox_2.getSelectedItem().toString();
				if(value.equals("      UPDATE TABLE"))
					JOptionPane.showMessageDialog(null, "Choose option properly");
				else
				{
					if (value.equals("TESTS")){
						JOptionPane.showMessageDialog(null,"The fields are:\n testID(int; primary)\n testName(varchar)\n "
								+ "category(varchar)\n cost(int)\n department(varchar)", "TESTS DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("CONSULTING DOCTOR")){
						JOptionPane.showMessageDialog(null, "The fields are:\n docID(int; primary)\n doc_firstname(varchar)\n "
								+ "doc_lastname(varchar)\n department(varchar)\n surgeon(varchar)\n no_patients_for_surgery(int)\n joining_date(int)\n "
								+ "joining_month(varchar)\n joining_year(int)","CONSULTING DOCTOR DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("DEPARTMENT")){
						JOptionPane.showMessageDialog(null, "The fields are:\n department(varchar; primary)\n hod(varchar)\n "
								+ "phone(int)\n location(varchar)\n success_rate(int)\n no_of_test(int)","DEPARTMENT DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("PATIENT")){
						JOptionPane.showMessageDialog(null, "The fields are:\n patID(int; primary)\n pat_name(varchar)\n "
								+ "address_street(int)\n address_city(varchar)\n address_zip(int)\n age(int)\n date_admitted(date)\n date_discharged(date)\n "
								+ "category(varchar)\n status(varchar)"
								+ "\n tests(int)\n surgID(int)\n opID(int)","PATIENT DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("SURGEON")){
						JOptionPane.showMessageDialog(null, "The fields are:\n surgID(int; primary)\n surg_name(varchar)\n "
								+ "age(int)\n no_of_surgeries(int)\n department(varchar)\n phone(int)\n joining_date(date)\n"
								+ " success_rate(int)\n "
								+ "opd_consultant(varchar)\n","SURGEON DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("OPERATION")){
						JOptionPane.showMessageDialog(null, "The fields are:\n opID(int; primary)\n opName(varchar)\n "
								+ "description(varchar)\n lead_surgeon(int)\n total_surgeons(int)\n duration(int)\n cost(int)\n"
								+ " no_of_test(int)\n " ,"OPERATION DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					String[] argss = {};
		            try {
						ModifyQuery.main(argss);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				comboBox_2.setSelectedIndex(0);
			}
		});
		contentPane.add(comboBox_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" DELETE FROM A TABLE","SURGEON", "CONSULTING DOCTOR", 
				"DEPARTMENT", "PATIENT", "TESTS", "OPERATION"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = comboBox.getSelectedItem().toString();
				if(value.equals(" DELETE FROM A TABLE"))
					JOptionPane.showMessageDialog(null, "Choose option properly");
				else
				{
					if (value.equals("TESTS")){
						JOptionPane.showMessageDialog(null,"The fields are:\n testID(int; primary)\n testName(varchar)\n "
								+ "category(varchar)\n cost(int)\n department(varchar)", "TESTS DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("CONSULTING DOCTOR")){
						JOptionPane.showMessageDialog(null, "The fields are:\n docID(int; primary)\n doc_firstname(varchar)\n "
								+ "doc_lastname(varchar)\n department(varchar)\n surgeon(varchar)\n no_patients_for_surgery(int)\n joining_date(int)\n "
								+ "joining_month(varchar)\n joining_year(int)","CONSULTING DOCTOR DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("DEPARTMENT")){
						JOptionPane.showMessageDialog(null, "The fields are:\n department(varchar; primary)\n hod(varchar)\n "
								+ "phone(int)\n location(varchar)\n success_rate(int)\n no_of_test(int)","DEPARTMENT DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("PATIENT")){
						JOptionPane.showMessageDialog(null, "The fields are:\n patID(int; primary)\n pat_name(varchar)\n "
								+ "address_street(int)\n address_city(varchar)\n address_zip(int)\n age(int)\n date_admitted(date)\n date_discharged(date)\n "
								+ "category(varchar)\n status(varchar)"
								+ "\n tests(int)\n surgID(int)\n opID(int)","PATIENT DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("SURGEON")){
						JOptionPane.showMessageDialog(null, "The fields are:\n surgID(int; primary)\n surg_name(varchar)\n "
								+ "age(int)\n no_of_surgeries(int)\n department(varchar)\n phone(int)\n joining_date(date)\n"
								+ " success_rate(int)\n "
								+ "opd_consultant(varchar)\n","SURGEON DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					if (value.equals("OPERATION")){
						JOptionPane.showMessageDialog(null, "The fields are:\n opID(int; primary)\n opName(varchar)\n "
								+ "description(varchar)\n lead_surgeon(int)\n total_surgeons(int)\n duration(int)\n cost(int)\n"
								+ " no_of_test(int)\n " ,"OPERATION DATABASE", JOptionPane.INFORMATION_MESSAGE);
					}
					String[] argss = {};
		            try {
		            	ModifyQuery.main(argss);
					} catch (Exception e1) {						
						e1.printStackTrace();
					}
				}
				comboBox.setSelectedIndex(0);
			}
		});
		contentPane.add(comboBox);
	}

}
