public class EmployeesInfo {
	
	private String FirstName ="";//fields to hold the values entered
	private String LastName = "";
	private String address = "";
	private String social = "";
	private String phoneNum = "";
	
	//method to get access to the private fields
	protected final  String getFirstName(){
		
		return this.FirstName;
	}
	
	protected final String getLastName(){
			
			return this.LastName;
		}


	protected final String getaddress(){
			
			return this.address;
		}
	
	protected final String getSocial(){
			
			return this.social;
		}
	
	protected final String getPhoneNum(){
			
			return this.phoneNum;
		}
	
	protected final Object[] getInfo(){
		Object[] temp = new Object[]{this.FirstName, this.LastName, this.address, this.social, this.phoneNum};
		
		return temp;
	}
	
	protected final void changeInfo(String FirstName, String LastName, String Address, String Social, String Phone){
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.address = Address;
		this.social = Social;
		this.phoneNum = Phone;
		
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
