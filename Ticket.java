import java.sql.Date;

public class Ticket {
    int id;
    int purchase_id;
    String seat_id;
    java.util.Date time;
    String showroom;
    double price;

    public Ticket(int purchase_num, String seat_num, Date time, String room){
        purchase_id = purchase_num;
        seat_id = seat_num;
        this.time = new java.util.Date(time.getTime());
        showroom=room;
        price = 20.00;
    }

    public java.util.Date getTime(){return this.time;}
}
