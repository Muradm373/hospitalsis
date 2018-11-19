import java.util.List;

public class OncologistController {
    private OncologistDAO oncologistDAO;

    public OncologistController() {
        oncologistDAO = new OncologistDAO();
    }

    public List<Oncologist> getAllOncologists(){
        return oncologistDAO.getAllOncologistsList();
    }

    public List<Oncologist> getAvailableOncologists(String date){
        return oncologistDAO.getAvailableOncologistsList(date);
    }

    public void deleteOncologist(String name){
        oncologistDAO.deleteOncologist(name);
    }

    public void specifyOncologists(List<String> names, String date){
        oncologistDAO.specifyOncologists(names, date);
    }

    public void addOncologist(String id, String name, String surname, String professionalID, String type, String careerLevel){
        Boolean flag = false;
        for(Oncologist oncologist : oncologistDAO.getAllOncologistsList()){
            if(oncologist.getId().equals(id)){
                flag = true;
            }
        }
        if(!flag) {
            oncologistDAO.addOncologist(id, name, surname, professionalID, type, careerLevel);
        }else{
            System.out.println("Oncologist with given ID exists.");
        }
    }
}
