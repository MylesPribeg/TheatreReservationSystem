public class Staff{
    private Name name;
    private String jobTitle;

    public Staff(String firstName, String middleName, String lastName, String jobTitle){
        this.name = new Name(firstName, middleName, lastName);
        this.jobTitle = jobTitle;
    }

    public Name getName(){
        return name;
    }

    public String getJob(){
        return jobTitle;
    }
}