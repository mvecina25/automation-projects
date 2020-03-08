package overloading;

public class Calculate {
	
	
	public int sum(int x , int y) {
		return (x + y);
		
		
	}
	
	public String sum(String x, String y) {
		return (x + y);
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	Calculate calculate = new Calculate();
	System.out.println(calculate.sum(1, 1));
	System.out.println(calculate.sum("string", "string"));
	System.out.println(calculate.sum("1", "1"));

	}

}
