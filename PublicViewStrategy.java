import java.util.ArrayList;

public class PublicViewStrategy implements ViewStrategy{
    public ArrayList<Showtime> getAvailableShowtimes(){
        return DatabaseController.getPublicShowtimes();
    }
}
