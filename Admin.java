import java.util.ArrayList;

/**
 * Admin user can perform actions such as 
 * adding/removing users, movies, and staff members
 * 
 * @author Gabriel Lau
 * @version 4.4
 */

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

    /**
     * Adds a RegisteredUser object to the system
     * @param ru The user to be added
     * @return true on success
     */
    public boolean addRU(RegisteredUser ru){
        // check if email already exists
        if(DatabaseController.emailExists(ru.getEmail())){
            return false;
        }
        
        //calls database and adds new User to the system
        DatabaseController.addRU(ru);
        return true;
    }

    /**
     * Removes a RegisteredUser from the system
     * @param ru The user to be removed
     * @return true on success
     */
    public boolean removeRU(RegisteredUser ru)
    {
        if(DatabaseController.emailExists(ru.getEmail())){
            DatabaseController.removeRU(ru);
            return true;
        }
        
        return false;
    }

    /**
     * Adds another Admin to system
     * @param admin the Admin to be added
     * @return true on success
     */
    public boolean addAdmin(Admin admin){
        if(DatabaseController.adminUserExists(admin.getEmail())){
            return false;
        }
        DatabaseController.addAdmin(admin);
        return true;
    }

    /**
     * Removes an Admin from the system
     * @param admin the Admin to be removed
     * @return true on success
     */
    public boolean removeAdmin(Admin admin){

        if(DatabaseController.adminUserExists(admin.getEmail())){
            DatabaseController.removeAdmin(admin);
            return true;
        }
        return false;
    }

    /**
     * Adds a movie to the system
     * @param movie the Movie to be added
     * @return false if the movie already exists
     */
    public boolean addMovie(Movie movie){

        if(DatabaseController.movieExists(movie.getTitle())){
            return false;
        }
        DatabaseController.addMovie(movie);
        return true;
    }

    /**
     * Removes  a move from the system if it exists
     * @param movie the Movie to be removed
     * @return false if the movie cannot be found
     */
    public boolean removeMovie(Movie movie){
    
        // if movie exists: remove movie
        if(DatabaseController.movieExists(movie.getTitle())){
            DatabaseController.removeMovie(movie.getTitle());
            return true;
        }
        return false;
    }

    /**
     * Adds a staff member to the system
     * @param staff
     * @return
     */
    public boolean addStaff(Staff staff){
        return DatabaseController.addStaff(staff);
    }

    //remove staff member from the database
    /**
     * 
     * @param staff
     * @return
     */
    public boolean removeStaff(Staff staff){
        return  DatabaseController.removeStaff(staff);
    }

    //returns a list of all staff members in the database
    public ArrayList<Staff> getAllStaff() {
        return DatabaseController.getAllStaff();
    }

}
