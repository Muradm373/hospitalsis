import java.sql.*;

public class ClinicalBloodTestDAO {
    static Connection con = null;

    public Boolean ifAvailable(String date){
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
                        ResultSet result = stmt.executeQuery("SELECT dates FROM clinicalBloodTests WHERE name = 'dates'");

                        String spot = result.getString("dates");

                        if(spot.contains(date)) return false;
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
        return true;
    }


    public void bookPlace(String date){
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM clinicalBloodTests");

                        String tests = result.getString("dates");
                        stmt.executeUpdate("UPDATE clinicalBloodTests SET dates='" + tests + date + "' WHERE dates = '" + tests + "');");


                        System.out.println("Tests booked.");
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
}
