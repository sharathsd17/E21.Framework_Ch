package practice;

public class GenericMethodsPractice {

	public static void main(String[] args) { //Caller Function 
		
		//Addition
//		int a = 10;
//		int b = 20;
//		int c = a+b;
//		System.out.println(c);
		
		int sum = add(10,30);
		System.out.println(sum);
		System.out.println(add(30,sum));;
		System.out.println(add(100,400));;
		System.out.println(add(sum,60));;
		System.out.println(add(50,80));;
		System.out.println(add(40,sum));;
		
		int sum2 = add(sum,70);
		System.out.println(sum2);
		
		
	}
	
	//logic - controlled execution
	public static int add(int a, int b) //Called Function - generic
	{
		int c = a+b;
		return c;
	}
	
	//subtraction, product, divide
	
}
