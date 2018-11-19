import java.util.Scanner;

public class UserBoundary {

    public static void initialize() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            UserController userController = new UserController();
            User active_user;
            System.out.println("Select an option:");
            System.out.println("1. Create a new user");
            System.out.println("2. Login");

            int choice = new Integer(scan.nextLine());
            String username, password, type;
            switch (choice) {
                case 1:
                    System.out.println("Insert username:");
                    username = scan.nextLine();
                    System.out.println("Insert password:");
                    password = scan.nextLine();
                    System.out.println("Insert type: (Administrative Officer/Receptionist/Fellow/Specialist/Surgeon)");
                    type = scan.nextLine();
                    userController.register(username, password, type);

                    break;

                case 2:
                    System.out.println("Insert username:");
                    username = scan.nextLine();
                    System.out.println("Insert password:");
                    password = scan.nextLine();

                    active_user = userController.login(username, password);

                    if (active_user != null && active_user.getType() != null) {

                        if (active_user.getType().equals("Administrative Officer"))
                            AdministrativeOfficerBoundary.initialize();

                        if (active_user.getType().equals("Receptionist"))
                            ReceptionistBoundary.initialize();

                        if (active_user.getType().equals("Fellow") || active_user.getType().equals("Specialist"))
                            FellowSpecialistBoundary.initialize();

                        if (active_user.getType().equals("Surgeon"))
                            SurgeonBoundary.initialize();


                    }
                    break;
                default:
                    System.out.println("Try another value!");
                    break;
            }
        }
    }
}
