import java.util.ArrayList;

public class PurchaseController {
    private Showtime showtime;

    public PurchaseController(Showtime showtime){
        this.showtime = showtime;
    }

    public ArrayList<Seat> getTakenSeats(){
        return DatabaseController.getTakenSeats(showtime);
    }

    public Purchase addTicketPurchase(String email, int numTickets){

        return DatabaseController.addPurchase(email, numTickets*20.00);       
    }

    public boolean validateCreditCard(CreditCard card){
        //hypothetically check if credit card exists/is valid
        return true;
    }

    public boolean validatePurchase(CreditCard card, double price){
        //hypothetically user's bank performs purchase
        //returns true on success
        return card.charge(price);
    }

    public void purchaseSeats(String email, ArrayList<Seat> seats, CreditCard card){
        // at this point, users card has already been charged

        Purchase newPurchase = addTicketPurchase(email, seats.size());

        //ArrayList<Ticket> tickets = new ArrayList<>();

        for(Seat seat: seats){

            Ticket newTicket = new Ticket(
                    newPurchase.getID(), 
                    seat.getSeatId(),
                    newPurchase.getDate(),
                    seat.getRoomName());
            
            DatabaseController.addTicket(newTicket);
        }

        // send email with tickets
        EmailController.sendPurchaseReceipt(showtime, email, seats);

    }
    
}
