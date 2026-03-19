import java.util.Scanner;

public class PrimeChecker {
    private static char[] charArray;
    private static long timeMillis;


    // Declare the native method
    public native boolean isPrime(int n);

    // Load the library (the compiled C code)
    static {
        System.loadLibrary("prime_native");
    }

    public static void main(String[] args) {
        PrimeChecker checker = new PrimeChecker();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println(" Enter a number ");
            String input = sc.nextLine();
            int number = Integer.parseInt(input);
            long timeMillis = System.nanoTime();

            System.out.println("C Is " + number + " prime? " + checker.isPrime(number)
                +" time : "+ (System.nanoTime() - timeMillis) + " nano seconds");
            System.out.println("Java Is " + number + " prime? " + checker(number)
                +" time : "+ (System.nanoTime() - timeMillis) + " nano seconds");
        }

    }


    public static boolean checker(int n){
            // Edge cases
        if (n <= 1) return false;                // 0 and 1 are not prime
        if (n <= 3) return true;                 // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // Eliminate even numbers and multiples of 3
    
        // Check divisors up to square root of n, skipping even numbers
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}