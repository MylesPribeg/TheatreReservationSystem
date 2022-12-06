import java.util.ArrayList;

public class Admin extends User{

    private String password;

    //constructor
    public Admin(String email, String password){
        this.email = email;
        this.password = password;
    };

    //getters
    public String getPassword(){
        return password;
    }

    //add RU to the database
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
    public boolean addAdmin(Admin admin){
        if(DatabaseController.adminUserExists(admin.getEmail())){
            return false;
        }
        DatabaseController.addAdmin(admin);
        return true;
    }

    //removes Admin from database
    public boolean removeAdmin(Admin admin){

        if(DatabaseController.adminUserExists(admin.getEmail())){
            DatabaseController.removeAdmin(admin);
            return true;
        }
        return false;
    }

    //adds a movie to the database. Returns false if movie already exists
    public boolean addMovie(Movie movie){

        if(DatabaseController.movieExists(movie.getTitle())){
            return false;
        }
        DatabaseController.addMovie(movie);
        return true;
    }

    //removes movie frmo the database. returns false if movie does not exist
    public boolean removeMovie(Movie movie){
    
        // if movie exists: remove movie
        if(DatabaseController.movieExists(movie.getTitle())){
            DatabaseController.removeMovie(movie.getTitle());
            return true;
        }
        return false;
    }

    //add staff member to the database
    public boolean addStaff(Staff staff){
        return DatabaseController.addStaff(staff);
    }

    //remove staff member from the database
    public boolean removeStaff(Staff staff){
        return  DatabaseController.removeStaff(staff);
    }

    //returns a list of all staff members in the database
    public ArrayList<Staff> getAllStaff() {
        return DatabaseController.getAllStaff();
    }

}
