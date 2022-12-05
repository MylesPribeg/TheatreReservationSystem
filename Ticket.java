import java.util.Date;

public class Ticket {
    int id;
    int purchase_id;
    String seat_id;
    Date time;
    String showroom;
    double price;
    String theatre;
    String movie;
    
    public Ticket(int ticket_id, int purchase_id, String seat_id, Date time, String room, String theatre, String movie)
    {
        this(purchase_id, seat_id, time, room, theatre, movie);
        this.id = ticket_id;
    }

    public Ticket(int purchase_id, String seat_id, Date time, String room, String theatre, String movie){
        this.purchase_id = purchase_id;
        this.seat_id = seat_id;
        this.time = time;
        showroom=room;
        this.price = 20.00;
        this.theatre = theatre;
        this.movie = movie;
    }

    public Date getTime(){return this.time;}
    public int getTicketId(){return this.id;}
    public int getPurchaseId(){return this.purchase_id;}
    public String getSeat(){return this.seat_id;}
    public String getShowroom(){return this.showroom;}
    public double getPrice(){return this.price;}
    public String getTheatre(){return this.theatre;}
    public String getMovie(){return this.movie;}
}
