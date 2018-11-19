import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientFolderDAO {
    static Connection con = null;


    public void addFolder(String id, String name, String surname, String dateOfBirth, String insuranceType, String insuranceCode) {
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
                        stmt.executeUpdate("INSERT INTO folder VALUES ('" + id + "','" + name + "','" + surname + "','" + dateOfBirth + "','" + insuranceType
                                + "','" + insuranceType + "', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);");

                        System.out.println("Folder added");
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


    public void specifyPersonalData(String id, String name, String surname, String dateOfBirth, String insuranceType, String insuranceCode) {
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
                        stmt.executeUpdate("UPDATE folder SET name =" + name + ", surname = " + surname + ", dateOfBirth =" + dateOfBirth +
                                ", insuranceType=" + insuranceType + ", insuranceCode = " + insuranceCode + " WHERE patientID =" + id);

                        System.out.println("Personal data updated.");
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

    public void addDateOfVisit(String date, String id) {
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
                        stmt.executeUpdate("UPDATE folder SET datesOfVisit = " + date + " WHERE patientID =" + id);

                        System.out.println("Date of visit added.");
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

    public void addOncologist(String oncologistName, String date, String id) {
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
                        stmt.executeUpdate("UPDATE folder SET oncologist = " + oncologistName + " WHERE patientID =" + id);

                        System.out.println("Oncologist assigned.");
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

    public void deletePatientFolder(String id) {
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
                        stmt.executeUpdate("DELETE FROM folder WHERE patientID = " + id + "");
                        System.out.println("Folder deleted.");
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


    public List<String> getPatientList() {
        List<String> listOfPatients = new ArrayList<String>();
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM folder");

                        while (result.next()) {
                            Folder selected_patient = new Folder(result.getString("patientID"),
                                    result.getString("name"), result.getString("surname"),
                                    result.getString("dateOfBirth"), result.getString("insuranceType"),
                                    result.getString("insuranceCode"));
                            listOfPatients.add(selected_patient.getId()+". " +selected_patient.getName()+" " + selected_patient.getSurname());
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

        return listOfPatients;
    }


    public List<String> getPatientIdList() {
        List<String> listOfPatients = new ArrayList<String>();
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM folder");

                        while (result.next()) {
                            Folder selected_patient = new Folder(result.getString("patientID"),
                                    result.getString("name"), result.getString("surname"),
                                    result.getString("dateOfBirth"), result.getString("insuranceType"),
                                    result.getString("insuranceCode"));
                            listOfPatients.add(selected_patient.getId());
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

        return listOfPatients;
    }


    public void addTestToFolder(String id, String test) {
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM folder");

                        String tests = result.getString("test");
                        stmt.executeUpdate("UPDATE folder SET test='" + tests + " \n" + test + "' WHERE patientID = '" + id + "');");


                        System.out.println("Tests updated.");
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

    public void addAnamnesisToFolder(String id, String anamnesis) {
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM folder");

                        String results = result.getString("anamnesis");
                        stmt.executeUpdate("UPDATE folder SET anamnesis='" + results + " \n" + anamnesis + "' WHERE patientID = '" + id + "');");


                        System.out.println("Anamnesis updated.");
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



    public void addReportToFolder(String id, String report) {
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM folder");

                        String results = result.getString("report");
                        stmt.executeUpdate("UPDATE folder SET report='" + results + " \n" + report + "' WHERE patientID = '" + id + "');");


                        System.out.println("Report updated.");
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




    public void addPosologyToFolder(String id, String posology) {
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
                        ResultSet result = stmt.executeQuery("SELECT * FROM folder");

                        String results = result.getString("posology");
                        stmt.executeUpdate("UPDATE folder SET posology='" + results + " \n" + posology + "' WHERE patientID = '" + id + "');");


                        System.out.println("Posology updated.");
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
