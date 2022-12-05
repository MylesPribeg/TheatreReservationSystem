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

    //returns false if there are over 10% seats being purchased for a non-public movie
    public boolean purchaseSeats(String email, ArrayList<Seat> seats, double totalCost, String theater){
        // at this point, users card has already been charged

        if(DatabaseController.moviePubliclyAvailable(showtime.getMovieName())){
            if(DatabaseController.getTakenSeats(showtime).size()>8){
                return false;
            }
        }

        //add purchase object to the database and get the constructed object
        Purchase newPurchase = addTicketPurchase(email, totalCost);

        //update User's credit
        DatabaseController.subtractCredits(email, seats.size() *seatCost - totalCost);

        for(Seat seat: seats){

            Ticket newTicket = new Ticket(
                    newPurchase.getID(), 
                    seat.getSeatId(),
                    newPurchase.getDate(),
                    seat.getRoomName(),
                    theater,
                    showtime.getMovieName());
            
            DatabaseController.addTicket(newTicket);
        }
        // send email with tickets
        EmailController.sendPurchaseReceipt(showtime, email, seats, totalCost);

        return true;
    }
    
}
