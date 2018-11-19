import java.util.List;

public class ReceptionistFellowController {

    private MedicineDAO medicineDAO;

    ReceptionistFellowController(){
        medicineDAO = new MedicineDAO();
    }

    public Medicine getMedicineByName(String name){
        return medicineDAO.findMedicine(name);
    }

    public List<Medicine> getListOfMedicines(){
        return medicineDAO.getMedicinesList();
    }

    public void addMedicineToDB(String id, String name, String company){
        medicineDAO.addMedicine(id, name, company);
    }
}
