import java.util.ArrayList;

public class Theater{
    String name;
    String address; // location
    ArrayList<Movie> movies;
    ArrayList<Showroom> showrooms;
    ArrayList<Showtime> showtimes;

    public Theater(String name, String address){
        this.name = name;
        this.address = address;
    }

    
}