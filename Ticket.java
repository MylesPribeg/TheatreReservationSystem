import java.util.Date;

public class Ticket {
    int id;
    int purchase_id;
    String seat_id;
    Date time;
    String showroom;
    double price;
    String theatre;
    
    public Ticket(int ticket_id, int purchase_num, String seat_num, Date time, String room, String theatre)
    {
        this(purchase_num, seat_num, time, room, theatre);
        this.id = ticket_id;
    }

    public Ticket(int purchase_num, String seat_num, Date time, String room, String theatre){
        purchase_id = purchase_num;
        seat_id = seat_num;
        this.time = time;
        showroom=room;
        this.price = 20.00;
        this.theatre = theatre;
    }

    public Date getTime(){return this.time;}
    public int getTicketId(){return this.id;}
    public int getPurchaseId(){return this.purchase_id;}
    public String getSeat(){return this.seat_id;}
    public String getShowroom(){return this.showroom;}
    public double getPrice(){return this.price;}
    public String getTheatre(){return this.theatre;}
}
