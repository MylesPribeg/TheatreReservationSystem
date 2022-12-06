public class CreditCard{
    private String company;
    private String number;
    private int expiryDate;
    private int cvv;

    //constructors
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

    //getters
    public String getCompany() {return company;}
    public String getNumber() {return number;}
    public int getExpiryDate() {return expiryDate;}
    public int getCvv() {return cvv;}

    // call this anytime a card is charged
    public boolean charge(double amount){
        System.out.print("Card Number " + this.number + " was charged $" + amount +".");
        return true;
    }
}