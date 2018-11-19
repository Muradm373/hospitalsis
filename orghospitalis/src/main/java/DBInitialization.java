import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInitialization {
    public static void initianalize(){
        Connection con = null;

        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            //Creating the connection with HSQLDB
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "" );
            if (con!= null){
                System.out.println("Connection created successfully");

                Statement stmt = null;
                try {
                    Class   .forName("org.hsqldb.jdbc.JDBCDriver");
                    stmt = con.createStatement();

                    stmt.executeUpdate("CREATE TABLE user (userID varchar(20) NOT NULL, password varchar(20), type varchar(60), PRIMARY KEY (userID));");
                    stmt.executeUpdate("CREATE TABLE medicine (medicineID varchar(20) NOT NULL, name varchar(20), company varchar(60), PRIMARY KEY (medicineID));");
                    stmt.executeUpdate("CREATE TABLE surgeon (surgeonID varchar(20) NOT NULL, name varchar(20), surname varchar(60), profID varchar(60), type varchar(60), level varchar(60),date varchar(10000), PRIMARY KEY (surgeonID));");
                    stmt.executeUpdate("CREATE TABLE oncologist (oncologistID varchar(20) NOT NULL, name varchar(20), surname varchar(60), profID varchar(60), type varchar(60), level varchar(60),date varchar(10000), PRIMARY KEY (oncologistID));");
                    stmt.executeUpdate("CREATE TABLE folder (patientID varchar(20) NOT NULL, name varchar(20), surname varchar(60), insuranceType varchar(60), insuranceCode varchar(60), dateOfBirth varchar(60),datesOfVisit varchar(10000),surgeryDate varchar(10000), anamnesis varchar(10000), oncologist varchar(10000), surgery varchar(10000), posology varchar(10000), tests varchar(10000), report varchar(10000), PRIMARY KEY (patientID));");
                    stmt.executeUpdate("CREATE TABLE clinicalBloodTests (dates varchar(1000));");
                    stmt.executeUpdate("CREATE TABLE clinicalImagingTests (dates varchar(1000));");

                    stmt.executeQuery("INSERT INTO clinicalBloodTests VALUES (' ');");
                    stmt.executeQuery("INSERT INTO clinicalImagingTests VALUES (' ');");
                    System.out.println("Database initialized successfully");
                }catch (Exception e) {
                    e.printStackTrace(System.out);
                }

            }else{
                System.out.println("Problem with creating connection");
            }

        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    public static void resetDatabase(){
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
            stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE user;");
            stmt.executeUpdate("DROP TABLE medicine;");
            stmt.executeUpdate("DROP TABLE oncologist;");
            stmt.executeUpdate("DROP TABLE surgeon;");
            stmt.executeUpdate("DROP TABLE folder;");
            stmt.executeUpdate("DROP TABLE clinicalImagingTests;");
            stmt.executeUpdate("DROP TABLE clinicalBloodTests;");
        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
