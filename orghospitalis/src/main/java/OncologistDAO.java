import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OncologistDAO {
    Connection con;
    public void addOncologist(String id, String name, String surname, String professionalID, String type, String careerLevel) {
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
                        stmt.executeUpdate("INSERT INTO oncologist (oncologistID, name, surname, profID, type, level, date) VALUES ('"+id+"','"+name+"','"+surname+"','"+professionalID+"','"+type+"','"+careerLevel+"','1');");
                        System.out.println("Oncologist added");
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


    public void deleteOncologist(String id){
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
                        stmt.executeQuery("DELETE FROM oncologist WHERE oncologistID = '" + id +"'");

                        System.out.println("Oncologist "+ id + " deleted");

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


    public List<Oncologist> getAllOncologistsList(){
        List<Oncologist> listOfAllOncologists= new ArrayList<Oncologist>();
        List<Oncologist> listOfAvailableOncologists = new ArrayList<Oncologist>();
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
                        ResultSet result = stmt.executeQuery("SELECT oncologistID, name, surname, profID, type, level, date FROM oncologist");

                        while (result.next()) {
                            Oncologist active_oncologist = new Oncologist(result.getString("oncologistID"),
                                    result.getString("name"),
                                    result.getString("surname"),
                                    result.getString("profID"),
                                    result.getString("type"),
                                    result.getString("level"));
                            active_oncologist.setDates(result.getString("date"));
                            listOfAllOncologists.add(active_oncologist);
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

        return listOfAvailableOncologists;
    }




    public List<Oncologist> getAvailableOncologistsList(String date){
        List<Oncologist> listOfAllOncologists= new ArrayList<Oncologist>();
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
                        ResultSet result = stmt.executeQuery("SELECT oncologistID, name, surname, profID, type, level, date FROM oncologist");

                        while (result.next()) {
                            Oncologist active_oncologist = new Oncologist(result.getString("oncologistID"),
                                    result.getString("name"),
                                    result.getString("surname"),
                                    result.getString("profID"),
                                    result.getString("type"),
                                    result.getString("level"));
                            active_oncologist.setDates(result.getString("date"));
                            listOfAllOncologists.add(active_oncologist);

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

        return listOfAllOncologists;
    }


    public void specifyOncologists(List<String> oncologists, String date){
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
                        ResultSet result = stmt.executeQuery("SELECT oncologistID, name, surname, profID, type, level, date FROM oncologist");

                        while (result.next()) {
                            Oncologist active_oncologist = new Oncologist(result.getString("oncologistID"),
                                    result.getString("name"),
                                    result.getString("surname"),
                                    result.getString("profID"),
                                    result.getString("type"),
                                    result.getString("level"));
                            active_oncologist.setDates(result.getString("date"));
                            if(oncologists.contains(active_oncologist.getName()))
                                stmt.executeUpdate("UPDATE oncologist SET date='"+(active_oncologist.getDates()+date)+"' WHERE name = '"+active_oncologist.getName()+"');");

                        }
                        System.out.println("Doctors specified.");
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
