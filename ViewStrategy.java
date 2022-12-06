import java.util.ArrayList;

public interface ViewStrategy {
    //return all showtimes available to the user
    public ArrayList<Showtime> getAvailableShowtimes();
}
