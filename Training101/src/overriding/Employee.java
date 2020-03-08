package overriding;

public class Employee {
	
	public static int basePay = 50000;
	public static String responsibilities = "Watch Porn";
	
	int salary() {
		return basePay;
	}
	
	String task() {
		return responsibilities;
	}
}
