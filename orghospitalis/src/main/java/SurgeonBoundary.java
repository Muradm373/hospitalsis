import java.util.ArrayList;
import java.util.Scanner;

public class SurgeonBoundary {

    public static void initialize(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        Boolean logout = false;
        while (true) {

            if (logout)
                break;

            System.out.println("Select an option:");
            System.out.println("1. Define surgery team");
            System.out.println("2. Log out");


            String input = "";
            ArrayList<String> types = new ArrayList<String>();
            choice = new Integer(scan.nextLine());
            SurgeonController surgeonController = new SurgeonController();

            switch (choice) {
                case 1:
                    while (!(input = scan.nextLine()).equals("c"))
                    {
                       types.add(input);
                    }
                    System.out.println("Specify date(dd/mm/yyyy): ");
                    String date = scan.nextLine();

                    surgeonController.makeTeam(types, date);
                    break;
                case 2:
                    logout = true;
                    break;


            }
        }

    }
}
