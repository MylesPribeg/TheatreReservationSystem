import java.util.Date;

public class Showtime {
    
    private Date time;
    private String theaterName;
    private String movieName;
    private String roomName;

    //constructor
    public Showtime(Date time, String theaterName, 
            String movieName, String roomName)
    {
        this.time = time;
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.roomName = roomName;
    }
    
    //getters
    public Date getTime(){return this.time;}
    public String getTheaterName(){return this.theaterName;}
    public String getMovieName(){return this.movieName;}
    public String getRoomName(){return this.roomName;}


}
