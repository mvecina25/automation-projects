package fourpillarsofoop;

public class encapsulation {

	private String nameString = "EMS"; // Restricted
	
	//Method Getter
	public String getName() {
		return nameString;
	}
	
	//Method Setter
	public void setName(String newName) {
		this.nameString = newName;
		
	}
}
