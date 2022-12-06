public class Staff{
    private String name;
    private String jobTitle;

    //constructor
    public Staff(String name, String jobTitle){
        this.name = name;
        this.jobTitle = jobTitle;
    }

    //getters and setters
    public String getName(){return name;}
    public String getJob(){return jobTitle;}

    public void setName(String name){this.name = name;}
    public void setJob(String job){this.jobTitle = job;}
}