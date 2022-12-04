import java.util.Date;

public class RegisteredUser extends User{
    private String email;
    private String password;
    private String address;
    private Name name;
    private double credit;
    private CreditCard card;
    private Date lastPayment;

    public RegisteredUser(String email, String password, 
            String firstName, String middleName, String lastName,
            String address, String company, String cardNumber, int cardExpiryDate, int cvv, java.sql.Date curr_date)
    {
        this.email = email;
        this.password = password;
        this.name = new Name(firstName, middleName, lastName);
        this.card = new CreditCard(company, cardNumber, cardExpiryDate, cvv);
        this.credit = 0;
        this.lastPayment = curr_date;
    }

    public RegisteredUser(String email, String password, 
        Name name, String address, CreditCard card, double credit, Date date) 
        {
            this.email = email;
            this.password = password;
            this.name = name;
            this.address = address;
            this.card = card;
            this.credit = credit;
            this.lastPayment = date;
        }

    public String getEmail(){
        return email;
    }

    public Name getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword(){
        return password;
    }

    public boolean checkMemberExpired(){
        // returns true if this user's membership has expired and their fee must be paid
        java.util.Date curDate = new java.util.Date();

        long year = Long.parseUnsignedLong("31536000000");
        if (curDate.getTime() - lastPayment.getTime() >= year){
            return true;
        }
        return false;

    }

    public boolean payMemberFee(){
        // is called by GUI if RU fee is required, returns true if fee is paid
        DatabaseController.updatePaymentDate(email);
        return this.card.charge(20.00);
    }
}
