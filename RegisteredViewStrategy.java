import java.util.ArrayList;

public class RegisteredViewStrategy implements ViewStrategy{
    
    public ArrayList<Showtime> getAvailableShowtimes(){
        return DatabaseController.getAllShowtimes();
    }
}
