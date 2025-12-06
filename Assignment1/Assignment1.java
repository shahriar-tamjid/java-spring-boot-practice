
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Assignment1 {
    public static void main(String[] args) {
        System.out.println("Sharif MD Shahriar Tamjid");
        System.out.println("Spring Boot Developement");
        System.out.println("My goal is to become a Spring Boot Developer");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        String formattedDate = today.format(formatter);
        System.out.println("The current date today: " + formattedDate);

        System.out.println("Hello, fellow developers!");

    }
}
