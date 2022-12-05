import java.util.ArrayList;

public class Showroom {
    private ArrayList<Seat> seats;
    private String theater_name;

    public Showroom(String theater){
        this.theater_name = theater;
    }

    public String getTheater(){return theater_name;}
    public ArrayList<Seat> seats(){return seats;}
}
