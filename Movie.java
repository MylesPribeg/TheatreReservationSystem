import java.time.LocalDate;

public class Movie{
    LocalDate releaseDate;
    String title;
    String genre;
    String theatre;
    boolean publicly_available;

    public Movie(String title, String theatre, String genre, boolean publicly_available) {
        this.title = title;
        this.theatre = theatre;
        this.genre = genre;
        this.publicly_available = publicly_available;
    }

    public String getTitle() {return title;}
    public String getTheatre() {return theatre;}
    public String getGenre() {return genre;}
    public boolean getPubliclyAvailabe() {return publicly_available;}
}