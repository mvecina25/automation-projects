package overriding;

public class MyMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee employee = new Employee();		
		System.out.println(employee.salary());
		
		System.out.println(employee.task());
		
		
		
		Employee juniorQA = new JuniorQA();		
		System.out.println(juniorQA.salary());		
		System.out.println(juniorQA.task());
		
		Employee devManager = new DevManager();
		System.out.println(devManager.task());
	
	}

}
