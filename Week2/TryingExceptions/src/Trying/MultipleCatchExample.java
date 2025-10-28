package Trying;

public class MultipleCatchExample {
	public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
            int result = 10 / 0;        // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is invalid!");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
