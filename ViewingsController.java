import java.util.ArrayList;

public class ViewingsController{

    User user;

    public ViewingsController(User user){
        this.user = user;
    }

    public ArrayList<Theater> getAllTheaters(){
        return DatabaseController.getAllTheaters();
    }

    public ArrayList<Movie> getVisibleMovies(){
        s.getVisibleMovies();
    }
}