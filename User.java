public class User {
    protected String email;
    protected double credit;
    
    //constructors
    public User(String email, double credit) {
        this.email = email;
        this.credit = credit;
    }

    public User(){
        email = "";
        credit = -1;
    }

    //getters
    public String getEmail(){
        return this.email;
    }
    public double getCredit(){
        return this.credit;
    }
    
}
