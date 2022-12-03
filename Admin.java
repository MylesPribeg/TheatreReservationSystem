public class Admin extends User{

    private String password;

    public Admin(String email, String password){
        this.email = email;
        this.password = password;
    };

    public String getPassword(){
        return password;
    }

    public boolean addRU(RegisteredUser ru){
        // check if email already exists
        if(DatabaseController.emailExists(ru.getEmail())){
            return false;
        }
        
        //calls database and adds new User to the database
        DatabaseController.addRU(ru);
        return true;
    }

    //remove RU from database
    //returns false on failure
    public boolean removeRU(RegisteredUser ru)
    {
        if(DatabaseController.emailExists(ru.getEmail())){
            return false;
        }
        DatabaseController.removeRU(ru);
        return true;
    }

    //adds Admin to database
    public boolean addAdmin(Admin a){
        if(DatabaseController.adminUserExists(a.getEmail())){
            return false;
        }
        DatabaseController.addAdmin(a);
        return true;
    }

    //removes Admin from database
    public boolean removeAdmin(Admin a){

        if(DatabaseController.adminUserExists(a.getEmail())){
            DatabaseController.removeAdmin(a);
            return true;
        }
        return false;
    }

    //returns false if movie already exists
    public boolean addMovie(Movie movie){

        if(DatabaseController.movieExists(movie)){
            return false;
        }
        DatabaseController.addMovie(movie);
        return true;
    }

    //returns false if movie does not exist
    public boolean removeMovie(Movie movie){
    
        // if movie exists: remove movie
        if(DatabaseController.movieExists(movie)){
            DatabaseController.removeMovie(movie);
            return true;
        }
        return false;
    }

    public boolean addStaff(Staff staff){


        if (DatabaseController.staffExists(staff)){
            return false;
        }

        DatabaseController.addStaff(staff);
        return true;
    }


    public boolean removeStaff(Staff staff){
        if(DatabaseController.staffExists(staff)){
            DatabaseController.removeStaff(staff);
            return true;
        }
        return false;
    }

}
