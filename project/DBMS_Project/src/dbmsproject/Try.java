package dbmsproject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;


public class Try {
   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Label msglabel;
   String value, values;

   public Try(){
      prepareGUI();
   }

   public static void main(String[] args){
      Try  awtLayoutDemo = new Try();  
      awtLayoutDemo.showBorderLayoutDemo();       
   }
      
   private void prepareGUI(){
      mainFrame = new Frame("XYZ HOSPITAL");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      msglabel = new Label();
      msglabel.setAlignment(Label.CENTER);
      //msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showBorderLayoutDemo(){
      headerLabel.setText("Welcome to XYZ HOSPITAL");      

      Panel panel = new Panel();
      panel.setBackground(Color.darkGray);
      panel.setSize(300,300);
      BorderLayout layout = new BorderLayout();
//      layout.setHgap(20);
//      layout.setVgap(20);
      panel.setLayout(layout);     
      
      JButton your_query_button = new JButton("Standard Queries");
		your_query_button.setBackground(Color.LIGHT_GRAY);
		your_query_button.setBounds(154, 50, 130, 34);
		panel.add(your_query_button,BorderLayout.NORTH);
		your_query_button.setFont(new Font("Arial", Font.BOLD, 15));
		your_query_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
              String[] argss = {};
              StandardQuery.main(argss);
          }
		});

		JButton standard_button = new JButton("Your Query");
		standard_button.setBounds(134, 110, 170, 34);
		standard_button.setBackground(Color.LIGHT_GRAY);
		panel.add(standard_button,BorderLayout.CENTER);
		standard_button.setFont(new Font("Arial", Font.BOLD, 15));
		standard_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
              String[] argss = {};
              try {
				QueryFrame.main(argss);
			} catch (Exception e) {
				e.printStackTrace();
			}
          }
		});
		
		JButton modification = new JButton("Modify the database");
		modification.setBackground(Color.LIGHT_GRAY);
		modification.setBounds(130, 170, 178, 34);
		panel.add(modification,BorderLayout.SOUTH);
		modification.setFont(new Font("Arial", Font.BOLD, 15));
		modification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
              String[] argss = {};
              ModifyQuery.main(argss);
          }
		});			
	  
//      panel.add(new Button("Center"),BorderLayout.CENTER);
//      panel.add(new Button("Line Start"),BorderLayout.LINE_START); 
//      panel.add(new Button("Line End"),BorderLayout.LINE_END);
//      panel.add(new Button("East"),BorderLayout.EAST);   
//      panel.add(new Button("West"),BorderLayout.WEST); 
//      panel.add(new Button("North"),BorderLayout.NORTH); 
//      panel.add(new Button("South"),BorderLayout.SOUTH); 
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
}