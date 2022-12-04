public class CreditCard{
    private String company;
    private String number;
    private int expiryDate;
    private int cvv;

    public CreditCard(String company, String number, int expiryDate, int cvv){
        this.company = company;
        this.number = number;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public CreditCard(){
        this.company = null;
        this.number = null;
        this.expiryDate = 0;
        this.cvv = 0;
    }

    public String getCompany() {
        return company;
    }

    public String getNumber() {
        return number;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public boolean charge(double amount){
        // call this anytime a card is charged
        System.out.print("Card Number " + this.number + " was charged $" + amount +".");
        return true;
    }
}