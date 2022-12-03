import java.util.ArrayList;

public class Purchase {
    private int purchase_id;
    private String buyer_email;
    private double cost;
    private ArrayList<Ticket> tickets;

    public Purchase(int id, String email, double amount){
        purchase_id = id;
        buyer_email = email;
        cost = amount;
    }

    public void addTicket(Ticket t){
        this.tickets.add(t);
    }

    public int getID(){
        return purchase_id;
    }

    public String getEmail(){
        return buyer_email;
    }

    public double getAmount(){
        return cost;
    }
}
