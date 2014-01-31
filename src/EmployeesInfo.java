
public class EmployeesInfo {
	
	private String FirstName ="";//fields to hold the values entered
	private String LastName = "";
	private String address = "";
	private String social = "";
	private String phoneNum = "";
	
	//method to get access to the private fields
	public String getFirstName(){
		
		return this.FirstName;
	}
	
	public String getLastName(){
			
			return this.LastName;
		}


	public String getaddress(){
			
			return this.address;
		}
	
	public String getSocial(){
			
			return this.social;
		}
	
	public String getPhoneNum(){
			
			return this.phoneNum;
		}
	
	public Object[] getInfo(){
		Object[] temp = new Object[]{this.FirstName, this.LastName, this.address, this.social, this.phoneNum};
		
		return temp;
	}
	
	
	//base constructor
	public EmployeesInfo(){
		
	}
	
	//more complex constructor
	public EmployeesInfo(String FirstName, String LastName, String address, String social, String phoneNum) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.address = address;
		this.social = social;
		this.phoneNum = phoneNum;
		// TODO Auto-generated constructor stub
	}

}
