import java.util.ArrayList;

public class PublicViewStrategy implements ViewStrategy{
    //returns all showtimes objects with movies that are public
    public ArrayList<Showtime> getAvailableShowtimes(){
        return DatabaseController.getPublicShowtimes();
    }
}
