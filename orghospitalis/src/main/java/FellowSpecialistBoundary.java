import java.util.List;
import java.util.Scanner;

public class FellowSpecialistBoundary {

    public static void initialize(){
        Boolean logout = false;
        Scanner scan = new Scanner(System.in);
        Integer choice;

        while (true) {

            if (logout)
                break;

            System.out.println("Select an option:");
            System.out.println("1. Add medicine to medicine list");
            System.out.println("2. Get List of all medicines");
            System.out.println("3. Add external test to patients folder");
            System.out.println("4. Add patient anamnesis to patient's folder");
            System.out.println("5. Write report to patient's folder");
            System.out.println("6. Book followup visit");
            System.out.println("7. Take decision");
            System.out.println("8. Log out");


            choice = new Integer(scan.nextLine());
            ReceptionistFellowController controller = new ReceptionistFellowController();
            PatientFolderController patientFolderController = new PatientFolderController();


            switch (choice) {
                case 1:
                    System.out.println("Insert medicine ID Code:");
                    String id = scan.nextLine();
                    System.out.println("Insert medicine name:");
                    String name = scan.nextLine();
                    System.out.println("Insert company:");
                    String company = scan.nextLine();
                    controller.addMedicineToDB(id, name, company);
                    break;
                case 2:
                    List<Medicine> medicines = controller.getListOfMedicines();

                    if(medicines != null) {
                        for (Medicine medicine : medicines) {
                            System.out.println(medicine.getId()+ " " + medicine.getName()+" "+medicine.getCompany());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Insert ID of patient:");
                    String patientID = scan.nextLine();
                    System.out.println("Insert test to add to folder:");
                    String patientTests = scan.nextLine();

                    patientFolderController.addTestsToFolder(patientID, patientTests);
                    break;
                case 4:
                    System.out.println("Insert ID of patient:");
                    patientID = scan.nextLine();
                    System.out.println("Insert test to add to folder:");
                    patientTests = scan.nextLine();

                    patientFolderController.addTestsToFolder(patientID, patientTests);
                    break;
                case 5:
                    System.out.println("Insert ID of patient:");
                    patientID = scan.nextLine();
                    System.out.println("Insert anamnesis to add to folder:");
                    String patientAnamnesis = scan.nextLine();

                    patientFolderController.addAnamnesisToFolder(patientID, patientAnamnesis);
                    break;
                case 6:
                    System.out.println("Insert ID of patient:");
                    patientID = scan.nextLine();
                    System.out.println("Insert report to add to folder:");
                    String patientReport = scan.nextLine();

                    patientFolderController.addTestsToFolder(patientID, patientReport);
                    break;
                case 7:
                    break;
                case 8:
                    logout = true;
                    break;


            }
        }
    }
}
