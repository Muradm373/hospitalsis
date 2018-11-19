import java.util.ArrayList;
import java.util.Scanner;

public class ClinicalTestsBoundary {
    public static void initialize(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        Boolean logout = false;
        while (true) {

            if (logout)
                break;

            System.out.println("Select an option:");
            System.out.println("1. Book blood test");
            System.out.println("2. Book imaging test");
            System.out.println("3. Back");


            String input;
            ArrayList<String> types = new ArrayList<String>();
            choice = new Integer(scan.nextLine());
            SurgeonController surgeonController = new SurgeonController();
            ClinicalBloodTestController clinicalBloodTestController = new ClinicalBloodTestController();
            ClinicalImagingTestController clinicalImagingTestController = new ClinicalImagingTestController();
            switch (choice) {
                case 1:
                    System.out.println("Choose date (dd/mm/yyyy):");
                    input = scan.nextLine();
                    clinicalBloodTestController.bookPlace(input);


                    break;
                case 2:
                    System.out.println("Choose date (dd/mm/yyyy):");
                    input = scan.nextLine();
                    clinicalBloodTestController.bookPlace(input);
                    break;
                case 3:
                    logout = true;



            }
        }

    }
}
