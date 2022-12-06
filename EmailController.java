import java.util.ArrayList;

public class EmailController {

    //send public announcements about movies to all registered users
    public void sendAnnouncements(String message){
        ArrayList<String> emails = DatabaseController.getAllRUEmails();
        for(String email: emails){
            email = ""; //remove this line to send email to given emails
            //SendEmail.send(email, message, "Movie Announcement");
        }
    }

    //send cancelation receipt to user's email
    public static void sendCancelationReceipt(String email, double refund, ArrayList<Ticket> tickets){
        
        String contents = 
            "Thank you for your purchase!\n\n" +
            "Order Summary:\n\n"  +
            "Theater: " + tickets.get(0).getTheatre() + "\n" +
            "Movie: " + tickets.get(0).getMovie() + "\n" +
            "Credits earned: $" + refund + "\n" +
            "--------------------------------------------\n\n";

        for(int i=0;i<tickets.size();i++){
            contents += 
                "TICKET " + (i+1) + "\n\n" +
                "Theater: " + tickets.get(i).getTheatre() + "\n" + 
                "Showroom: " + tickets.get(i).getShowroom() + "\n" + 
                "Seat: " + tickets.get(i).getSeat() + "\n" + 
                "Movie: " + tickets.get(i).getMovie() + "\n" + 
                "Time: " + tickets.get(i).getTime() + "\n" + 
                "-----------------\n\n";
        }

        //send out email to user
        System.out.println(contents);
        //SendEmail.send(email, contents, "Refund Receipt");
    }

    //sends a receipt and purchased tickets to user with given email
    public static void sendPurchaseReceipt(Showtime showtime, String email, ArrayList<Seat> seats, double totalCost){
        double seatCost = 20.00;

        double credit = seats.size() * seatCost - totalCost;

        String contents = 
            "Thank you for your purchase!\n\n" +
            "Order Summary:\n\n"  +
            "Theater: " + showtime.getTheaterName() + "\n" +
            "Movie: " + showtime.getMovieName() + "\n" +
            "Ticket Cost: " + seats.size() + " X $" + 20.00 + " = $"+ seats.size() * 20.00 + "\n" +
            "Credits applied: $" + credit + "\n" +
            "Total Cost: " + totalCost + "\n" +
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
        //SendEmail.send(email, contents, "Purchase Receipt");
    }

}