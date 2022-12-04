public class User {
    protected String email;
    protected double credit;
    

    public User(){
        email = "";
        credit = -1;
    }

    public String getEmail(){
        return this.email;
    }
    public double getCredit(){
        return this.credit;
    }
    
}
