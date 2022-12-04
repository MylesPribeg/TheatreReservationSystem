import java.util.ArrayList;

public class PurchaseController {
    private Showtime showtime;
    private double seatCost = 20.00;

    public PurchaseController(Showtime showtime){
        this.showtime = showtime;
    }

    public ArrayList<Seat> getTakenSeats(){
        return DatabaseController.getTakenSeats(showtime);
    }

    public Purchase addTicketPurchase(String email, double cost){
        return DatabaseController.addPurchase(email, cost);     
    }

    public boolean validateCreditCard(CreditCard card){
        //hypothetically check if credit card exists/is valid
        return true;
    }

    public double getTotalCost(String email, int numSeats){
        return numSeats * seatCost - DatabaseController.getUserCredit(email);
    }

    public boolean validatePurchase(CreditCard card, double cost){
        //hypothetically user's bank performs purchase
        //returns true on success
        return card.charge(cost);
    }

    public void purchaseSeats(String email, ArrayList<Seat> seats, double totalCost){
        // at this point, users card has already been charged

        //add purchase object to the database and get the constructed object
        Purchase newPurchase = addTicketPurchase(email, totalCost);

        //update User's credit
        DatabaseController.subtractCredits(email, seats.size() *seatCost - totalCost);

        for(Seat seat: seats){

            Ticket newTicket = new Ticket(
                    newPurchase.getID(), 
                    seat.getSeatId(),
                    newPurchase.getDate(),
                    seat.getRoomName());
            
            DatabaseController.addTicket(newTicket);
        }
        // send email with tickets
        EmailController.sendPurchaseReceipt(showtime, email, seats, totalCost);

    }
    
}
