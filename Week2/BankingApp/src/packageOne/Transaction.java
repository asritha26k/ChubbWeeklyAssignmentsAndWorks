package packageOne;

public class Transaction {

	public static void TransactionMethod() {
		// TODO Auto-generated method stub
		
		//factorial code
		int n=5;
		int a=0;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		
		while(n-2>0) {			
			int c=a+b;
			System.out.println(c);
			a=b;
			b=c;
			n--;
		}
		
		//prime number yes or no
		int x=20;
		for(int i=0;i<x;i++) {
			if(checkPrime(i)) {
				System.out.println(i+" prime");
			}else {
				System.out.println(i+"not prime");
			}
		}
		
		

	}
	public static boolean checkPrime(int n) {
		boolean check=true;
		if(n==0 || n==1) return false;
		for(int i=2;i*i<n;i++) {
			if(n%i==0) {
				check=false;
				break;
			}
		}
		return check;
		
	}

}
