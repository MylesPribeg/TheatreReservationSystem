public class Name {
    String firstName;
    String middleName;
    String lastName;

    public Name(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirst() {return firstName;}
    public String getLast() {return lastName;}
    public String getMiddle() {return middleName;}


    public String getNameString() {
        return String.format("%s %s %s", firstName, middleName, lastName);
    }
}
