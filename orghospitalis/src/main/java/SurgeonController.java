import java.util.ArrayList;
import java.util.List;

public class SurgeonController {
    private SurgeonDAO surgeonDAO;

    public SurgeonController() {
        surgeonDAO = new SurgeonDAO();
    }

    public List<Surgeon> getAllSurgeons(){
        return surgeonDAO.getAllSurgeonsList();
    }

    public List<Surgeon> getAvailableSurgeons(String date){
        return surgeonDAO.getAvailableSurgeonsList(date);
    }



    public void deleteSurgeon(String name){
        surgeonDAO.deleteSurgeon(name);
    }

    public void specifySurgeons(List<String> names, String date){
        surgeonDAO.specifySurgeons(names, date);
    }

    public void addSurgeon(String id, String name, String surname, String professionalID, String type, String careerLevel){
        Boolean flag = false;
        for(Surgeon surgeon : surgeonDAO.getAllSurgeonsList()){
            if(surgeon.getId().equals(id)){
                flag = true;
            }
        }
        if(!flag) {
            surgeonDAO.addSurgeon(id, name, surname, professionalID, type, careerLevel);
        }else{
            System.out.println("Surgeon with given ID exists.");
        }
    }

    public void makeTeam(ArrayList<String> types, String date){
        List<Surgeon> surgeons = surgeonDAO.makeTeam(types, date);
        ArrayList<Surgeon> finalTeam = new ArrayList<Surgeon>();

        for(String type : types){
            for(Surgeon surgeon: surgeons){
                if(surgeon.getType().contains(type)){
                    finalTeam.add(surgeon);
                    break;
                }
            }
        }

        if(types.size() == finalTeam.size()){
            for(Surgeon surgeon : finalTeam)
                System.out.println(surgeon.getId()+". "+surgeon.getName()+" "+ surgeon.getSurname());
        }else{
            System.out.println("There are no specified oncologists that are free on this date.");
        }
    }
}
