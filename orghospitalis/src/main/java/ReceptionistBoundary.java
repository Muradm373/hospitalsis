import java.util.Scanner;

public class ReceptionistBoundary {

    public static void initialize(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        Boolean logout = false;
        while (true) {

            if (logout)
                break;

            System.out.println("Select an option:");
            System.out.println("1. Get list of patients");
            System.out.println("2. Specify personal data of patient");
            System.out.println("3. Specify date of visit");
            System.out.println("4. Assign specialist oncologist to visit");
            System.out.println("5. Open folder for a patient");
            System.out.println("6. Log out");


            choice = new Integer(scan.nextLine());

            PatientFolderController patientFolderController = new PatientFolderController();

            switch (choice) {
                case 1:
                    for (String names : patientFolderController.getPatientsList())
                        System.out.println(names);
                    break;
                case 2:
                    System.out.println("Insert ID of patient:");
                    String patientID = scan.nextLine();
                    System.out.println("Insert name of a patient:");
                    String patientName = scan.nextLine();
                    System.out.println("Insert surname of a patient:");
                    String patientSurname = scan.nextLine();
                    System.out.println("Insert date of birth of patient (dd/mm/yyyy):");
                    String patientDateOfBirth = scan.nextLine();
                    System.out.println("Insert insurance type of patient:");
                    String patientInsuranceType = scan.nextLine();
                    System.out.println("Insert insurance code of patient:");
                    String patientInsuranceCode = scan.nextLine();

                    patientFolderController.specifyPersonalData(patientID, patientName, patientSurname,
                            patientDateOfBirth, patientInsuranceType, patientInsuranceCode);
                    break;
                case 3:
                    System.out.println("Insert id of patient:");
                    patientID = scan.nextLine();
                    System.out.println("Insert next date of visit of patient (dd/mm/yyyy):");
                    String patientDateOfVisit = scan.nextLine();
                    patientFolderController.addDateOfVisit(patientID, patientDateOfVisit);
                    break;
                case 4:
                    System.out.println("Insert id of patient:");
                    patientID = scan.nextLine();
                    System.out.println("Insert oncologists name to assign:");
                    String patientsOncologist = scan.nextLine();
                    System.out.println("Insert date (dd/mm/yyyy):");
                    String date = scan.nextLine();
                    patientFolderController.addOncologist(patientID, date ,patientsOncologist);
                    break;
                case 5:
                    System.out.println("Insert ID of patient:");
                    patientID = scan.nextLine();
                    System.out.println("Insert name of a patient:");
                    patientName = scan.nextLine();
                    System.out.println("Insert surname of a patient:");
                    patientSurname = scan.nextLine();
                    System.out.println("Insert date of birth of patient (dd/mm/yyyy):");
                    patientDateOfBirth = scan.nextLine();
                    System.out.println("Insert insurance type of patient:");
                    patientInsuranceType = scan.nextLine();
                    System.out.println("Insert insurance code of patient:");
                    patientInsuranceCode = scan.nextLine();

                    patientFolderController.addFolder(patientID, patientName, patientSurname,
                            patientDateOfBirth, patientInsuranceType, patientInsuranceCode);
                    break;
                case 6:
                    logout = true;
                    break;


            }
        }
    }
}
