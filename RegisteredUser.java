import java.util.Date;

public class RegisteredUser extends User{
    private String email;
    private String password;
    private String address;
    private String name;
    private CreditCard card;
    private Date lastPayment;

    //constructors
    public RegisteredUser(String email, String password, 
            String name,
            String address, String company, String cardNumber, int cardExpiryDate, int cvv, java.sql.Date curr_date)
    {
        this.email = email;
        this.password = password;
        this.name = name;
        this.card = new CreditCard(company, cardNumber, cardExpiryDate, cvv);
        this.credit = 0;
        this.lastPayment = curr_date;
    }

    public RegisteredUser(String email, String password, 
        String name, String address, CreditCard card, double credit, Date date) 
        {
            this.email = email;
            this.password = password;
            this.name = name;
            this.address = address;
            this.card = card;
            this.credit = credit;
            this.lastPayment = date;
        }
    
    //getters and setters
    public CreditCard getCreditCard() {return card;}
    public String getEmail(){return email;}
    public String getName() {return name;}
    public String getAddress() {return address;}
    public String getPassword(){return password;}

    public void setEmail(String email){this.email = email;}
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setCreditCard(CreditCard card){this.card = card;}

    public Date getLastPayment() {
        return lastPayment;
    }

    //checks if a member has paid their annual fee
    public boolean checkMemberExpired(){
        // returns true if this user's membership has expired and their fee must be paid
        java.util.Date curDate = new java.util.Date();

        long year = Long.parseUnsignedLong("31536000000");
        if (curDate.getTime() - lastPayment.getTime() >= year){
            return true;
        }
        return false;

    }

    //pays annual fee
    public boolean payMemberFee(){
        // is called by GUI if RU fee is required, returns true if fee is paid
        DatabaseController.updatePaymentDate(email);
        return this.card.charge(20.00);
    }
}
