import java.time.LocalDateTime;

public class Showtime {
    
    private int id;
    private LocalDateTime time;
    private String theaterName;
    private String movieName;
    private String roomName;

    public Showtime(int id, LocalDateTime time, String theaterName, 
            String movieName, String roomName)
    {
        this.id = id;
        this.time = time;
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.roomName = roomName;
    }
    
    public LocalDateTime getTime(){return this.time;}
    public String getTheaterName(){return this.theaterName;}
    public String getMovieName(){return this.movieName;}
    public String getRoomName(){return this.roomName;}


}
