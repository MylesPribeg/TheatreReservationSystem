import java.util.ArrayList;

public class EmailController {

    public void sendAnnouncements(){
        // get notif
    }

    public static void sendPurchaseReceipt(Showtime showtime, String email, ArrayList<Seat> seats){

        String contents = 
            "Thank your for your purchase!\n\n" +
            "Order Summary:\n\n"  +
            "Theater: " + showtime.getTheaterName() + "\n" +
            "Movie: " + showtime.getMovieName() + "\n" +
            "Total Cost: " + seats.size() + " X $" + 20.00 + " = $"+ seats.size() * 20.00 + "\n\n" +
            "--------------------------------------------\n\n";

        for(int i=0;i<seats.size();i++){
            contents += 
                "TICKET " + i + "\n\n" +
                "Theater: " + showtime.getTheaterName() + "\n" + 
                "Showroom: " + showtime.getRoomName() + "\n" + 
                "Seat: " + seats.get(i).getSeatId() + "\n" + 
                "Movie: " + showtime.getMovieName()+ "\n" + 
                "Time: " + showtime.getTime() + "\n" + 
                "-----------------\n\n";
        }

        //send out email to user
        System.out.println(contents);
    }


}
