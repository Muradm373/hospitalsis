import java.util.ArrayList;
import java.util.List;

public class PatientFolderController {

    PatientFolderDAO patientFolderDAO;
    OncologistDAO oncologistDAO;

    PatientFolderController(){
        patientFolderDAO = new PatientFolderDAO();
        oncologistDAO = new OncologistDAO();
    }


    public void addFolder(String id, String name, String surname, String dateOfBirth,String insuranceType, String insuranceCode) {
        patientFolderDAO.addFolder(id, name, surname, dateOfBirth, insuranceType, insuranceCode);
    }

    public void specifyPersonalData(String id, String name, String surname, String dateOfBirth, String insuranceType, String insuranceCode){
        patientFolderDAO.specifyPersonalData(id, name, surname, dateOfBirth, insuranceCode, insuranceCode);
    }

    public void  addDateOfVisit(String date, String id){

        if(patientFolderDAO.getPatientIdList().contains(id)){
            patientFolderDAO.addDateOfVisit(date, id);
        }else{
            System.out.println("Patient folder doesn't exist.");
        }
    }


    public void addOncologist(String oncologistName, String date, String id) {
        if(oncologistDAO.getAvailableOncologistsList(date).contains(oncologistName)) {
            patientFolderDAO.addOncologist(oncologistName, date, id);
            List<String> onc = new ArrayList<String>();
            onc.add(oncologistName);
            oncologistDAO.specifyOncologists(onc, date);
            System.out.println("Oncologist assigned.");
        }else{
            System.out.println("Oncologist is busy on this date.");
        }
    }

    public void deletePatientFolder(String id){
        if(patientFolderDAO.getPatientIdList().contains(id)){
            patientFolderDAO.deletePatientFolder(id);
        }else{
            System.out.println("Patient folder doesn't exist.");
        }
    }

    public List<String> getPatientsList(){
        return patientFolderDAO.getPatientList();
    }

    public void addTestsToFolder(String id, String test){
        if(patientFolderDAO.getPatientIdList().contains(id)){
            patientFolderDAO.addTestToFolder(id,test);
        }else{
            System.out.println("Patient folder doesn't exist.");
        }
    }

    public void addAnamnesisToFolder(String id, String anamnesis){
        if(patientFolderDAO.getPatientIdList().contains(id)){
            patientFolderDAO.addAnamnesisToFolder(id,anamnesis);
        }else{
            System.out.println("Patient folder doesn't exist.");
        }
    }

    public void addReportToFolder(String id, String report){
        if(patientFolderDAO.getPatientIdList().contains(id)){
            patientFolderDAO.addReportToFolder(id,report);
        }else{
            System.out.println("Patient folder doesn't exist.");
        }
    }

    public void addPosologyToFolder(String id, String posology){
        if(patientFolderDAO.getPatientIdList().contains(id)){
            patientFolderDAO.addPosologyToFolder(id,posology);
        }else{
            System.out.println("Patient folder doesn't exist.");
        }
    }
}
