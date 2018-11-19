public class ClinicalImagingTestController {
    ClinicalImagingTestDAO clinicalImagingTestDAO;

    public ClinicalImagingTestController() {
        clinicalImagingTestDAO = new ClinicalImagingTestDAO();
    }

    public void bookPlace(String date){
        if(clinicalImagingTestDAO.ifAvailable(date)){
            clinicalImagingTestDAO.bookPlace(date);
        }else{
            System.out.println("This date is already full, please choose another date.");
        }
    }
}
