import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Do you want to initialize the database? (Y/N)");
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equals("Y")) {
            DBInitialization.resetDatabase();
            DBInitialization.initianalize();
        }

        UserBoundary.initialize();
    }
}