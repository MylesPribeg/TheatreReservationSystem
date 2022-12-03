import java.time.LocalDate;

public class RegisteredUser extends User{
    private String email;
    private String password;
    private String address;
    private Name name;
    private double credit;
    private CreditCard card;
    private LocalDate lastPayment;

    public RegisteredUser(String email, String password, 
            String firstName, String middleName, String lastName,
            String address, String company, int cardNumber, int cardExpiryDate, int cvv, LocalDate curr_date)
    {
        this.email = email;
        this.password = password;
        this.name = new Name(firstName, middleName, lastName);
        this.card = new CreditCard(company, cardNumber, cardExpiryDate, cvv);
        this.credit = 0;
        this.lastPayment = curr_date;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public boolean checkMemberExpired(){
        // returns true if this user's membership has expired and their fee must be paid
        LocalDate today = LocalDate.now();
        int yearDif = today.getYear() - this.lastPayment.getYear();
        if (yearDif == 1){
            if (today.getDayOfYear() - this.lastPayment.getDayOfYear() >= 0){
                return true;
            }
        }
        else if (yearDif >= 2){
            return true;
        }
        return false;

    }

    public boolean payMemberFee(){
        // is called by GUI if RU fee is required, returns true if fee is paid
        return this.card.charge(20.00);
    }
}
