import java.util.ArrayList;

public class PurchaseController {
    private Showtime showtime;
    private double seatCost = 20.00;

    //constructor
    public PurchaseController(Showtime showtime){
        this.showtime = showtime;
    }

    //returns an array of seats that are already occupied
    public ArrayList<Seat> getTakenSeats(){
        return DatabaseController.getTakenSeats(showtime);
    }

    //adds a purchase to the database and returns the constructed object
    public Purchase addTicketPurchase(String email, double cost){
        return DatabaseController.addPurchase(email, cost);     
    }

    //validates the credentials of a credit card
    public boolean validateCreditCard(CreditCard card){
        //hypothetically check if credit card exists/is valid
        return true;
    }

    //returns total cost after credit being applied
    public double getTotalCost(String email, int numSeats){
        return numSeats * seatCost - DatabaseController.getUserCredit(email);
    }

    //this function is designed to call external payment processor
    public boolean validatePurchase(CreditCard card, double cost){
        //hypothetically user's bank performs purchase
        //returns true on success
        return card.charge(cost);
    }

    //returns false if there are over 10% seats being purchased for a non-public movie
    public boolean purchaseSeats(String email, ArrayList<Seat> seats, double totalCost, String theater){
        // at this point, users card has already been charged

        //check if movie is non-public and if 10% of seats have already been reserved
        if(!DatabaseController.moviePubliclyAvailable(showtime.getMovieName())){
            if(DatabaseController.getTakenSeats(showtime).size() + seats.size() > 8){
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
                    showtime.getTime(),
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
