public class LoginController{
    
    //singleton design pattern

    //singleton instance
    private static LoginController onlyInstance;
    
    //private constructor
    private LoginController(){}
    
    //returns only instance for singleton
    public static LoginController getOnlyInstance(){
        if(onlyInstance ==null){
            onlyInstance = new LoginController();
        }
        return onlyInstance;
    }

    //check if a RU already has given email
    public boolean emailExists(String email){

        if(DatabaseController.emailExists(email)){
            return true;
        }
        return false;
    }

    //verify Admin login
    public boolean verifyAdmin(Admin a){
        
        if (DatabaseController.verifyAdmin(a))
            return true;
        else    
            return false;
    }
    
    
    //return RU object if RU correctly gives email and password
    //otherwise return null
    public RegisteredUser RUSignIn(String email, String password){
        
        //check RU database for user with email and password
        if(DatabaseController.RUExists(email, password)){
            // create RU object with information from database
            return DatabaseController.getRU(email);
        }
        return null;
    }

    //create generic user object for guest
    public User guestSignIn(){
        return new User();
    }

    //adds user with given email to the database
    public boolean addUser(String email) {
        return DatabaseController.addUser(null);
    }

    //return User object associated with
    public User getUser(String email) {
        return DatabaseController.getUser(email);
    }

    //adds registeredUser to database and returns true on success
    //if email is already in use, returns false
    public boolean registerUser(RegisteredUser ru){
        
        // check if email already exists
        if(DatabaseController.emailExists(ru.getEmail())){
            return false;
        }
        
        //calls database and adds new User to the database
        DatabaseController.addRU(ru);
        return true;
    }

    //checks if Admin login is valid
    //return Admin object if valid, otherwise returns null
    public boolean adminSignIn(Admin a){

        if (verifyAdmin(a)){
            return true;
        }
        return false;
    }
}
