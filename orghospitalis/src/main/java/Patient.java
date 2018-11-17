import java.util.Date;

public class Patient {

    private String name, suranme, id = null;
    private Insurance insurance;
    private Date dateOfBirth;


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSuranme() {
        return suranme;
    }

    public String getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSuranme(String suranme) {
        this.suranme = suranme;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
