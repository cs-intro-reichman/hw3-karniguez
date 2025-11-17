// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0){
			while (0 > x2){
			x1--;
			x2++;

		}
	    } 
		else{
		while (0 < x2){
			x1++;
			x2--;
		}
	}
		return x1;
	
}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if (x2 < 0){
			while (0 > x2){
			x1++;
			x2++;
			}

		}
		else{
		    while (0 < x2){
			x1--;
			x2--;
		    }
	}
		return x1;
	}



	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int tim = 0;
		if (x2 < 0){
			while (0 > x2){
			tim = minus(tim, x1);
			x2++;
			}

		}
		else{
		while (0 < x2){
			tim = plus(tim, x1);
			x2--;
		}
	}

		return tim;
	}

	// Returns ›x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int po = 1;
		if (n==0) {
			return 1;
		}
		else if (0  > x) {
			while (0 < n){
			po = times(po, x);
            n--;
			}
		}
		else{
			while (0 < n){
			po = times(po, x);
            n--;
			}
		}
		
		return po;
	}
	

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		
		int co = 0;
		if (x2 < 0 && x1 < 0){
			while (x1 <= x2){
			x1 = minus(x1,x2);
			co++;
			}
		}
		else if (x2 > 0 && x1 < 0){
			while (x1 <= x2){
			x1 = plus(x1, x2);
			co--;
			}
			return co;
			
		}
		else{
		while (x1 >= x2){
			x1 = minus(x1,x2);
			co++;
		}
		
	}
	return co;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		while (x1 >= x2){
			x1 = minus(x1,x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int y = 1;
		while ( times (y,y) <= x){
			y++;
		}
		y--;
		return y;
	}	  	  
}
