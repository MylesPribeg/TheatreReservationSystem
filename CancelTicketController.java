import java.util.ArrayList;

import java.sql.Date;

public class CancelTicketController {
    
    private User user;

    public CancelTicketController(User user){
        this.user = user;
    }

    public ArrayList<Ticket> getPurchasedTickets(){
        return DatabaseController.getPurchasedTickets(user.getEmail());
    }

    //check if ticket is over 72 hours
    public boolean validateTicket(Ticket ticket){

        java.util.Date ticketDate = ticket.getTime();

        java.util.Date curDate = new java.util.Date();
        if (ticketDate.getTime() - curDate.getTime() >= 259200000){
            return true;
        }
        return false;
    }

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
