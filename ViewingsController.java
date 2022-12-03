import java.util.ArrayList;

import javax.xml.crypto.Data;

public class ViewingsController{

    private User user;
    private ArrayList<Showtime> showtimes;

    public ViewingsController(User user){
        this.user = user;
        
        if(this.user instanceof User){
            this.showtimes = DatabaseController.getPublicShowtimes();
        }
        else{
            this.showtimes = DatabaseController.getAllShowtimes();
        }
    }

    public ArrayList<Showtime> getShowtimes(){return this.showtimes;}

    public void setUser(User user){
        this.user = user;
    }

    public ArrayList<String> getAllMovieNames(){
        ArrayList<String> movies = new ArrayList<String>();

        for(Showtime st: showtimes){
            movies.add(st.getMovieName());
        }
        return movies;        
    }

    public ArrayList<String> getAllTheaterNames(){
        ArrayList<String> theaters = new ArrayList<String>();

        for(Showtime st: showtimes){
            theaters.add(st.getTheaterName());
        }
        return theaters;
    }

    public ArrayList<Showtime> getFilteredList(String movieName, String theaterName){

        movieName = movieName.toUpperCase();
        theaterName = theaterName.toUpperCase();
        ArrayList<Showtime> filteredList = new ArrayList<>();
        for(Showtime st: showtimes){
            if(st.getMovieName().toUpperCase().contains(movieName) &&
                    st.getTheaterName().toUpperCase().contains(theaterName))
            {
                filteredList.add(st);
            }
        }
        return filteredList;
    }
}