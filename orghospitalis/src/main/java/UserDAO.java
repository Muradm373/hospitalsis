import java.sql.*;

public class UserDAO {

    static Connection con = null;
    public void createUser(String username, String password, String type) {
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
                        stmt.executeUpdate("INSERT INTO user (userID, password, type) VALUES ('" + username + "','" + password+"','"+type+"');");
                        System.out.println("User added");
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


    public User login(String username, String password){
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
                    ResultSet result = stmt.executeQuery("SELECT userID,password, type FROM user WHERE userID = '" + username + "'AND password = '"+password+"'");

                    while (result.next()) {
                        User active_user = new User(result.getString("userID"), result.getString("password"), result.getString("type"));
                        return  active_user;
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
}
