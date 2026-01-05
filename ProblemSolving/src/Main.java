import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // check if a string is palindrome or not
        System.out.print("Enter your string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(isPalindrome(input)) {
            System.out.println("/ " + input + " / is palindrome" );
        } else {
            System.out.println("/ " + input + " / is not palindrome");
        }

        // generate a fibonacci series
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.print("Fibonacci Series: ");
        for (int i=0; i<num; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        // remove all spaces and convert to lower case
        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();

        // setting pointers
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // this is a recursive function
    public static int fibonacci(int x) {
        if (x==0 || x==1) return x;     // base case
        return fibonacci(x-1) + fibonacci(x-2);     // function is calling itself
    }
}

// 0 1 1 2 3 5 8