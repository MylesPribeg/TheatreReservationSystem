import java.util.ArrayList;

public class DatabaseController{


    //LOGIN STUFF

    //check if there is a RU with specified email
    public static boolean emailExists(String email){
        return false;
    }

    // check database for Admin with given username and password
    public static boolean verifyAdmin(Admin a){
        return false;
    }

    //verify that there is a RU with given email and password
    public static boolean RUExists(String email, String password){
        return false;
    }

    //return Registered User object with given email
    public static RegisteredUser getRU(String email){
        return null;
    }

    //add registered user to database
    //return true for success
    public static boolean addRU(RegisteredUser ru){
        return false;
    }

    //remove RU from database
    //return false if failed
    public static boolean removeRU(RegisteredUser ru){
        return false;
    }

    //adds Admin to database
    public static boolean addAdmin(Admin a){
        return false;
    }

    //check if admin email exists
    public static boolean adminUserExists(String email){
        return false;
    }

    //remove admin from database
    public static boolean removeAdmin(Admin a){
        return false;
    }

    //check if movie exists
    public static boolean movieExists(Movie movie){
        return false;
    }

    //add movie
    public static boolean addMovie(Movie movie){
        return false;
    }

    //remove movie
    public static boolean removeMovie(Movie movie){
        return false;
    }

    //check if staff member exists
    public static boolean staffExists(Staff s){
        return false;
    }

    //add staff member
    public static boolean addStaff(Staff s){
        return false;
    }

    //remove staff member
    public static boolean removeStaff(Staff s){
        return false;
    }

    //VIEWING STUFF

    //returns list of all showtime objects
    public static ArrayList<Showtime> getAllShowtimes(){
        return null;
    }

    //returns list of all showtime objects with public movies
    public static ArrayList<Showtime> getPublicShowtimes(){
        return null;
    }

    //returns list of strings of all public movie titles
    public static ArrayList<String> getPublicMovies(){
        return null;
    }

    //returns list of strings of all movie titles
    public static ArrayList<String> getAllMovies(){
        return null;
    }

    //returns list of strings of all theaters
    public static ArrayList<String> getAllTheaters(){
        return null;
    }

    // SEAT STUFF

    public static ArrayList<Seat> getTakenSeats(Showtime showtime){
        return null;
    }

    //return the completed purchase object with id + date
    public static Purchase addPurchase(String email, double cost){
        return null;
    }

    //adds a ticket to the Ticket table in database
    public static void addTicket(Ticket ticket){
        return;
    }

    // remove ticket
    public static void removeTicket(Ticket t){
        // remove ticket from database
    }

    // get purchase
    public static ArrayList<Ticket> getPurchasedTickets(String email){
        // search database for all purchases under the given email
        // return list of all tickets
        return null;
    }

    public static void addCredit(String email, double amount){
        // adds amount to the credit of user with this email
        return;
    }

    //get credit for user with given email
    public static double getUserCredit(String email){
        return -1;
    }

    //subtract credits from user's account
    public static void subtractCredits(String email, double credits){
        return;
    }

    public static void updatePaymentDate(String email){
        // sets the last payment date of this user to the current date
    }
}