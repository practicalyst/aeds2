import java.util.Scanner;

class FatorialRecursivo {

	public static int fatorial(int n){
		int fat;

		if(n <= 1)
			return 1;
		else
			fat = n * fatorial(n - 1);
		return fat;
		
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);				
		int num;

		System.out.print("Digite um número: ");
		num = sc.nextInt();

		System.out.println("O fatorial de " + num + " é : " + fatorial(num));		

		sc.close();		
	}

}
