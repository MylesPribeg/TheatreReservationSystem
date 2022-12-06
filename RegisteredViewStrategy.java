import java.util.ArrayList;

public class RegisteredViewStrategy implements ViewStrategy{
    
    //returns a list of all showtimes in the database, including non-public showtimes
    public ArrayList<Showtime> getAvailableShowtimes(){
        return DatabaseController.getAllShowtimes();
    }
}
