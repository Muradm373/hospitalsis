import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurgeonDAO {
    Connection con;
    public void addSurgeon(String id, String name, String surname, String professionalID, String type, String careerLevel) {
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
                        stmt.executeUpdate("INSERT INTO surgeon (surgeonID, name, surname, profID, type, level, date) VALUES ('"+id+"','"+name+"','"+surname+"','"+professionalID+"','"+type+"','"+careerLevel+"','1');");
                        System.out.println("Surgeon added");
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


    public void deleteSurgeon(String id){
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
                        stmt.executeQuery("DELETE FROM surgeon WHERE surgeonID = '" + id +"'");

                        System.out.println("Surgeon "+ id + " deleted");

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


    public List<Surgeon> getAllSurgeonsList(){
        List<Surgeon> listOfAllSurgeons= new ArrayList<Surgeon>();
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
                        ResultSet result = stmt.executeQuery("SELECT surgeonID, name, surname, profID, type, level, date FROM surgeon");

                        while (result.next()) {
                            Surgeon active_surgeon = new Surgeon(result.getString("surgeonID"),
                                    result.getString("name"),
                                    result.getString("surname"),
                                    result.getString("profID"),
                                    result.getString("type"),
                                    result.getString("level"));
                            active_surgeon.setDates(result.getString("date"));
                            listOfAllSurgeons.add(active_surgeon);
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

        return listOfAllSurgeons;
    }

    public List<Surgeon>  makeTeam(ArrayList<String> types, String date){
        List<Surgeon> listOfSelectedSurgeons= new ArrayList<Surgeon>();
        List<Surgeon> team = new ArrayList<Surgeon>();
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

                        for (String type : types) {
                            ResultSet result = stmt.executeQuery("SELECT  surgeonID, name, surname, profID, type, level, date FROM surgeon WHERE type = '" + type+"'");

                            while (result.next()) {
                                Surgeon active_surgeon = new Surgeon(result.getString("surgeonID"),
                                        result.getString("name"),
                                        result.getString("surname"),
                                        result.getString("profID"),
                                        result.getString("type"),
                                        result.getString("level"));
                                active_surgeon.setDates(result.getString("date"));
                                listOfSelectedSurgeons.add(active_surgeon);
                            }
                        }

                        for(Surgeon surgeon: listOfSelectedSurgeons){
                            if(!surgeon.getDates().contains(date)){
                                team.add(surgeon);
                            }
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

        return team;
    }




    public List<Surgeon> getAvailableSurgeonsList(String date){
        List<Surgeon> listOfAllSurgeons= new ArrayList<Surgeon>();
        List<Surgeon> listOfAvailableSurgeons= new ArrayList<Surgeon>();
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
                        ResultSet result = stmt.executeQuery("SELECT surgeonID, name, surname, profID, type, level, date FROM surgeon");

                        while (result.next()) {
                            Surgeon active_surgeon = new Surgeon(result.getString("surgeonID"),
                                    result.getString("name"),
                                    result.getString("surname"),
                                    result.getString("profID"),
                                    result.getString("type"),
                                    result.getString("level"));
                            active_surgeon.setDates(result.getString("date"));
                            listOfAllSurgeons.add(active_surgeon);


                        }
                        for(Surgeon surgeon : listOfAllSurgeons){
                            if(!surgeon.getDates().contains(date)){
                                listOfAvailableSurgeons.add(surgeon);
                            }
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

        return listOfAvailableSurgeons;
    }


    public void specifySurgeons(List<String> surgeons, String date){
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
                        ResultSet result = stmt.executeQuery("SELECT surgeonID, name, surname, profID, type, level, date FROM surgeon");

                        while (result.next()) {
                            Surgeon active_surgeon = new Surgeon(result.getString("surgeonID"),
                                    result.getString("name"),
                                    result.getString("surname"),
                                    result.getString("profID"),
                                    result.getString("type"),
                                    result.getString("level"));
                            active_surgeon.setDates(result.getString("date"));
                            if(surgeons.contains(active_surgeon.getName()))
                                stmt.executeUpdate("UPDATE surgeon SET date='"+(active_surgeon.getDates()+date)+"' WHERE name = '"+active_surgeon.getName()+"');");

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
