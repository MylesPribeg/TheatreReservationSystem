import java.util.ArrayList;

public class Showroom {
    private ArrayList<Seat> seats;
    private String theater_name;

    //constructor
    public Showroom(String theater){
        this.theater_name = theater;
    }

    //getters
    public String getTheater(){return theater_name;}
    public ArrayList<Seat> seats(){return seats;}
}
