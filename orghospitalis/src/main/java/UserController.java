public class UserController {

    private UserDAO userDAO;

    public UserController(){
        userDAO = new UserDAO();
    }

    public User login(String username, String password){
        return userDAO.login(username, password);
    }

    public  void register(String username, String password, String type){
        userDAO.createUser(username, password, type);
    }
}
