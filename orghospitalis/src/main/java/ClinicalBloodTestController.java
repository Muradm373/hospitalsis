public class ClinicalBloodTestController {
    ClinicalBloodTestDAO clinicalBloodTestDAO;

    public ClinicalBloodTestController() {
        clinicalBloodTestDAO = new ClinicalBloodTestDAO();
    }

    public void bookPlace(String date){
        if(clinicalBloodTestDAO.ifAvailable(date)){
            clinicalBloodTestDAO.bookPlace(date);
        }else{
            System.out.println("This date is already full, please choose another date.");
        }
    }
}
