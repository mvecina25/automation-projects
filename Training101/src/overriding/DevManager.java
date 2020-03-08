package overriding;

public class DevManager extends Employee{
	
	int salary() {
		return basePay + 100000;
	}
	
	String task() {
		return responsibilities = "Dev Manager Ako";
	}
}
