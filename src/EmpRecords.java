import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class EmpRecords extends JFrame{
	

	static JLabel lFirstName, lLastName, lAddress, lSocial, lPhone;//labels for the table
	
	static JTextField tfFirstName, tfLastName, tfAddress, tfSocial, tfPhone;//text fields to enter the info
	
	static Object[][] ResultInfo;
	
	static JButton addEmp;
	static JButton removeEmp;
	
	static Object[] columns = {"First Name", "Last Name", "Address", "Social", "Phone Number"};//layout of the columns
	
	static DefaultTableModel dTableModel = new DefaultTableModel(ResultInfo, columns){
        public Class getColumnClass(int column) {
            Class returnValue;
            
            // Verifying that the column exists (index > 0 && index < number of columns
            
            if ((column >= 0) && (column < getColumnCount())) {
              returnValue = getValueAt(0, column).getClass();
            } else {
            	
              // Returns the class for the item in the column	
            	
              returnValue = Object.class;
            }
            return returnValue;
          }
        };
        
        // Create a JTable using the custom DefaultTableModel
        
        static JTable table = new JTable(dTableModel);
        static JFrame frame = new JFrame();
	
	
	
	public static void main(String[] args){
		
		EmployeesInfo employee = new EmployeesInfo("Abe", "Atwi", "4708 Cobble Stone", "698254796", "8432223316");
		
		Object[] tempRow = employee.getInfo();
	    
	    dTableModel.addRow(tempRow);
	    
	    tableLayout();//gives the layout of the table 
	    
	    // Creates a button that when pressed executes the code
	    // in the method actionPerformed
	    
	    addRecord();//to add a row to table
	    
	    removeRecord();//to remove a row form table
	    
	    cellEdit();//when click on each cell and update in the table
	    
	    // Define values for my labels
	    frameLayout();
	    
	    
	}//End Of Main
	
	
	
	public static void tableLayout(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table.setFont(new Font("Serif", Font.PLAIN, 16));
		        
		 // Increase the size of the cells to allow for bigger fonts
		        
		 table.setRowHeight(table.getRowHeight()+8);
		        
		 // Allows the user to sort the data
			    
		 table.setAutoCreateRowSorter(true);
			    
		 // Adds the table to a scrollpane
			    
		 JScrollPane scrollPane = new JScrollPane(table);
			    
		 // Adds the scrollpane to the frame
		 frame.add(scrollPane, BorderLayout.CENTER);
	}//end of tableLayout method
	
	public static void frameLayout(){
		 lFirstName = new JLabel("First Name");
		    lLastName = new JLabel("Last Name");
		    lAddress = new JLabel("Address");
		    lSocial = new JLabel("Social");
		    lPhone = new JLabel("Phone");
		    
		    // Define the size of text fields
		    
		    tfFirstName = new JTextField(10);
		    tfLastName = new JTextField(10);
		    tfAddress = new JTextField(15);
		    tfSocial = new JTextField(10);
		    tfPhone = new JTextField(10);
		    
		    // Create a panel to hold editing buttons and fields
		    
		    JPanel inputPanel = new JPanel();
		    
		    // Put components in the panel
		    inputPanel.add(lFirstName);
		    inputPanel.add(tfFirstName);
		    inputPanel.add(lLastName);
		    inputPanel.add(tfLastName);
		    inputPanel.add(lAddress);
		    inputPanel.add(tfAddress);
		    inputPanel.add(lSocial);
		    inputPanel.add(tfSocial);
		    inputPanel.add(lPhone);
		    inputPanel.add(tfPhone);
		    inputPanel.add(addEmp);
		    inputPanel.add(removeEmp);
		    
		    // Add the component panel to the frame
		    
		    frame.add(inputPanel, BorderLayout.AFTER_LAST_LINE);
		    
		   
		    frame.setSize(1200, 500);
		    frame.setVisible(true);
		
	}//end of frameLayout method
	
	
	public static boolean regexChecker(String theRegex, String str2Check){
			
			
			Pattern checkRegex = Pattern.compile(theRegex);
			
			// Creates a Matcher object that searches the String for
			// anything that matches the REGEX
			
			Matcher regexMatcher = checkRegex.matcher( str2Check );
			
			
			// Cycle through the positive matches and print them to screen
			// Make sure string isn't empty and trim off any whitespace
			String temp = "";
			while ( regexMatcher.find() )
			{
				if (regexMatcher.group().length() != 0)
					temp = temp + regexMatcher.group().trim();
				
			}
			if(temp.length()!=0)	
				return true;
			else
				return false;
		}
	
	public static void cellEdit(){
		 //when click on a cell we can update the info in it 
	    table.addMouseListener(new MouseAdapter(){  
	    	public void mouseReleased(MouseEvent me){
	            String value = JOptionPane.showInputDialog(null,"Enter Cell Value:"); 
	            
	            // Makes sure a value is changed only if OK is clicked
	            
	            int caseCheck = table.getSelectedColumn();
	            
	            switch(caseCheck){
	            	case(0):
	            		if (value.equals(null) || regexChecker("[^A-Za-z]", value)){
	            			JOptionPane.showMessageDialog(null, "Invalid First Name Entry");
	            			value = "";
	            		}
	            		break;
	            	case(1):
	            		if (value.equals(null) || regexChecker("[^A-Za-z]", value)){
	            			JOptionPane.showMessageDialog(null, "Invalid Last Name Entry");
	            			value = "";
	            		}
	            		break;
	            	case(2):
	            		if (value.equals(null) || regexChecker("[^A-Za-z0-9]", value)){
	            			JOptionPane.showMessageDialog(null, "Invalid Address Entry");
	            			value = "";
	            		}
	            		break;
	            	case(3):
	            		if (value.equals(null) || regexChecker("[^0-9]", value) || value.length()!=9){
	            			JOptionPane.showMessageDialog(null, "Invalid Social Entry");
	            			value = "";
	            		}
	            		break;
	            	case(4):
	            		if (value.equals(null) || regexChecker("[^0-9]", value) || value.length()!=10){
	            			JOptionPane.showMessageDialog(null, "Invalid Phone Entry");
	            			value = "";
	            		}
	            		break;
	            	default:
	            		break;
	            }
	            table.setValueAt(value, table.getSelectedRow(), table.getSelectedColumn());
	            
	    	}
	    });
	}//end of method cellEdit
	
	public static void addRecord(){
		 addEmp = new JButton("Add Employee");
		    //addEmp.setEnabled(false);
		    
		    addEmp.addActionListener(new ActionListener(){
		    
		    	public void actionPerformed(ActionEvent e){
		    		
		    		String sFirstName = "", sLastName = "", sAddress = "", sSocial= "", sPhoneNum = "";
		    		
		    		// getText returns the value in the text field
		    		sFirstName = tfFirstName.getText().trim();	
		    		sLastName = tfLastName.getText().trim();
		    		sAddress = tfAddress.getText().trim();
		    		sSocial = tfSocial.getText().trim();
		    		sPhoneNum = tfPhone.getText().trim();
		    		
		    		
		    		
		    		if(sFirstName.length()==0 || sFirstName.length()>10 || regexChecker("[^A-Za-z]", sFirstName))
		    			JOptionPane.showMessageDialog(null, "Invalid Name Entry");
		    		else if(sLastName.length()==0 || sFirstName.length()>10 || regexChecker("[^A-Za-z]", sLastName))
		    			JOptionPane.showMessageDialog(null, "Invalid Last Name Entry");
		    		else if(sAddress.length()==0 || sAddress.length()>40 || regexChecker("[^A-Za-z0-9]", sAddress))
		    			JOptionPane.showMessageDialog(null, "Invalid Address Entry");
		    		else if(sSocial.length()!=9 || regexChecker("[^0-9]", sSocial))						
		    			JOptionPane.showMessageDialog(null, "Invalid Social Security Entry");
		    		else if(sPhoneNum.length()!=10 || regexChecker("[^0-9]", sPhoneNum))								
		    			JOptionPane.showMessageDialog(null, "Invalid Phone Number Entry");							
		    		else{									
		    				Object[] empInfo = {sFirstName, sLastName, sAddress, sSocial, sPhoneNum};									
		    				dTableModel.addRow(empInfo);
		    			}
		    			
		    		//to clear the text field after entering values
		    		tfFirstName.setText("");
		            tfLastName.setText("");
		            tfAddress.setText("");
		            tfSocial.setText("");
		            tfPhone.setText("");
		    	}
		    	
		    });
	}//end of addRecord method
	
	public static void removeRecord(){
				removeEmp = new JButton("Remove Employee");
					    
				removeEmp.addActionListener(new ActionListener(){
					    	
				public void actionPerformed(ActionEvent e){
					    		
				// Will remove which ever row that is selected
					    		
				dTableModel.removeRow(table.getSelectedRow());
					    		
			}
					    	
		});
	}//end of removeRecord method
	
}//End Of Class EmpRecords
