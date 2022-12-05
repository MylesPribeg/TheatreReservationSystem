import java.util.ArrayList;

public class ViewingsController{

    private User user;
    private ArrayList<Showtime> showtimes;
    private ViewStrategy vStrategy;

    public ViewingsController(User user){
        this.user = user;
        
        if(this.user instanceof RegisteredUser){
            this.vStrategy = new RegisteredViewStrategy();
        }
        else{
            this.vStrategy = new PublicViewStrategy();
        }

        this.showtimes = vStrategy.getAvailableShowtimes();
    }

    public void setViewStrategy(ViewStrategy s){
        this.vStrategy = s;
    }

    public ArrayList<Showtime> getShowtimes(){return this.showtimes;}

    public void setUser(User user){
        this.user = user;
    }

    public ArrayList<String> getAllMovieNames(){
        ArrayList<String> movies = new ArrayList<String>();

        for(Showtime st: showtimes){
            String mov = st.getMovieName();
            if(!movies.contains(mov)){
                movies.add(mov);
            }  
        }
        return movies;        
    }

    public ArrayList<String> getAllTheaterNames(){
        ArrayList<String> theaters = new ArrayList<String>();

        for(Showtime st: showtimes){
            String theat = st.getTheaterName();
            if(!theaters.contains(theat)){
                theaters.add(st.getTheaterName());
            }      
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