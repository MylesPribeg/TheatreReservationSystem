public class User {
    protected String email;
    protected int credit;
    

    public User(){
        email = "";
        credit = -1;
    }

    public String getEmail(){
        return this.email;
    }
    public int getCredit(){
        return this.credit;
    }
    
    public void cancelTickets(String email){
        // find purchase under given email
        // find all tickets with that purchase id
        

    }
}
