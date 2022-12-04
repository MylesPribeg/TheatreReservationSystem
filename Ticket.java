import java.sql.Date;

public class Ticket {
    int id;
    int purchase_id;
    String seat_id;
    Date showtime;
    String showroom;
    double price;

    public Ticket(int purchase_num, String seat_num, Date showtime, String room){
        purchase_id = purchase_num;
        seat_id = seat_num;
        this.showtime=showtime;
        showroom=room;
        price = 20.00;
    }
}
