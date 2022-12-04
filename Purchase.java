import java.util.ArrayList;
import java.sql.Date;

public class Purchase {
    private int purchase_id;
    private String buyer_email;
    private double cost;
    private Date dateOfPurchase;

    public Purchase(int id, String email, double amount){
        purchase_id = id;
        buyer_email = email;
        cost = amount;
    }

    public Purchase(String email, double cost){
        this.buyer_email = email;
        this.cost = cost;
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

    public Date getDate(){return this.dateOfPurchase;}
}
