import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.print("Fibonacci Series: ");
        for (int i=0; i<num; i++) {
            System.out.print(fibonacci(i) + " ");
        }

//         System.out.println("Bye Bye, " +args[0]);
    }

    public static int fibonacci(int x) {
        if (x==0 || x==1) return x;
        return fibonacci(x-1) + fibonacci(x-2);
    }

}
