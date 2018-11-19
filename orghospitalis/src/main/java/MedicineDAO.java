import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
    static Connection con = null;
    public void addMedicine(String id, String name, String company) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try {
                con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
                if (con != null) {

                    Statement stmt = null;
                    try {
                        Class.forName("org.hsqldb.jdbc.JDBCDriver");
                        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
                        stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO medicine (medicineID, name, company) VALUES ('" + id + "','" + name+"','"+company+"');");
                        System.out.println("Medicine added");
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public Medicine findMedicine(String name){
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try {
                con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
                if (con != null) {

                    Statement stmt = null;
                    try {
                        Class.forName("org.hsqldb.jdbc.JDBCDriver");
                        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
                        stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery("SELECT medicineID, name, company FROM medicine WHERE name = '" + name +"'");

                        while (result.next()) {
                            Medicine selected_medicine = new Medicine(result.getString("medicineID"), result.getString("name"), result.getString("company"));
                            return  selected_medicine;
                        }
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Medicine> getMedicinesList(){
        List<Medicine> listOfMedicines= new ArrayList<Medicine>();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try {
                con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
                if (con != null) {

                    Statement stmt = null;
                    try {
                        Class.forName("org.hsqldb.jdbc.JDBCDriver");
                        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/testdb", "SA", "");
                        stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery("SELECT medicineID, name, company FROM medicine");

                        while (result.next()) {
                            Medicine selected_medicine = new Medicine(result.getString("medicineID"), result.getString("name"), result.getString("company"));
                            listOfMedicines.add(selected_medicine);
                        }
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listOfMedicines;
    }
}
