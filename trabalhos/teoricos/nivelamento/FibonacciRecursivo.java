class FibonacciRecursivo{
	
	public static int fibonacci(int n){
		int fib;
		
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		else
			fib = fibonacci(n - 1) + fibonacci(n - 2); 
		return fib;	
	}

	public static void main(String[] args){		
		for(int i = 0; i < 20; i++){
			System.out.println("Fib(" + i +"): " + fibonacci(i));
		}
	}


}
