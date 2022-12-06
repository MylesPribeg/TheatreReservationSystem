import java.util.ArrayList;

public class CancelTicketController {
    
    private User user;

    //constructor
    //input user
    public CancelTicketController(User user){
        this.user = user;
    }

    //returns a list of all the tickets purchased by the user
    public ArrayList<Ticket> getPurchasedTickets(){
        return DatabaseController.getPurchasedTickets(user.getEmail());
    }

    //checks if movie for ticket is starting under 72 hours
    //returns false if movie starts in less than 72 hours, otherwise true
    public boolean validateTicket(Ticket ticket){

        java.util.Date ticketDate = ticket.getTime();

        java.util.Date curDate = new java.util.Date();
        if (ticketDate.getTime() - curDate.getTime() >= 259200000){
            return true;
        }
        return false;
    }

    //refunds ticket objects for user
    public void refundTickets(ArrayList<Ticket> tickets){
        boolean registered = false;
        if (user instanceof RegisteredUser){
            registered = true;
        }

        double refund = 0.0;
        for (Ticket ticket : tickets){
            // remove tickets from db
            DatabaseController.removeTicket(ticket);

            // give user credit
            if (registered){
                refund += 20.00;
            }
            else{
                // charge 15% fee for non-registered users
                refund += 17.00;
            }

            DatabaseController.addCredit(user.getEmail(), refund);
        }

        // send cancelation email
        EmailController.sendCancelationReceipt(user.getEmail(), refund, tickets);
    }
}
