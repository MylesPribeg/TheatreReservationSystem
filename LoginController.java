public class LoginController{

    //check if a RU already has given email
    public static boolean emailExists(String email){

        if(DatabaseController.emailExists(email)){
            return true;
        }
        return false;
    }

    //verify Admin login
    public static boolean verifyAdmin(Admin a){
        
        if (DatabaseController.verifyAdmin(a))
            return true;
        else    
            return false;
    }
    
    
    //return RU object if RU correctly gives email and password
    //otherwise return null
    public static RegisteredUser RUSignIn(String email, String password){
        
        //check RU database for user with email and password
        if(DatabaseController.RUExists(email, password)){
            // create RU object with information from database
            return DatabaseController.getRU(email);
        }
        return null;
    }

    //create generic user object for guest
    public static User guestSignIn(){
        return new User();
    }

    //adds registeredUser to database and returns true on success
    //if email is already in use, returns false
    public static boolean registerUser(RegisteredUser ru){
        
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
    public static boolean adminSignIn(Admin a){

        if (verifyAdmin(a)){
            return true;
        }
        return false;
    }
}