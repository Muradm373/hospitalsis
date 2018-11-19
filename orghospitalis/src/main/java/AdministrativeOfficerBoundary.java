import java.util.List;
import java.util.Scanner;

public class AdministrativeOfficerBoundary {

    public static void initialize(){

        Scanner scan = new Scanner(System.in);
        Integer choice;

        Boolean logout = false;
        while (true) {

            if (logout)
                break;

            System.out.println("Select an option:");
            System.out.println("1. Get list of surgeons");
            System.out.println("2. Add new surgeon");
            System.out.println("3. Get List of oncologists");
            System.out.println("4. Add new oncologist");
            System.out.println("5. Delete patient folder");
            System.out.println("6. Log out");


            choice = new Integer(scan.nextLine());

            SurgeonController surgeonController = new SurgeonController();
            OncologistController oncologistController = new OncologistController();
            switch (choice) {
                case 1:
                    List<Surgeon> allSurgeons = surgeonController.getAllSurgeons();
                    for(Surgeon surgeon: allSurgeons)
                        System.out.println(surgeon.getName());
                    break;
                case 2:
                    System.out.println("Insert ID of surgeon:");
                    String surgeonID = scan.nextLine();
                    System.out.println("Insert name of a surgeon:");
                    String surgeonName = scan.nextLine();
                    System.out.println("Insert surname of a surgeon:");
                    String surgeonSurname = scan.nextLine();
                    System.out.println("Insert professional ID of surgeon:");
                    String surgeonProfID = scan.nextLine();
                    System.out.println("Insert type of a surgeon:");
                    String surgeonType = scan.nextLine();
                    System.out.println("Insert career level of a surgeon:");
                    String surgeonLevel = scan.nextLine();

                    surgeonController.addSurgeon(surgeonID, surgeonName, surgeonSurname, surgeonProfID, surgeonType, surgeonLevel);
                    break;
                case 3:
                    List<Oncologist> allOncologists = oncologistController.getAllOncologists();
                    for(Oncologist oncologist: allOncologists)
                        System.out.println(oncologist.getName());
                    break;
                case 4:
                    System.out.println("Insert ID of oncologist:");
                    String oncologistID = scan.nextLine();
                    System.out.println("Insert name of a oncologist:");
                    String oncologistName = scan.nextLine();
                    System.out.println("Insert surname of a oncologist:");
                    String oncologistSurname = scan.nextLine();
                    System.out.println("Insert professional ID of oncologist:");
                    String oncologistProfID = scan.nextLine();
                    System.out.println("Insert type of a oncologist:");
                    String oncologistType = scan.nextLine();
                    System.out.println("Insert career level of a oncologist:");
                    String oncologistLevel = scan.nextLine();

                    oncologistController.addOncologist(oncologistID, oncologistName, oncologistSurname, oncologistProfID, oncologistType, oncologistLevel);

                    break;
                case 5:
                    PatientFolderController patientFolderController = new PatientFolderController();
                    System.out.println("Insert ID of patient folder you want to delete:");
                    String patientID = scan.nextLine();
                    patientFolderController.deletePatientFolder(patientID);
                    break;
                case 6:
                    logout = true;
                    break;


            }
        }

    }
}
