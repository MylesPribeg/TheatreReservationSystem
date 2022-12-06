import java.util.ArrayList;

public class Theater{
    private String name;
    private String address; // location
    private ArrayList<Movie> movies;
    private ArrayList<Showroom> showrooms;
    private ArrayList<Showtime> showtimes;

    //constructor
    public Theater(String name, String address){
        this.name = name;
        this.address = address;
    }

    //getters
    public String getName(){return name;} 
    public String getAddress(){return address;}  
    public ArrayList<Movie> getMovies(){return movies;}
    public ArrayList<Showroom> getSHowrooms(){return showrooms;}
    public ArrayList<Showtime> getShowtimes(){return showtimes;}


    
}