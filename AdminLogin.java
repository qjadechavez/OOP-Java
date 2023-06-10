import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

// Comment

public class AdminLogin {
    public static void main(String[] args) {
        final String ADMIN_USERNAME = "admin";
        final String ADMIN_PASSWORD = "password";
        int attempts = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (attempts < 3) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    System.out.println("Login successful!");

                    // Generate session ID
                    String sessionID = UUID.randomUUID().toString();
                    System.out.println("Session ID: " + sessionID);

                    // Get current date and time
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = now.format(formatter);
                    System.out.println("Login date and time: " + formattedDateTime);

                    break;
                } else {
                    attempts++;
                    System.out.println("Invalid username or password. Attempts remaining: " + (3 - attempts));
                }
            }
        }

        if (attempts == 3) {
            System.out.println("Maximum login attempts reached. Program will exit.");
            System.exit(0);
        }

        // Continue here

    }
}
